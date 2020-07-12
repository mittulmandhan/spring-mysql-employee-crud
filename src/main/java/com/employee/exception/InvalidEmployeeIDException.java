package com.employee.exception;

public class InvalidEmployeeIDException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeIDException() {
	}
	
	public InvalidEmployeeIDException(String string) {
		super(string);
	}
}
