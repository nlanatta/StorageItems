package com.nlan.appSpring.utils;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

public class FileUploadTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private MockMultipartFile image;

	@Before
	public void setUp() throws Exception {
		image = new MockMultipartFile("image", "newImageToTest.jpg", null, "jpg".getBytes());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		FileUpload.ROOT_IMAGES = "../../../tempFileUpload";
		
		assertTrue(FileUpload.proccesFile(image));
		
		image = new MockMultipartFile("image", "newImageToTest.jpg", null, "".getBytes());
		
		assertFalse(FileUpload.proccesFile(image));
	}

}
