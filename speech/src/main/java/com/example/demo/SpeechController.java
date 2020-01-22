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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/speeches")
public class SpeechController {
	
	@Autowired
	SpeechService speechService;
	
	@GetMapping
	public List<Speech> getSpeeches(){
		return speechService.getSpeech();
	}
	
	@GetMapping("/{mailId}")
	public List<Speech> getSpeeches(@PathVariable String mailId){
		List<Speech> src = speechService.getSpeechByMailId(mailId.trim());
		return src;
	}
	
	@PostMapping
	public void postSpeech(@RequestBody Speech speech) {
		speechService.add(speech);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSpeech(@PathVariable(required = true) String id) {
		speechService.delete(id);
	}
	
	@PutMapping 
	public void updateSpeech(@RequestBody Speech speech) {
		speechService.update(speech);
	}
	
	@PostMapping("/sendmail")
	public void sendMail(@RequestBody SpeechMail speechMail) {		
		speechService.sendMail(speechMail);
	}
	
	@PostMapping("/signup")
	public Object signUp(@RequestBody Users users) {
		Object map = speechService.signupUsers(users);
		return map;
	}
	
	@PostMapping("/login")
	public Object login(@RequestBody Users users) {  
		Object response = speechService.loginUser(users);
		return response;
	}
	
}
