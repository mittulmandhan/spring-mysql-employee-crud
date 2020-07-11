package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public List<EmployeeResponseDTO> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/{id}")
	public EmployeeResponseDTO get(@PathVariable final Integer id) {
		return employeeService.get(id);
	}

	@PostMapping("/add")
	public EmployeeResponseDTO add(@RequestBody final EmployeeRequestDTO employeeDTO) {
		return employeeService.add(employeeDTO);
	}

	@PutMapping("/update")
	public EmployeeResponseDTO update(@RequestBody final EmployeeRequestDTO employeeDTO) {
		return employeeService.update(employeeDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		employeeService.delete(id);
	}

}
