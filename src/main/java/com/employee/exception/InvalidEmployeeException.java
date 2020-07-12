package com.employee.exception;

public class InvalidEmployeeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeException() {
	}
	
	public InvalidEmployeeException(String string) {
		super(string);
	}
}
