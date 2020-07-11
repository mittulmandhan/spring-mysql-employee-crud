package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.model.Employee;

public interface EmployeeService {
	public List<Employee> getAll();

	public Employee get(final Integer id);

	public Employee add(final EmployeeRequestDTO employee);

	public Employee update(final EmployeeRequestDTO employee);
	
	public void delete(final Integer id);
}
