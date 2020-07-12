package com.employee.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.exception.InvalidEmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeResponseDTO> getAll() {
		List<Employee> employeeList = employeeRepository.findAll();
		List<EmployeeResponseDTO> employeeResponseList = new ArrayList<>();
		Iterator<Employee> i = employeeList.iterator();

		while (i.hasNext()) {
			Employee emp = i.next();
			EmployeeResponseDTO empResponse = prepareEmployeeResponseDTO(emp);

			// put EmployeeResponseDTO object in employeeResponseList
			employeeResponseList.add(empResponse);
		}

		return employeeResponseList;
	}

	public EmployeeResponseDTO get(final Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee emp = optional.get();

		EmployeeResponseDTO empResponse = prepareEmployeeResponseDTO(emp);

		return empResponse;
	}

	public EmployeeResponseDTO add(final EmployeeRequestDTO employeeDTO) {
		Employee employee = prepareEmployee(employeeDTO);
		// employee added and response received in emp
		Employee emp = employeeRepository.save(employee);

		EmployeeResponseDTO empResponse = prepareEmployeeResponseDTO(emp);

		return empResponse;
	}

	public EmployeeResponseDTO update(final EmployeeRequestDTO employeeDTO) {

		if (employeeDTO.getId() == null)
			throw new InvalidEmployeeException("Employee Id Invalid! " + employeeDTO.getId());
		else if (employeeRepository.getOne(employeeDTO.getId()) == null)
			throw new InvalidEmployeeException("Employee does not exist! " + employeeDTO.getId());

		Employee employee = prepareEmployee(employeeDTO);
		// employee updated and response received in emp
		Employee emp = employeeRepository.save(employee);

		EmployeeResponseDTO empResponse = prepareEmployeeResponseDTO(emp);

		return empResponse;
	}

	public void delete(final Integer id) {
		employeeRepository.deleteById(id);
	}

	private EmployeeResponseDTO prepareEmployeeResponseDTO(Employee emp) {
		EmployeeResponseDTO empResponse = new EmployeeResponseDTO();

		// convert Employee to EmployeeResponseDTO
		empResponse.setId(emp.getId());
		empResponse.setName(emp.getName());
		empResponse.setSalary(emp.getSalary());
		empResponse.setTeamName(emp.getTeamName());
		empResponse.setCreatedAt(emp.getCreatedAt());
		empResponse.setLastUpdatedAt(emp.getLastUpdatedAt());
		return empResponse;
	}

	private Employee prepareEmployee(final EmployeeRequestDTO employeeDTO) {
		Employee employee = new Employee();

		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setSalary(employeeDTO.getSalary());
		employee.setTeamName(employeeDTO.getTeamName());
		return employee;
	}

}
