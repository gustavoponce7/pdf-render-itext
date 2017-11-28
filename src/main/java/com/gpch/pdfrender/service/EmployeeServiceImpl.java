package com.gpch.pdfrender.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Collection<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
