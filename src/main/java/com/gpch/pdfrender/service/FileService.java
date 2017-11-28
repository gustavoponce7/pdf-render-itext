package com.gpch.pdfrender.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Gustavo_Ponce
 *
 */
public interface FileService {
	
	/**
	 * @param name The path + name where the file will be created
	 * @return The File created
	 */
	public File createFile(String name);
	/**
	 * @param The file who will be used to generate the FileOutputStream
	 * @return The FileOutputStream
	 * @throws FileNotFoundException
	 */
	public FileOutputStream getFileOutputStream(File file) throws FileNotFoundException;

}
