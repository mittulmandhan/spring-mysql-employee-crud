package com.employee.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRegisterationRequestDTO {

	@NotBlank(message = "email cannot be blank")
	private String email;

	@NotBlank(message = "first name cannot be blank")
	private String firstName;

	@NotBlank(message = "last name cannot be blank")
	private String lastName;

	@NotBlank(message = "team name cannot be blank")
	private String teamName;

	@NotBlank(message = "password cannot be blank")
	private String password;

	@NotBlank(message = "please confirm password")
	private String confirmPassword;

}
