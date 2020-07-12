package com.employee.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponseDTO {
	private Integer id;

	private String name;

	private String teamName;

	private Integer salary;

	private Date createdAt;

	private Date lastUpdatedAt;

}
