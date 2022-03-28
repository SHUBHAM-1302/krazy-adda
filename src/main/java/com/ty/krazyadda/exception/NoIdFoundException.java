package com.ty.krazyadda.exception;

public class NoIdFoundException extends RuntimeException{
	String message="no Hospital Found By give Id";
	public NoIdFoundException() {
		
	}
	public NoIdFoundException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
