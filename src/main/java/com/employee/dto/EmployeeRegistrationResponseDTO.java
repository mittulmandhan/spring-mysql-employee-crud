package com.employee.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeRegistrationResponseDTO {
	
	private Integer id;
	
	@ToString.Exclude
	private String email;
	
	private String name;
	
	@ToString.Exclude
	private String teamName;
	
	@ToString.Exclude
	private Date createdAt;

}
