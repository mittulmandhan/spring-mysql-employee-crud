package com.employee.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestDTO {
	// on create id is null
	// on update id is value
	private Integer id;

	@Email(regexp = ".+@.+\\..+", message = "please provide a valid email address")
	@NotBlank(message = "email cannot be blank")
	private String email;

	@NotBlank(message = "name cannot be blank")
	private String name;

	@NotBlank(message = "team name cannot be blank")
	private String teamName;

	@NotNull(message = "team name cannot be blank")
	@Min(value = 1, message = "salary should be non zero +ve value")
	private Integer salary;

}
