package com.codewithabbas.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RescourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	int fieldValue;
	
	
	
	public RescourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
		

}
