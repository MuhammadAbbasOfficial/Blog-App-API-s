package com.codewithabbas.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(RescourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(RescourceNotFoundException e)
	{
		String message = e.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		Map<String, String> validMap = new HashMap<>();
		
		e.getBindingResult().getAllErrors().forEach(error->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			
			validMap.put(fieldName, message);
			
		});
		
		
		return new ResponseEntity<Map<String, String>>(validMap, HttpStatus.BAD_REQUEST);
				
	}
	

}
