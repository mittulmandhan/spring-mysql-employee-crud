package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRegisterationRequestDTO;
import com.employee.dto.EmployeeRegisterationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;

public interface EmployeeService {
	public List<EmployeeResponseDTO> getAll();

	public EmployeeResponseDTO get(final Integer id);

	public EmployeeResponseDTO add(final EmployeeRequestDTO employee);
	
	public EmployeeRegisterationResponseDTO employeeRegisteration(final EmployeeRegisterationRequestDTO employeeRegisterRequest);

	public EmployeeResponseDTO update(final EmployeeRequestDTO employee);

	public void delete(final Integer id);
}
