package com.gpch.pdfrender.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class PdfTableServiceTest {

	@Autowired
	private PdfTableService pdfTableService;

	PdfPTable table;

	@Before
	public void init() {
		table = pdfTableService.createTable(3);
	}

	@Test
	public void testCreateTable() {
		Assertions.assertThat(table).isNotNull();
		Assertions.assertThat(table.getNumberOfColumns()).isEqualTo(3);
	}

	@Test
	public void testAddTableHeader() {
		Collection<String> headers = Arrays.asList("Name", "Last Name", "Phone");
		table.setHeaderRows(3);
		PdfPTable result = pdfTableService.addTableHeader(table, headers, BaseColor.LIGHT_GRAY);
		ArrayList<PdfPRow> rows = table.getRows();
		Assertions.assertThat(result.getHeaderRows()).isEqualTo(3);
		Assertions.assertThat(rows.get(0).getCells()[0].getPhrase().getContent()).isEqualTo("Name");
		Assertions.assertThat(rows.get(0).getCells()[1].getPhrase().getContent()).isEqualTo("Last Name");
		Assertions.assertThat(rows.get(0).getCells()[2].getPhrase().getContent()).isEqualTo("Phone");
		
	}

/*	@Test
	public void testAddRow() {

	}

	@Test
	public void testAddRows() {

	}

	@Test
	public void testAddCustomRows() {
		
	}*/

	@TestConfiguration
	@Profile("test")
	static class PdfTableServiceTestContextConfiguration {

		@Bean
		public PdfTableService pdfTableService() {
			return new PdfTableServiceImpl();
		}
	}

}
