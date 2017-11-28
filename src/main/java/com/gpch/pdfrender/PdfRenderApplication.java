package com.gpch.pdfrender;

import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.report.EmployeePdfTableReport;
import com.gpch.pdfrender.service.EmployeeService;
import com.itextpdf.text.Document;

@SpringBootApplication
public class PdfRenderApplication {

	private static final Logger logger = LoggerFactory.getLogger(PdfRenderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PdfRenderApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(EmployeePdfTableReport employeePdfTableReport, EmployeeService employeeService) {
		return args -> {
			employeeService.saveNewEmployee(new Employee("Gustavo", "Ponce", "123456"));
			employeeService.saveNewEmployee(new Employee("John", "Smith", "234567"));
			employeeService.saveNewEmployee(new Employee("Jim ", "Morrison", "345678"));
			employeeService.saveNewEmployee(new Employee("David", "Gilmour", "456789"));
			logger.info("The sample data has been generated...");
			final Collection<String> headers = Arrays.asList("NAME", "LAST NAME", "PHONE");
			final String REPORT_LOCATION = "C:\\dummy-files\\employees.pdf";
			Document report = employeePdfTableReport.buildReport(REPORT_LOCATION, headers, employeeService.findAll());
			logger.info("PDF has been generated %s ", report);

		};
	}
}
