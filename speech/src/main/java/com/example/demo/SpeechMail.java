package com.example.demo;

public class SpeechMail {

	private String mailAddress;
    private String senderAddress;
    private Speech data;
//    public Speech data = new Speech();
//    Speech data = new Speech();
    
    
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public Speech getData() {
		return data;
	}
	public void setData(Speech data) {
		this.data = data;
	} 
 
    
}
