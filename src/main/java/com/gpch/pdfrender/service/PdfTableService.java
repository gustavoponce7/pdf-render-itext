package com.gpch.pdfrender.service;

import java.util.Collection;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPTable;

public interface PdfTableService {
	PdfPTable createTable(int numColumns);
	PdfPTable addTableHeader(PdfPTable pdfPTable, Collection<String> headers, BaseColor backgroundColor);
	PdfPTable addRow(PdfPTable pdfPTable, Collection<String> values);
	
}
