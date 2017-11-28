package com.gpch.pdfrender.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gpch.pdfrender.service.FileService;
import com.gpch.pdfrender.service.PdfDocumentService;
import com.gpch.pdfrender.service.PdfTableService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

@Component("basePdfTableReport")
public abstract class BasePdfTableReport<T> {

	PdfDocumentService pdfDocumentService;
	PdfTableService pdfTableService;
	FileService fileService;
	Document report;

	@Autowired
	public BasePdfTableReport(PdfDocumentService pdfDocumentService, PdfTableService pdfTableService,
			FileService fileService) {
		super();
		this.pdfDocumentService = pdfDocumentService;
		this.pdfTableService = pdfTableService;
		this.fileService = fileService;
	}

	public final Document buildReport(String fileName, Collection<String> headers, Collection<T> content) throws FileNotFoundException, DocumentException {
		File file = fileService.createFile(fileName);
		FileOutputStream fos = fileService.getFileOutputStream(file);
		createDocument(fos);
		openDocument();
		writeTableContent(headers, content);
		closeDocument();
		return report;
	}

	private void createDocument(FileOutputStream fos) throws DocumentException {
		this.report = pdfDocumentService.createPDFDocument(fos);
	}

	private void openDocument() {
		if (!this.report.isOpen()) {
			this.report.open();
		}
	}

	public abstract void writeTableContent(Collection<String> headers, Collection<T> content) throws DocumentException;

	private void closeDocument() {
		this.report.close();
	}

}
