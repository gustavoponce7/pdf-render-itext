package com.gpch.pdfrender.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

@Service("pdfTableService")
public class PdfTableServiceImpl implements PdfTableService {

	@Override
	public PdfPTable createTable(int numColumns) {
		return new PdfPTable(numColumns);
	}

	@Override
	public PdfPTable addTableHeader(PdfPTable pdfPTable, Collection<String> headers, BaseColor backgroundColor) {
		headers.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(backgroundColor);
			header.setPhrase(new Phrase(columnTitle));
			pdfPTable.addCell(header);
		});
		return pdfPTable;
	}

	@Override
	public PdfPTable addRow(PdfPTable pdfPTable, Collection<String> values) {
		values.stream().map(value -> value).forEach(pdfPTable::addCell);
		return pdfPTable;
	}
}
