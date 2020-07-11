package com.employeecrud.springemployeecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeecrud.springemployeecrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
