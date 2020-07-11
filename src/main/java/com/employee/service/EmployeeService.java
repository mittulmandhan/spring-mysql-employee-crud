package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	public List<Employee> getAll();

	public Employee get(final Integer id);

	public Employee add(final Employee employee);

	public Employee update(final Employee employee);
	
	public void delete(final Integer id);
}
