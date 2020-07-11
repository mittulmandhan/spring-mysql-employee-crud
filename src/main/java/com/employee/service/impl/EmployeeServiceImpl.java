package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee get(final Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		return optional.get();
	}

	public Employee add(final EmployeeRequestDTO employeeDTO) {
		Employee employee = prepareEmployee(employeeDTO);
		return employeeRepository.save(employee);
	}

	public Employee update(final EmployeeRequestDTO employeeDTO) {
		Employee employee = prepareEmployee(employeeDTO);
		return employeeRepository.save(employee);
	}

	private Employee prepareEmployee(final EmployeeRequestDTO employeeDTO) {
		Employee employee = new Employee();
		if (employeeDTO.getId() != null)
			employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setSalary(employeeDTO.getSalary());
		employee.setTeamName(employeeDTO.getTeamName());
		return employee;
	}

	public void delete(final Integer id) {
		employeeRepository.deleteById(id);
	}

}
