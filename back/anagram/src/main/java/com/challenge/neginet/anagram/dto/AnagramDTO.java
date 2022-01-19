package com.challenge.neginet.anagram.dto;

import java.util.List;

import com.challenge.neginet.anagram.domain.AnagramDicc;

public class AnagramDTO {

	Long id;
	List<AnagramDicc> results;

	public AnagramDTO() {
	}

	public AnagramDTO(Long id, List<AnagramDicc> results) {
		this.id = id;
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AnagramDicc> getResults() {
		return results;
	}

	public void setResults(List<AnagramDicc> results) {
		this.results = results;
	}

}
