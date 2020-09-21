package com.employee.mapper;

import org.mapstruct.Mapper;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeRegistrationMapper {
	Employee requestDTOToEmployee(EmployeeRegistrationRequestDTO dto);

	EmployeeRegistrationResponseDTO employeeToResponseDTO(Employee entity);
}
