package com.gpch.pdfrender.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Collection<Employee> employees() {
		return employeeService.findAll();
	}

}
