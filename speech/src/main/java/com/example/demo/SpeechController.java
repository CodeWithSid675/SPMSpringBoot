package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speeches")
public class SpeechController {
	
	@Autowired
	SpeechService speechService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Speech> getSpeeches(){
		return speechService.getSpeech();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public void postSpeech(@RequestBody Speech speech) {
		speechService.add(speech);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public void deleteSpeech(@PathVariable(required = true) String id) {
		speechService.delete(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping 
	public void updateSpeech(@RequestBody Speech speech) {
		speechService.update(speech);
	}
	
	
}
