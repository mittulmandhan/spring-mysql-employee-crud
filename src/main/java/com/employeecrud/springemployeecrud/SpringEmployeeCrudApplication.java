package com.employeecrud.springemployeecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.employeecrud.springemployeecrud.repository")
@SpringBootApplication
public class SpringEmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeCrudApplication.class, args);
	}

}
