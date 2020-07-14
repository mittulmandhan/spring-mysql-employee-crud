package com.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.Charset;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.controller.EmployeeController;
import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.service.EmployeeService;

@WebMvcTest(value = EmployeeController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class SpringEmployeeCrudApplicationTests {
	
	@MockBean
	private EmployeeController employeeController;
	
	@MockBean
	private EmployeeService employeeService;
	
	@MockBean
	private EntityManagerFactory entityManagerFactory;
		
	@Autowired
	private MockMvc mockMvc;

	public SpringEmployeeCrudApplicationTests() {
	}
	
	@Test
	public void addTest1() throws Exception {
		MediaType textplainutf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
		String requestBody = "{\"name\": \"Bob\", \"teamName\" : \"developer\", \"salary\": \"10000\"}";
		EmployeeResponseDTO employeeResponse = new EmployeeResponseDTO();
		employeeResponse.setName("Bob");
		employeeResponse.setTeamName("developer");
		employeeResponse.setSalary(10000);
		Mockito.when(employeeService.add(Mockito.any(EmployeeRequestDTO.class))).thenReturn(employeeResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employee/add")
			.accept(textplainutf8)
			.content(requestBody)
			.contentType(textplainutf8);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String output = response.getContentAsString();
		
		assertEquals(requestBody, output);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
//	@Test
//	public void addTest2() throws Exception {
//		MediaType textplainutf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//		String requestBody = "{\"name\": \"\", \"teamName\" : \"\", \"salary\": 0}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/employee/add")
//			.content(requestBody)
//			.contentType(MediaType.APPLICATION_JSON_UTF8))
//			.andExpect(MockMvcResultMatchers.status().isBadRequest())
//			.andExpect(MockMvcResultMatchers.content()
//				.contentType(textplainutf8));
//	}

}
