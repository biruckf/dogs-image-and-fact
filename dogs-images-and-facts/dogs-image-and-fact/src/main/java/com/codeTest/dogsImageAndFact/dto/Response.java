package com.codeTest.dogsImageAndFact.dto;

import org.springframework.http.HttpStatus;

public class Response {

	 private String message;
	 private HttpStatus status;
	 private ErrorCode errorCode;
	 
	 
	public Response() {
	
	}
	
	public Response(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	public Response(String message, HttpStatus status, ErrorCode errorCode) {
		super();
		this.message = message;
		this.status = status;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	 
	 
}
