package com.challenge.neginet.anagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.neginet.anagram.dto.AnagramDTO;
import com.challenge.neginet.anagram.service.AnagramServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AnagramController {

	@Autowired
	private AnagramServiceImpl anamgramService;

	@GetMapping("/results")
	public List<AnagramDTO> getResults() {

		List<AnagramDTO> response = anamgramService.getResults();
		return response;
	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean saveAnagrams(@RequestParam(name = "words") String words) {

		System.out.println("Words:" + words);

		boolean response = false;

		if (!words.isEmpty()) {
			response = anamgramService.evaluateAnagrams(words);
		}
		return response;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

}
