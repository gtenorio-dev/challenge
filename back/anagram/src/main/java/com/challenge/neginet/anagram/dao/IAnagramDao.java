package com.challenge.neginet.anagram.dao;

import org.springframework.data.repository.CrudRepository;

import com.challenge.neginet.anagram.domain.Anagram;

public interface IAnagramDao extends CrudRepository<Anagram, Integer> {

}
