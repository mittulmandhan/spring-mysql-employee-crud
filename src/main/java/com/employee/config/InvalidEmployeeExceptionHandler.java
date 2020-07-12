package com.employee.config;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.exception.InvalidEmployeeException;

@ControllerAdvice
public class InvalidEmployeeExceptionHandler {
	@ExceptionHandler(value = InvalidEmployeeException.class)
	public @ResponseBody String handleInvalidEmployeeException() {
		return "Employee does not exist!";
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	public @ResponseBody String handleEntityNotFoundException() {
		return "Employee does not exist!!!!";
	}

}
