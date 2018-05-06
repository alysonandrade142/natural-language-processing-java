package com.nlpia.document;

public class Token {

	private long id;
	private String content;
	private String stemming;
	private String posClass;
	private String type;
	private String ner;
	private long idSentence;
	private int startPosition;
	private int endPosition;
	private boolean isStopWord;
	private boolean isPartNER;
	
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
	
	public String getStemming() {
		return stemming;
	}
	
	public void setStemming(String stemming) {
		this.stemming = stemming;
	}
	
	public String getPosClass() {
		return posClass;
	}
	
	public void setPosClass(String posClass) {
		this.posClass = posClass;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNer() {
		return ner;
	}
	
	public void setNer(String ner) {
		this.ner = ner;
	}
	
	public long getIdSentence() {
		return idSentence;
	}
	
	public void setIdSentence(long idSentence) {
		this.idSentence = idSentence;
	}
	
	public int getStartPosition() {
		return startPosition;
	}
	
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	
	public int getEndPosition() {
		return endPosition;
	}
	
	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
	
	public boolean isStopWord() {
		return isStopWord;
	}
	
	public void setStopWord(boolean isStopWord) {
		this.isStopWord = isStopWord;
	}
	
	public boolean isPartNER() {
		return isPartNER;
	}
	
	public void setPartNER(boolean isPartNER) {
		this.isPartNER = isPartNER;
	}
	
	@Override
	public String toString() {
		return "TOKEN: " + this.id + ", Content:" + this.content;
	}
	
}
