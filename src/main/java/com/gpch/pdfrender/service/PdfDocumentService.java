package com.gpch.pdfrender.service;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;

/**
 * @author Gustavo_Ponce
 *
 */
public interface PdfDocumentService {
	
	public Document createPDFDocument(FileOutputStream fos) throws DocumentException;
	public Document openPDFDocument(Document document);
	public Document closePDFDocument(Document document);
	public Document addElementToPDFDocument(Document document, Element element) throws DocumentException;
}
