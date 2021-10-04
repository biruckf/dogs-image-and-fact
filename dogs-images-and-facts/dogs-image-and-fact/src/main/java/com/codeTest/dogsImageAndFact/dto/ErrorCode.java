package com.codeTest.dogsImageAndFact.dto;

public class ErrorCode {
	private String numberCode;
	private String textCode;
	
	
	public ErrorCode() {
		
	}


	public ErrorCode(String numberCode, String textCode) {
		this.numberCode = numberCode;
		this.textCode = textCode;
	}


	public String getNumberCode() {
		return numberCode;
	}


	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}


	public String getTextCode() {
		return textCode;
	}


	public void setTextCode(String textCode) {
		this.textCode = textCode;
	}
	
	
	
	
}
