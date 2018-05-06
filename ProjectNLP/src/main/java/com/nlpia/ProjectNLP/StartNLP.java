package com.nlpia.ProjectNLP;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.nlpia.document.Document;
import com.nlpia.document.Sentence;
import com.nlpia.document.Token;
import com.nlpia.utils.Utils;

import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class StartNLP {

	private static StartNLP nlp;
	private static StanfordCoreNLP core;
	private Set<String> stopList;
	private static File article;

	public StartNLP() {

		stopList = new HashSet<String>();
		File stopListFile = new File("src/main/resources/StopList.txt");
		
		article = new File("src/main/resources/article.txt");

		try {
			stopList.addAll(Utils.loadSetOfWords(stopListFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		nlp = new StartNLP();
		nlp.start();
	}

	private void start() {

		Properties prop = new Properties();
		prop.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
		prop.setProperty("ssplit.newlineIsSentenceBreak", "always");
		core = new StanfordCoreNLP(prop);

		Document doc = new Document();
		doc.setText(Utils.readTxtFile(this.article));
		this.printSentences(this.processDocument(doc));
	}

	private Document processDocument(Document doc) {
		Annotation annotation = new Annotation(doc.getText());
		core.annotate(annotation);
		// Processando a classe Sentences.
		processSentences(doc, annotation);

		return doc;
	}

	private Document processSentences(Document doc, Annotation annotation) {

		List<CoreMap> sentencesStanford = annotation.get(SentencesAnnotation.class);
		List<Sentence> sentences = new ArrayList<Sentence>();

		long i = 1;

		for (CoreMap sent : sentencesStanford) {
			Sentence sentence = new Sentence();
			sentence.setId(i++);
			sentence.setContent(sent.toString());
			this.processToken(sent, sentence);
			sentences.add(sentence);
		}

		doc.setSentences(sentences);
		return doc;
	}

	private void processToken(CoreMap sStanford, Sentence sentence) {

		List<CoreLabel> coreLabels = sStanford.get(TokensAnnotation.class);

		long idToken = 1;

		for (CoreLabel tokenStanford : coreLabels) {

			String pos = tokenStanford.get(PartOfSpeechAnnotation.class);
			String lemma = tokenStanford.lemma();

			Token token = new Token();
			token.setId(idToken++);
			token.setPosClass(pos);
			token.setStemming(lemma);
			token.setIdSentence(sentence.getId());
			token.setContent(tokenStanford.originalText());
			token.setEndPosition(tokenStanford.endPosition());
			token.setStartPosition(tokenStanford.beginPosition());

			if (tokenStanford.ner() != null && !tokenStanford.ner().equalsIgnoreCase("O")) {
				token.setNer(tokenStanford.ner());
			}

			String type = Utils.checkTokenType(token);

			if ("Symbol".equalsIgnoreCase(type) || stopList.contains(token.getContent().toLowerCase())) {
				token.setStopWord(true);
			}

			token.setType(type);

			if (!token.isStopWord()) {
				sentence.addTokenWithoutStopWords(token);
			}

			sentence.addToken(token);
		}

	}

	private void printSentences(Document doc) {
		for (Sentence sent : doc.getSentences()) {
			System.out.println(sent.toString());
			this.printTokens(sent);
		}
	}

	private void printTokens(Sentence sent) {
		for (Token token : sent.getTokens()) {
			System.out.println(token.toString());
		}
	}

}
