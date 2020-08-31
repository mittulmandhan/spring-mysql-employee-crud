package com.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.model.Employee;

public interface EmployeeService {
	public List<EmployeeResponseDTO> getAll();
	
	public Page<Employee> getPaged(Pageable pageable);
	
	public List<EmployeeResponseDTO> getSorted();
	
	public Page<Employee> getPagedAndSorted(Pageable pageable);

	public EmployeeResponseDTO get(final Integer id);

	public EmployeeResponseDTO add(final EmployeeRequestDTO employee);
	
	public EmployeeRegistrationResponseDTO employeeRegisteration(final EmployeeRegistrationRequestDTO employeeRegisterRequest);

	public EmployeeResponseDTO update(final EmployeeRequestDTO employee);

	public void delete(final Integer id);
}
