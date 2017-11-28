package com.gpch.pdfrender.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.pdfrender.configuration.TestConfiguration;
import com.gpch.pdfrender.model.Employee;

@DataJpaTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void test_FindAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		Assertions.assertThat(employees.size()).isEqualTo(4);
	}

}
