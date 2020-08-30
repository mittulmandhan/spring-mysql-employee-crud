package com.employee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.annotation.EmailExists;

public class EmailValidator implements ConstraintValidator<EmailExists, String> {
	
	

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		// TODO: check wether the email already exist or not
		return true;
	}

}
