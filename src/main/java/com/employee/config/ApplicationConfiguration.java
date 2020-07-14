package com.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
	@Autowired
	private Environment env;
	
	public String pawanMittulProperty() {
		return env.getProperty("pawan.mittul");
	}
}
