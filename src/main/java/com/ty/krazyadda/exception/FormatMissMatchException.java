package com.ty.krazyadda.exception;

public class FormatMissMatchException  extends RuntimeException{
	String message="Format is miss match";
	public FormatMissMatchException()
	{
		
	}
	public FormatMissMatchException(String message) {
		this.message= message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
