package com.employee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.annotation.PasswordMatches;
import com.employee.dto.EmployeeRegistrationRequestDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object employeeDTO, ConstraintValidatorContext context) {
		EmployeeRegistrationRequestDTO employeeRegisterationRequestDTO = (EmployeeRegistrationRequestDTO) employeeDTO;
		return employeeRegisterationRequestDTO.getPassword()
				.equals(employeeRegisterationRequestDTO.getConfirmPassword());
	}

}
