package com.sjoedwards.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exp) {
				
		HttpStatus status = HttpStatus.NOT_FOUND;
	
		
		// create StudentErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(status.value());
		error.setMessage(exp.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<>(error, status);
	}
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler(value= {IllegalArgumentException.class})
	public ResponseEntity<CustomerErrorResponse> handleException(RuntimeException exp) {
				
		HttpStatus status= HttpStatus.BAD_REQUEST;
	
		
		// create StudentErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(status.value());
		error.setMessage(exp.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<>(error, status);
	}

	
//	 Add another exception handler

}
