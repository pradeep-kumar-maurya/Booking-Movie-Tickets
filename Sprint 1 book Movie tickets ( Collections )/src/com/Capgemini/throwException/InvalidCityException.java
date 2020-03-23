package com.Capgemini.throwException;

public class InvalidCityException extends Exception {
	public InvalidCityException(String errorMsg){
		super(errorMsg);
	}
}
