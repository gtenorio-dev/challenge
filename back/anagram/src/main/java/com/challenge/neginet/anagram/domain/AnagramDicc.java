package com.challenge.neginet.anagram.domain;

import java.util.List;

public class AnagramDicc {

	String key;
	List<String> words;

	public AnagramDicc() {
	}

	public AnagramDicc(String key, List<String> words) {
		this.key = key;
		this.words = words;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

}
