package com.sample.restapi.exception;

public class CustomException extends RuntimeException {

	private String message;

	public CustomException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
