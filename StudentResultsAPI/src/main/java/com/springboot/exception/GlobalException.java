package com.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,WebRequest request)
	{
		ErrorDetails details= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception ex,WebRequest request)
	{
		ErrorDetails details= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		ErrorDetails details= new ErrorDetails(new Date(), "Validation failed...", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(details, status.BAD_REQUEST);
	}
	
}
