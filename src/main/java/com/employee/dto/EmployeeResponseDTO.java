package com.employee.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(Include.NON_NULL)
public class EmployeeResponseDTO {
	private Integer id;

	@ToString.Exclude
	private String email;

	private String name;

	@ToString.Exclude
	private String teamName;

	@ToString.Exclude
	private Integer salary;

	@ToString.Exclude
	private Date createdAt;

	@ToString.Exclude
	private Date lastUpdatedAt;

}
