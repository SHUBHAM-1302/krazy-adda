package com.ty.krazyadda.exception;

public class EmptyListException  extends RuntimeException{
	String message ="List is empty";
	public EmptyListException() {
		
	}
	public EmptyListException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
