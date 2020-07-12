package com.employee.config;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.exception.InvalidEmployeeIDException;
import com.employee.exception.InvalidEmployeeNameException;
import com.employee.exception.InvalidEmployeeSalaryException;
import com.employee.exception.InvalidEmployeeTeamNameException;

@ControllerAdvice
public class InvalidEmployeeExceptionHandler {
	@ExceptionHandler(value = InvalidEmployeeIDException.class)
	public @ResponseBody String handleInvalidEmployeeIDException() {
		return "Employee ID Invalid!";
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	public @ResponseBody String handleEntityNotFoundException() {
		return "Employee Does Not Exist!";
	}

	@ExceptionHandler(value = InvalidEmployeeNameException.class)
	public @ResponseBody String handleInvalidEmployeeNameException() {
		return "Invalid Employee Name!";
	}

	@ExceptionHandler(value = InvalidEmployeeTeamNameException.class)
	public @ResponseBody String handleInvalidEmployeeTeamNameException() {
		return "Invalid Employee Team Name!";
	}

	@ExceptionHandler(value = InvalidEmployeeSalaryException.class)
	public @ResponseBody String handleInvalidEmployeeSalaryException() {
		return "Invalid Employee Salary!";
	}

}
