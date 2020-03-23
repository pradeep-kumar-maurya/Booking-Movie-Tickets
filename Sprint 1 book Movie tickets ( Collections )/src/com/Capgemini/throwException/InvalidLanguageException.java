package com.Capgemini.throwException;

public class InvalidLanguageException extends Exception {
	public InvalidLanguageException(String errorMsg) {
		super(errorMsg);
	}
}
