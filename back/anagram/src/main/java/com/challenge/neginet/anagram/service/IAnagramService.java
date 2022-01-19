package com.challenge.neginet.anagram.service;

import java.util.List;

import com.challenge.neginet.anagram.domain.Anagram;

public interface IAnagramService {

	public List<Anagram> findAll();

	public Anagram save(Anagram anagram);
}
