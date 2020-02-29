package com.bruno.dev.spring.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		super( "Id does not exist!" );
	}
}
