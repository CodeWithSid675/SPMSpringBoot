package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@Component
public class SpeechService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SpeechService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
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
	
	 public void sendMail(SpeechMail speechMail) throws MailException{
//		 System.out. println("You entered string speechMail ==> "+speechMail.getMailAddress()+speechMail.getSenderAddress()+speechMail.getData());
         SimpleMailMessage mail = new SimpleMailMessage();
          
         mail.setTo(speechMail.getMailAddress());
         mail.setFrom(speechMail.getSenderAddress());
         mail.setSubject(speechMail.getData().getAuthor()+"-"+speechMail.getData().getSubjectKeyword()+"-"+speechMail.getData().getDate());
         mail.setText(speechMail.getData().getSpeechContent());
          
         javaMailSender.send(mail);
         }      
	
}
