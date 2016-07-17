package com.nlan.appSpring.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public static final String ROOT_IMAGES = "../../resources/core/images";

	public static boolean proccesFile(MultipartFile file) throws IOException {
		boolean toReturn = false;
		if (!file.isEmpty()) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			String filePath = classLoader.getResource(".").getPath() + ROOT_IMAGES;
			File uploadedFile = new File(filePath, file.getOriginalFilename());
			file.transferTo(uploadedFile);
			toReturn = true;
		}
		return toReturn;
	}
}
