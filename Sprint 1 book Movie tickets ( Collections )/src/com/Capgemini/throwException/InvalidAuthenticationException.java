package com.Capgemini.throwException;

public class InvalidAuthenticationException extends Exception {
	public InvalidAuthenticationException(String errorMsg) {
		super(errorMsg);
	}
}
