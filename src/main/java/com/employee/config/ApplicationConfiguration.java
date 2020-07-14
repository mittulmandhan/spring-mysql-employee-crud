package com.employee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
	
	// if the given property is not found then
	// the default value 'red' will be printed
	@Value("${pawan.mitt:red}")
	public String pawanMittul;

}
