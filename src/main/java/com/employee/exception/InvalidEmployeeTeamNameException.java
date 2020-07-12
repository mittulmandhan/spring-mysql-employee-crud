package com.employee.exception;

public class InvalidEmployeeTeamNameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmployeeTeamNameException() {
	}
	
	public InvalidEmployeeTeamNameException(String string) {
		super(string);
	}
}
