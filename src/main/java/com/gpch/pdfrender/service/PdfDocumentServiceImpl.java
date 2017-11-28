package com.gpch.pdfrender.service;

import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;

@Service("pdfDocumentService")
public class PdfDocumentServiceImpl implements PdfDocumentService {

	@Override
	public Document createPDFDocument(FileOutputStream fos) throws DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, fos);
		return document;
	}

	@Override
	public Document openPDFDocument(Document document) {
		document.open();
		return document;
	}
	
	@Override
	public Document closePDFDocument(Document document) {
		document.close();
		return document;
	}

	@Override
	public Document addElementToPDFDocument(Document document, Element element) throws DocumentException {
		if(document.isOpen()) {
			document.add(element);
		}
		return document;
	}


}
