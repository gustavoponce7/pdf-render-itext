package com.gpch.pdfrender.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class PdfDocumentServiceTest {

	@Autowired
	private PdfDocumentService pdfDocumentService;

	Document document;

	@Before
	public void init() throws FileNotFoundException, DocumentException {
		document = pdfDocumentService.createPDFDocument(new FileOutputStream(new File("test.pdf")));
	}

	@Test
	public void test_CreateDocument() throws FileNotFoundException, DocumentException {
		Document newDocument = pdfDocumentService.createPDFDocument(new FileOutputStream(new File("test.pdf")));
		Assertions.assertThat(newDocument).isNotNull();
	}

	@Test
	public void test_OpenDicument() {
		pdfDocumentService.openPDFDocument(document);
		Assertions.assertThat(document.isOpen()).isEqualTo(true);
	}

	@Test
	public void test_CloseDocument() throws DocumentException {
		document.open();
		document.add(new Chunk());
		pdfDocumentService.closePDFDocument(document);
		Assertions.assertThat(document.isOpen()).isEqualTo(false);
	}

	@Test
	public void test_AddElementToDocument() throws DocumentException {
		document.open();
		Paragraph newElement = new Paragraph();
		newElement.add("New Element");
		pdfDocumentService.addElementToPDFDocument(document, newElement);
		//TODO Implement assert
	}

	@TestConfiguration
	@Profile("test")
	static class PdfDocumentServiceTestContextConfiguration {

		@Bean
		public PdfDocumentService pdfDocumentService() {
			return new PdfDocumentServiceImpl();
		}
	}
}
