package com.gpch.pdfrender.controller;


import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gpch.pdfrender.configuration.TestConfiguration;
import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class EmployeeControllerTest {

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;

	private Employee employee;

	@Before
	public void init() {
		employee = new Employee("Gustavo", "Ponce", "123456789");
	}
	
	@Test
	public void test_getAllEmployees() throws Exception {
		Mockito.when(employeeService.findAll()).thenReturn(Collections.singletonList(employee));
		mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Gustavo"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].lastName").value("Ponce"))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].phone").value("123456789"));
	}
	
}
