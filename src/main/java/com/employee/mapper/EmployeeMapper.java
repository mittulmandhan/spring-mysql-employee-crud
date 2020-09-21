package com.employee.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

	@Mappings({@Mapping(target = "name", source = "dto.firstName")})
	Employee requestDTOToEmployee(EmployeeRegistrationRequestDTO dto);
	List<Employee> requestDTOToEmployee(List<EmployeeRegistrationRequestDTO> dto);
	
	EmployeeRegistrationResponseDTO employeeToResponseDTO(Employee entity);
	
}
