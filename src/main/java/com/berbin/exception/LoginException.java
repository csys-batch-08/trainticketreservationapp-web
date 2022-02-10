package com.berbin.exception;

public class LoginException extends Exception {
	
String errorMessage="Invalid Username or Password";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}
