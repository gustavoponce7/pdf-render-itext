package com.gpch.pdfrender.report;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.gpch.pdfrender.model.Employee;
import com.gpch.pdfrender.service.FileService;
import com.gpch.pdfrender.service.FileServiceImpl;
import com.gpch.pdfrender.service.PdfDocumentService;
import com.gpch.pdfrender.service.PdfDocumentServiceImpl;
import com.gpch.pdfrender.service.PdfTableService;
import com.gpch.pdfrender.service.PdfTableServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

@RunWith(SpringRunner.class)
@ActiveProfiles({ "test" })
public class EmployeePdfTableReportTest {

	@Autowired
	private EmployeePdfTableReport employeePdfTableReport;

	@Test
	public void test_buildReport() throws FileNotFoundException, DocumentException {
		final Collection<String> HEADERS = Arrays.asList("NAME", "LAST NAME", "PHONE");
		final Collection<Employee> content = Arrays.asList(new Employee("Gustavo", "Ponce", "12334"), new Employee("John", "Smith", "66789"));
		Document document = employeePdfTableReport.buildReport("C:\\dummy-files\\unit_test.pdf", HEADERS, content);
		Assertions.assertThat(document).isNotNull();
	}

	@TestConfiguration
	@Profile("test")
	static class BasePdfTableReportContextConfiguration {

		@Bean
		public EmployeePdfTableReport employeePdfTableRepor() {
			return new EmployeePdfTableReport(ddfDocumentService(), pdfTableService(), fileService());
		}

		@Bean
		public PdfDocumentService ddfDocumentService() {
			return new PdfDocumentServiceImpl();
		}

		@Bean
		public PdfTableService pdfTableService() {
			return new PdfTableServiceImpl();
		}

		@Bean
		public FileService fileService() {
			return new FileServiceImpl();
		}

	}
}
