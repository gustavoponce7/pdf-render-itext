package com.gpch.pdfrender.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService{

	@Override
	public File createFile(String name) {
		return new File(name);
	}

	@Override
	public FileOutputStream getFileOutputStream(File file) throws FileNotFoundException {
		return new FileOutputStream(file);
	}

}
