package com.gpch.pdfrender.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class FileServiceTest {
	@Autowired
	private FileService fileService;
	
	@Test
	public void test_createNewFile() {
		File file = fileService.createFile("test.pdf");
		Assertions.assertThat(file).isNotNull();
		Assertions.assertThat(file.getName()).isEqualTo("test.pdf");
	}
	
	@Test
	public void test_GetFileOutputStream() throws FileNotFoundException {
		File file = new File("test.pdf");
		FileOutputStream fos = fileService.getFileOutputStream(file);
		Assertions.assertThat(fos).isNotNull();
	}
	
	@TestConfiguration
	@Profile("test")
	static class FileServiceTestContextConfiguration {

		@Bean
		public FileService fileService() {
			return new FileServiceImpl();
		}
	}
}
