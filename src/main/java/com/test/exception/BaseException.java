package com.test.exception;

public class BaseException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BaseException(String message) {
		super();
		this.message = message;
	}
	

}
