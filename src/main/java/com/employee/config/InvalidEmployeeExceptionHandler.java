package com.employee.config;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.exception.InvalidEmployeeIDException;
import com.employee.exception.InvalidEmployeeNameException;

@ControllerAdvice
public class InvalidEmployeeExceptionHandler {
	@ExceptionHandler(value = InvalidEmployeeIDException.class)
	public @ResponseBody String handleInvalidEmployeeIDException() {
		return "Employee ID Invalid!";
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	public @ResponseBody String handleEntityNotFoundException() {
		return "Employee does not exist!";
	}

	@ExceptionHandler(value = InvalidEmployeeNameException.class)
	public @ResponseBody String handleInvalidEmployeeNameException() {
		return "Invalid Employee Name!";
	}

}
