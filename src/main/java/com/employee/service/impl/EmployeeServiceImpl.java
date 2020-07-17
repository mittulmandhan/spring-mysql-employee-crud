package com.employee.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRegisterationRequestDTO;
import com.employee.dto.EmployeeRegisterationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.exception.InvalidEmployeeIDException;
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

		// validations
		validateID(id);

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee emp = optional.get();

		EmployeeResponseDTO empResponse = prepareEmployeeResponseDTO(emp);

		return empResponse;
	}

	public EmployeeResponseDTO add(final EmployeeRequestDTO employeeRequest) {

		Employee employee = prepareEmployeeForAdd(employeeRequest);
		// employee added and response received in emp
		Employee emp = employeeRepository.save(employee);

		EmployeeResponseDTO employeeResponse = prepareEmployeeResponseDTO(emp);

		return employeeResponse;
	}

	public EmployeeRegisterationResponseDTO employeeRegisteration(final EmployeeRegisterationRequestDTO employeeRegisterRequest) {
		Employee employee = prepareEmployeeForRegisteration(employeeRegisterRequest);

		// employee saved in db and received response in emp
		Employee emp = employeeRepository.save(employee);

		EmployeeRegisterationResponseDTO employeeRegisterResponse = prepareEmployeeResponseForRegisteration(emp);
		
		return employeeRegisterResponse;
	}

	public EmployeeResponseDTO update(final EmployeeRequestDTO employeeRequest) {

		// validations
		validateID(employeeRequest.getId());

		Employee employee = prepareEmployeeForUpdate(employeeRequest);
		// employee updated and response received in emp
		Employee emp = employeeRepository.save(employee);

		EmployeeResponseDTO employeeResponse = prepareEmployeeResponseDTO(emp);

		return employeeResponse;
	}

	public void delete(final Integer id) {

		// validations
		validateID(id);

		employeeRepository.deleteById(id);
	}

	private EmployeeResponseDTO prepareEmployeeResponseDTO(Employee employee) {
		EmployeeResponseDTO employeeResponse = new EmployeeResponseDTO();

		// convert Employee to EmployeeResponseDTO
		employeeResponse.setId(employee.getId());
		employeeResponse.setEmail(employee.getEmail());
		employeeResponse.setName(employee.getName());
		employeeResponse.setSalary(employee.getSalary());
		employeeResponse.setTeamName(employee.getTeamName());
		employeeResponse.setCreatedAt(employee.getCreatedAt());
		employeeResponse.setLastUpdatedAt(employee.getLastUpdatedAt());
		return employeeResponse;
	}

	private EmployeeRegisterationResponseDTO prepareEmployeeResponseForRegisteration(Employee employee) {
		EmployeeRegisterationResponseDTO employeeRegisterResponse = new EmployeeRegisterationResponseDTO();

		employeeRegisterResponse.setId(employee.getId());
		employeeRegisterResponse.setName(employee.getName());
		employeeRegisterResponse.setEmail(employee.getEmail());
		employeeRegisterResponse.setTeamName(employee.getTeamName());
		employeeRegisterResponse.setCreatedAt(employee.getCreatedAt());

		return employeeRegisterResponse;
	}

	private Employee prepareEmployeeForAdd(final EmployeeRequestDTO employeeRequest) {
		Employee employee = new Employee();

		employee.setEmail(employeeRequest.getEmail());
		employee.setName(employeeRequest.getName());
		employee.setSalary(employeeRequest.getSalary());
		employee.setTeamName(employeeRequest.getTeamName());
		return employee;
	}

	private Employee prepareEmployeeForRegisteration(EmployeeRegisterationRequestDTO employeeRegisterRequest) {
		Employee employee = new Employee();

		employee.setEmail(employeeRegisterRequest.getEmail().toLowerCase());
		employee.setName(employeeRegisterRequest.getFirstName().trim().toLowerCase() + " " + employeeRegisterRequest.getLastName().trim().toLowerCase());
		employee.setTeamName(employeeRegisterRequest.getTeamName().toLowerCase());
		employee.setPassword(employeeRegisterRequest.getPassword());
		return employee;
	}

	private Employee prepareEmployeeForUpdate(EmployeeRequestDTO employeeRequest) {
		Employee employee = new Employee();

		employee.setId(employeeRequest.getId());
		employee.setName(employeeRequest.getName());
		employee.setSalary(employeeRequest.getSalary());
		employee.setTeamName(employeeRequest.getTeamName());
		return employee;
	}

	private void validateID(final Integer id) {
		if (id == null)
			throw new InvalidEmployeeIDException();
		else if (!employeeRepository.existsById(id))
			throw new EntityNotFoundException();
	}

}
