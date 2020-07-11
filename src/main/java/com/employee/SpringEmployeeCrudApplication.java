package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.employee.repository")
@SpringBootApplication
public class SpringEmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeCrudApplication.class, args);
	}

}
