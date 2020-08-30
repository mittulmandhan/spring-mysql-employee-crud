package com.employee.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.employee.annotation.PasswordMatches;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@PasswordMatches
public class EmployeeRegisterationRequestDTO {

	@Email(regexp = ".+@.+\\..+", message = "please provide a valid email address")
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
