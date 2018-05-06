package com.nlpia.document;

import java.util.List;

public class Document {

	private String text;
	private List<Sentence> sentences;
	private List<Paragraph> paragraphs;
	private List<Coreference> coreferences;
	private List<Token> tokens;
	private List<Token> tokensWithoutStopWords;
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public List<Sentence> getSentences() {
		return sentences;
	}
	
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}
	
	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
	
	public List<Coreference> getCoreferences() {
		return coreferences;
	}
	
	public void setCoreferences(List<Coreference> coreferences) {
		this.coreferences = coreferences;
	}
	
	public List<Token> getTokens() {
		return tokens;
	}
	
	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}
	
	public List<Token> getTokensWithoutStopWords() {
		return tokensWithoutStopWords;
	}
	
	public void setTokensWithoutStopWords(List<Token> tokensWithoutStopWords) {
		this.tokensWithoutStopWords = tokensWithoutStopWords;
	}

}
