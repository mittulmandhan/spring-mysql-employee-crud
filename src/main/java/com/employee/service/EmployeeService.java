package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee get(final Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		return optional.get();
	}

	public Employee add(final Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(final Employee employee) {
		return employeeRepository.save(employee);
	}

	public void delete(final Integer id) {
		employeeRepository.deleteById(id);
	}

}
