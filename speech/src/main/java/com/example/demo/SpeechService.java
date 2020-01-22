package com.example.demo;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SpeechService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SpeechService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	SpeechRepository speechRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
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
         SimpleMailMessage mail = new SimpleMailMessage();
         mail.setTo(speechMail.getMailAddress());
         mail.setFrom(speechMail.getSenderAddress());
         mail.setSubject(speechMail.getData().getAuthor()+"-"+speechMail.getData().getSubjectKeyword()+"-"+speechMail.getData().getDate());
         mail.setText(speechMail.getData().getSpeechContent());
         javaMailSender.send(mail);
    }      
	
	public Object loginUser(Users users) {
		HashMap<String,String> map = new HashMap<>();
		try {
			Users u = usersRepository.findByEmail(users.getEmail());
			if(users.getPassword().equals(u.getPassword())){
				map.put("code","200");
				map.put("message", "Successfully Authenticated");
				return map;
			}else{
				map.put("code","204");
				map.put("message", "Wrong Password");
				return map;
			}
		}catch(NullPointerException e){
			map.put("code","400");
			map.put("message", "Mail Id doesnot exit");
			return map;
		}

	}
	
	//signup service set as unique mail in db 
	public Object signupUsers(Users users) {
		HashMap<String,String> map = new HashMap<>();
		try {
			Date today = new Date();
			users.setCreated(today);
			users.setModified(today);
			usersRepository.save(users);	
			map.put("code","200");
			map.put("message","User Successfully added");
			return map;
		}catch(DataIntegrityViolationException e) {
			map.put("code","400");
			map.put("message","User already exit");
		    return map;
		}
	}
	
	 //checking user mailid using code
//	public Map signupUsers(Users users) {
//		HashMap<String,String> map = new HashMap<>();
//		try {
//			String userMail = users.getEmail();
//			Users userData = usersRepository.findByEmail(userMail);
//			if(userData.getEmail().equals(users.getEmail())) {
//				map.put("code","400");
//				map.put("message","User already exit");
//			}
//			return map;
//		}catch(NullPointerException e){			
//			Date today = new Date();
//			System.out.println("today date :: "+today);
//			users.setCreated(today);
//			users.setModified(today);
//			usersRepository.save(users);
//			map.put("code","200");
//			map.put("message","User Successfully added");
//			return map;
//		}
//	}

	public List<Speech> getSpeechByMailId(String mailId) {
		return speechRepository.findAllByMailId(mailId.trim());
	}
}

