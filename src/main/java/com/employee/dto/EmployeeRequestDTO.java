package com.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestDTO {
	private Integer id;

	private String name;

	private String teamName;

	private Integer salary;

}
