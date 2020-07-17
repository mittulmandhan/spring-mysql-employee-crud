package com.employee.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRegisterationResponseDTO {
	
	private Integer id;
	
	private String email;

	private String name;

	private String teamName;
	
	private Date createdAt;

}
