package com.employee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.employee.annotation.PasswordMatches;
import com.employee.dto.EmployeeRegisterationRequestDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object employeeDTO, ConstraintValidatorContext context) {
		EmployeeRegisterationRequestDTO employeeRegisterationRequestDTO = (EmployeeRegisterationRequestDTO) employeeDTO;
		return employeeRegisterationRequestDTO.getPassword()
				.equals(employeeRegisterationRequestDTO.getConfirmPassword());
	}

}
