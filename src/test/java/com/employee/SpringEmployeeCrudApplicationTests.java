package com.employee;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.employee.controller.EmployeeController;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@WebMvcTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class SpringEmployeeCrudApplicationTests {

	@MockBean
	private EmployeeRepository employeeRepository;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private MockMvc mockMvc;
	
	public SpringEmployeeCrudApplicationTests() {
	}
	
	@Test
	public void test1() throws Exception {
		MediaType textplainutf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String requestBody = "{\"name\": \"Bob\", \"teamName\" : \"developer\", \"salary\": \"10000\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/add")
			.content(requestBody)
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
				.contentType(textplainutf8));
	}
	
	@Test
	public void test2() throws Exception {
		MediaType textplainutf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String requestBody = "{\"name\": \"\", \"teamName\" : \"\", \"salary\": 0}";
		mockMvc.perform(MockMvcRequestBuilders.post("/employee/add")
			.content(requestBody)
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content()
				.contentType(textplainutf8));
	}

}
