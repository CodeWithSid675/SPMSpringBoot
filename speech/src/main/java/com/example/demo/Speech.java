package com.example.demo;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speech {

	@Id
    private String id;
	private String userId;
	private String author;
	private String date;
	private String subjectKeyword;
	private String speechContent;
	
	public String getAuthor() {
		return author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSubjectKeyword() {
		return subjectKeyword;
	}
	public void setSubjectKeyword(String subjectKeyword) {
		this.subjectKeyword = subjectKeyword;
	}
	public String getSpeechContent() {
		return speechContent;
	}
	public void setSpeechContent(String speechContent) {
		this.speechContent = speechContent;
	}
	
	
}
