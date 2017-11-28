package com.gpch.pdfrender.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.gpch.pdfrender.service.FileService;
import com.gpch.pdfrender.service.PdfDocumentService;
import com.gpch.pdfrender.service.PdfTableService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.gpch.pdfrender.model.Employee;

@Component("employeePdfTableReport")
public class EmployeePdfTableReport extends BasePdfTableReport<Employee>{

	public EmployeePdfTableReport(PdfDocumentService pdfDocumentService, PdfTableService pdfTableService,
			FileService fileService) {
		super(pdfDocumentService, pdfTableService, fileService);
	}

	@Override
	public void writeTableContent(Collection<String> headers, Collection<Employee> content) throws DocumentException {
		PdfPTable pdfPTable = pdfTableService.createTable(headers.size());
		pdfPTable = pdfTableService.addTableHeader(pdfPTable, headers, BaseColor.LIGHT_GRAY);
		for (Employee employee : content) {
			pdfTableService.addRow(pdfPTable, new ArrayList<String>(Arrays.asList(employee.getName(), employee.getLastName(), employee.getPhone())));
		}
		pdfDocumentService.addElementToPDFDocument(report, pdfPTable);
	}

}
