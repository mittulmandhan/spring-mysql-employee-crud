package com.employee.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
			String fieldOrObjectName;
			try {
				// if error is field level
				// such as null name, blank email, salary is not a +ve integer, etc.
				fieldOrObjectName = ((FieldError) error).getField();
			} catch (ClassCastException e) {
				// if error is object level
				// such as password does not match with confirmPassword, etc.
				fieldOrObjectName = ((ObjectError) error).getObjectName();
			}
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldOrObjectName, errorMessage);
		});
		return errors;
	}

}
