package com.example.learning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleGlobalException(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(),e.getMessage()));
		
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity handleGlobalException(BusinessException be) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(be.getCode(),be.getMessage()));
		
	}
	
	
	

}
