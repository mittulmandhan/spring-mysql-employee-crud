package com.employeecrud.springemployeecrud.controller;

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
import com.employeecrud.springemployeecrud.model.Employee;
import com.employeecrud.springemployeecrud.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/all")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Employee get(@PathVariable final Integer id) {
		return employeeRepository.getOne(id);
	}

	@PostMapping("/add")
	public Employee add(@RequestBody final Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/update")
	public Employee update(@RequestBody final Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		employeeRepository.deleteById(id);
	}

}
