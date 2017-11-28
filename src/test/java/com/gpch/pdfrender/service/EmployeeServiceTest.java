package com.gpch.pdfrender.service;

import java.util.Collection;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class EmployeeServiceTest {
	@MockBean
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	private Employee employee;

	@Before
	public void init() {
		employee = new Employee("Gustavo", "Ponce", "123456789");
	}

	@Test
	public void test_findAllEmployees() {
		Mockito.when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));
		Collection<Employee> employees = employeeService.findAll();
		Assertions.assertThat(employees.size()).isEqualTo(1);
	}
	
	@Test
	public void test_saveNewEmployee() {
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result = employeeService.saveNewEmployee(employee);
		Assertions.assertThat(result.getName()).isEqualTo("Gustavo");
	}

	@TestConfiguration
	@Profile("test")
	static class EmployeeServiceTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl(employeeRepository());
		}

		@Bean
		public EmployeeRepository employeeRepository() {
			return Mockito.mock(EmployeeRepository.class);
		}
	}

}
