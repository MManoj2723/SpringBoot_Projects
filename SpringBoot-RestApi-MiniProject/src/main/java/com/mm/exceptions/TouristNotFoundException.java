package com.mm.exceptions;

@SuppressWarnings("serial")
public class TouristNotFoundException extends RuntimeException{
	
	public TouristNotFoundException(String errMsg) {
		super(errMsg);
	}
}
