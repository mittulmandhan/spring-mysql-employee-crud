package com.employee.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class EmployeeResponseDTO {
	private Integer id;
	
	private String email;

	private String name;

	private String teamName;

	private Integer salary;

	private Date createdAt;

	private Date lastUpdatedAt;

}
