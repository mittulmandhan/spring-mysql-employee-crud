package com.employee.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.employee.exception.InvalidEmployeeIDException;

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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
