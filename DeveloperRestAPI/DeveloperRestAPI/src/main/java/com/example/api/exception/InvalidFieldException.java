package com.example.api.exception;

public class InvalidFieldException {

	private String message;

	public InvalidFieldException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
