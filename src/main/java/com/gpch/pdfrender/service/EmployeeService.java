package com.gpch.pdfrender.service;

import java.util.Collection;

import com.gpch.pdfrender.model.Employee;

/**
 * @author Gustavo_Ponce
 *
 */
public interface EmployeeService {
	/**
	 * @return All the Employees saved in the database
	 */
	Collection<Employee> findAll();
	
	/**
	 * @param employee The employee who will be save in the DB
	 * @return The employee saved in the database
	 */
	Employee saveNewEmployee(Employee employee);
}
