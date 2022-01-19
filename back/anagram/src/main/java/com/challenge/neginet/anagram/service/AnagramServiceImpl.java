package com.challenge.neginet.anagram.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.neginet.anagram.dao.IAnagramDao;
import com.challenge.neginet.anagram.domain.Anagram;
import com.challenge.neginet.anagram.domain.AnagramDicc;
import com.challenge.neginet.anagram.dto.AnagramDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnagramServiceImpl implements IAnagramService {

	@Autowired
	private IAnagramDao anagramDao;

	@Override
	public List<Anagram> findAll() {
		return (List<Anagram>) anagramDao.findAll();
	}

	@Override
	public Anagram save(Anagram anagram) {
		return anagramDao.save(anagram);
	}

	public Map<String, Set<String>> getAnagrams(List<String> words) {
		Map<String, Set<String>> dictionary = new HashMap<>();

		for (int i = 0; i < words.size(); i++) {

			String word = words.get(i);
			String wordSorted = sortWord(word);

			Set<String> conjunto = new HashSet<>();

			if (!dictionary.containsKey(wordSorted)) {
				conjunto.add(word);
				dictionary.put(wordSorted, conjunto);
			} else {
				dictionary.get(wordSorted).add(word);
			}
		}

		return dictionary;
	}

	public String sortWord(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public void printDictionary(Map<String, Set<String>> dictionary) {

		for (String key : dictionary.keySet()) {
			System.out.println(key + " = " + dictionary.get(key));
		}

	}

	public boolean evaluateAnagrams(String words) {
		List<String> inputList = Arrays.asList(words.split(","));

		Anagram anagram = new Anagram();

		try {
			String json = new ObjectMapper()
					.writeValueAsString(getAnagrams(inputList));
			System.out.println("Saving JSON: " + json);

			anagram.setResults(json.toString());

		} catch (JsonProcessingException e) {
			System.err.println(e);
		}

		return !(save(anagram) == null);
	}

	public List<AnagramDTO> getResults() {
		List<Anagram> res = findAll();

		List<AnagramDTO> list = new ArrayList<>();

		res.forEach((e) -> {
			String jsonResults = e.getResults();

			try {
				@SuppressWarnings("unchecked")
				Map<String, List<String>> map = new ObjectMapper()
						.readValue(jsonResults, HashMap.class);

				List<AnagramDicc> results = new ArrayList<>();

				map.forEach((k, w) -> {
					AnagramDicc anagramDicc = new AnagramDicc(k, w);
					results.add(anagramDicc);
				});

				AnagramDTO anagramDTO = new AnagramDTO(e.getId(), results);
				list.add(anagramDTO);

			} catch (JsonProcessingException e1) {
				System.err.println(e);
			}

		});

		return list;
	}

}
