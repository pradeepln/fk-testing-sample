package com.training.web;

public class ErrorMessage {
	int errorCode;
	String message;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
