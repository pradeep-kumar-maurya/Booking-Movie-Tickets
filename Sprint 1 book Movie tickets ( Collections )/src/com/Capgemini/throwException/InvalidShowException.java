package com.Capgemini.throwException;

public class InvalidShowException extends Exception {
	public InvalidShowException(String errorMsg) {
		super(errorMsg);
	}
}
