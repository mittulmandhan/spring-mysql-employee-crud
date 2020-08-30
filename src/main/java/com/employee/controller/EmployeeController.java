package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRegistrationRequestDTO;
import com.employee.dto.EmployeeRegistrationResponseDTO;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeResponseDTO> getAll() {
		List<EmployeeResponseDTO> employeeList = employeeService.getAll();
		log.info("All emplyees fetched -> " + employeeList);
		return employeeList;
	}
	
	@GetMapping("/paged")
	public List<EmployeeResponseDTO> getPaged() {
		List<EmployeeResponseDTO> employeeList = employeeService.getPaged();
		log.info("All emplyees fetched -> " + employeeList);
		return employeeList;
	}
	
	@GetMapping("/sorted")
	public List<EmployeeResponseDTO> getSorted() {
		List<EmployeeResponseDTO> employeeList = employeeService.getSorted();
		log.info("All emplyees fetched -> " + employeeList);
		return employeeList;
	}
	
	@GetMapping("/pagedandsorted")
	public List<EmployeeResponseDTO> getPagedAndSorted() {
		List<EmployeeResponseDTO> employeeList = employeeService.getPagedAndSorted();
		log.info("All emplyees fetched -> " + employeeList);
		return employeeList;
	}

	@GetMapping("/{id}")
	public EmployeeResponseDTO get(@PathVariable final Integer id) {
		EmployeeResponseDTO employee = employeeService.get(id);
		log.info("Employee fetched -> " + employee);
		return employee;
	}

	@PostMapping
	public EmployeeResponseDTO add(@Valid @RequestBody final EmployeeRequestDTO employeeDTO) {
		EmployeeResponseDTO employee = employeeService.add(employeeDTO);
		log.info("Employee added -> " + employee);
		return employee;
	}

	@PostMapping("/registeration")
	public EmployeeRegistrationResponseDTO employeeRegisteration(
			@Valid @RequestBody final EmployeeRegistrationRequestDTO employeeRegisterDTO) {
		EmployeeRegistrationResponseDTO employee = employeeService.employeeRegisteration(employeeRegisterDTO);
		log.info("Employee registered -> " + employee);
		return employee;
	}

	@PutMapping
	public EmployeeResponseDTO update(@Valid @RequestBody final EmployeeRequestDTO employeeDTO) {
		EmployeeResponseDTO employee = employeeService.update(employeeDTO);
		log.info("Employee updated -> " + employee);
		return employee;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		log.info("Employee deleted -> " + id);
		employeeService.delete(id);
	}

}
