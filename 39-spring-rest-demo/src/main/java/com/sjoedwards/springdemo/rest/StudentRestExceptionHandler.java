package com.sjoedwards.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentRestExceptionHandler {
	// Add an exception handler using @ExceptionHandler
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {
//		
//		
//		// create StudentErrorResponse
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exp.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		
//		// Return ResponseEntity
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
	// Add another exception handler
	@ExceptionHandler()
	public ResponseEntity<StudentErrorResponse> handleException(NumberFormatException exp) {
				
		HttpStatus status;
		
		ResponseStatus annotationValue = exp.getClass().getAnnotation(ResponseStatus.class);
		
		if(annotationValue != null) {
			status = annotationValue.value();
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		// create StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(status.value());
		error.setMessage(exp.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		// Return ResponseEntity
		return new ResponseEntity<>(error, status);
	}
}


