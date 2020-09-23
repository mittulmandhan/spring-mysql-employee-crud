package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.exception.InvalidEmployeeIDException;
import com.employee.mapper.EmployeeMapper;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeResponseDTO> getAll() {
		List<Employee> employeeList = employeeRepository.findAll();

		return EmployeeMapper.MAPPER.prepareEmployeeResponseDTO(employeeList);
	}

	public Page<Employee> getPaged(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	public List<EmployeeResponseDTO> getSorted() {
		List<Employee> sortedEmployeeList = employeeRepository.findAll(Sort.by("name"));

		return EmployeeMapper.MAPPER.prepareEmployeeResponseDTO(sortedEmployeeList);
	}

	public Page<Employee> getPagedAndSorted(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	public EmployeeResponseDTO get(final Integer id) {

		// validations
		validateID(id);

		Optional<Employee> optional = employeeRepository.findById(id);
		Employee emp = optional.get();

		return EmployeeMapper.MAPPER.prepareEmployeeResponseDTO(emp);
	}

	public EmployeeResponseDTO add(final EmployeeRequestDTO employeeRequest) {

		Employee employee = prepareEmployeeForAdd(employeeRequest);
		// employee added and response received in emp
		Employee emp = employeeRepository.save(employee);

		return EmployeeMapper.MAPPER.prepareEmployeeResponseDTO(emp);
	}

	public EmployeeRegistrationResponseDTO employeeRegisteration(
			final EmployeeRegistrationRequestDTO employeeRegisterRequest) {
		Employee employee = EmployeeMapper.MAPPER.requestDTOToEmployee(employeeRegisterRequest);

		// employee saved in db and received response in emp
		Employee emp = employeeRepository.save(employee);

		return EmployeeMapper.MAPPER.employeeToResponseDTO(emp);
	}

	public EmployeeResponseDTO update(final EmployeeRequestDTO employeeRequest) {

		// validations
		validateID(employeeRequest.getId());

		Employee employee = prepareEmployeeForUpdate(employeeRequest);
		// employee updated and response received in emp
		Employee emp = employeeRepository.save(employee);

		return EmployeeMapper.MAPPER.prepareEmployeeResponseDTO(emp);
	}

	public void delete(final Integer id) {

		// validations
		validateID(id);

		employeeRepository.deleteById(id);
	}

	private Employee prepareEmployeeForAdd(final EmployeeRequestDTO employeeRequest) {
		Employee employee = new Employee();

		employee.setEmail(employeeRequest.getEmail());
		employee.setName(employeeRequest.getName());
		employee.setSalary(employeeRequest.getSalary());
		employee.setTeamName(employeeRequest.getTeamName());
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
