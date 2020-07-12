package com.employee.exception;

public class InvalidEmployeeNameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeNameException() {
	}
	
	public InvalidEmployeeNameException(String string) {
		super(string);
	}
}
