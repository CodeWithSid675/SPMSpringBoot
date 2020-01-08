package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpeechService {
	
	@Autowired
	SpeechRepository speechRepository;
	
	public List<Speech> getSpeech(){
		return (List<Speech>) speechRepository.findAll();
	}
	
	public void add(Speech speech) {
		speechRepository.save(speech);
	}
	
	public void delete(String id) {
		speechRepository.deleteById(id);
	}

	public void update(Speech s) {
		Speech speech = speechRepository.findById(s.getId()).get();
		speech = s;
		speechRepository.save(speech);
	}
}
