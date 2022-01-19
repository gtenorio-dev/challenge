package com.challenge.neginet.anagram.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "anagram")
public class Anagram implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Lob
	@Column(length = 512)
	String results;

	public Anagram() {
	}

	public Anagram(Long id, String results) {
		this.id = id;
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getResults() {
		return results;
	}


	public void setResults(String results) {
		this.results = results;
	}


	private static final long serialVersionUID = 1L;
}
