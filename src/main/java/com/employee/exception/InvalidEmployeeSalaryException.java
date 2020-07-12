package com.employee.exception;

public class InvalidEmployeeSalaryException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeSalaryException() {
	}
	
	public InvalidEmployeeSalaryException(String string) {
		super(string);
	}
}
