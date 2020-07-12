package com.employee.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestDTO {

	private Integer id;

	@NotEmpty(message = "name cannot be empty")
	private String name;

	@NotEmpty(message = "team name cannot be empty")
	private String teamName;

	@NotNull
	private Integer salary;

}
