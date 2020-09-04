package com.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.employee.model.*;
import com.employee.dto.*;

@Mapper(componentModel = "spring")
public interface EmployeeRegistrationMapper {
	@Mappings({ @Mapping(target = "email", source = "dto.email"),
			@Mapping(target = "name", source = "dto.firstName"),
			@Mapping(target = "password", source = "dto.password"),
			@Mapping(target = "teamName", source = "dto.teamName") })
	Employee requestDTOToEmployee(EmployeeRegistrationRequestDTO dto);

	@Mappings({ @Mapping(target = "email", source = "entity.email"), 
			@Mapping(target = "name", source = "entity.name"),
			@Mapping(target = "id", source = "entity.id"), 
			@Mapping(target = "teamName", source = "entity.teamName"),
			@Mapping(target = "createdAt", source = "entity.createdAt") })
	EmployeeRegistrationResponseDTO employeeToResponseDTO(Employee entity);
}
