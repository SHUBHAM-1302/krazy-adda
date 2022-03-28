package com.ty.krazyadda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class KrazyAddaExceptionHandler {
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String>  handleEmptyListException(EmptyListException emptyListException) {
		String message = emptyListException.getMessage();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<String>  handleNoIdException(NoIdFoundException idFoundException) {
		String message = idFoundException.getMessage();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	
	@ExceptionHandler(FormatMissMatchException.class)
	public ResponseEntity<String>  handleFormatMissMatchException(FormatMissMatchException exception){
		String messageString= exception.getMessage();
		ResponseEntity<String> entity = new ResponseEntity<String>(messageString,HttpStatus.BAD_REQUEST);
		return entity;
	}
	

}
