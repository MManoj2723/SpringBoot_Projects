package com.mm.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")

@ResponseStatus(code=HttpStatus.MULTIPLE_CHOICES)
public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String erMsg) {
		super(erMsg);
	}
	
}
