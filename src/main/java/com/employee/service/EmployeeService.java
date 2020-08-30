package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;

public interface EmployeeService {
	public List<EmployeeResponseDTO> getAll();
	
	public List<EmployeeResponseDTO> getPaged();
	
	public List<EmployeeResponseDTO> getSorted();
	
	public List<EmployeeResponseDTO> getPagedAndSorted();

	public EmployeeResponseDTO get(final Integer id);

	public EmployeeResponseDTO add(final EmployeeRequestDTO employee);
	
	public EmployeeRegistrationResponseDTO employeeRegisteration(final EmployeeRegistrationRequestDTO employeeRegisterRequest);

	public EmployeeResponseDTO update(final EmployeeRequestDTO employee);

	public void delete(final Integer id);
}
