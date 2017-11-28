package com.gpch.pdfrender.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EmployeeTest {
	
	@Test
	public void objectCreation() {
		Employee employee = new Employee();
		Assertions.assertThat(employee).isNotNull();
	}

}
