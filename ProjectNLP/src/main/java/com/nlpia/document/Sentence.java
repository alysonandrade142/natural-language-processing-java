package com.nlpia.document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.stanford.nlp.trees.Tree;

public class Sentence {
	
	private long id;
	private String content;
	private List<Token> tokens;
	private List<Token> tokensWithoutStopWords;
	private Set<Chunking> chunkings;
	private Set<NEREntity> nerEntities;
	private Tree syntaticTree;
	private List<DependencyRelation> dependencyRelations;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
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
	
	public Set<Chunking> getChunkings() {
		return chunkings;
	}
	
	public void setChunkings(Set<Chunking> chunkings) {
		this.chunkings = chunkings;
	}
	
	public Set<NEREntity> getNerEntities() {
		return nerEntities;
	}
	
	public void setNerEntities(Set<NEREntity> nerEntities) {
		this.nerEntities = nerEntities;
	}
	
	public Tree getSyntaticTree() {
		return syntaticTree;
	}
	
	public void setSyntaticTree(Tree syntaticTree) {
		this.syntaticTree = syntaticTree;
	}
	
	public List<DependencyRelation> getDependencyRelations() {
		return dependencyRelations;
	}
	
	public void setDependencyRelations(List<DependencyRelation> dependencyRelations) {
		this.dependencyRelations = dependencyRelations;
	}

	public boolean addToken(Token token) {
		if(this.tokens == null) {
			this.tokens = new ArrayList<Token>();
		}
		
		return this.tokens.add(token);
	}

	public boolean addTokenWithoutStopWords(Token token) {
		// TODO Auto-generated method stub
		if(this.tokensWithoutStopWords == null) {
			this.tokensWithoutStopWords = new ArrayList<Token>();
		}
		
		return this.tokensWithoutStopWords.add(token);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SENTENCE: " + this.id + ", Content:" + this.content;
	}
	
}
