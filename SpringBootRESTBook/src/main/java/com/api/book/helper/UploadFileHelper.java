package com.api.book.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFileHelper {

//	public final String UPLOAD_DIR = "C:\\Users\\Hi\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\SpringBootRESTBook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getCanonicalPath();

	public UploadFileHelper() throws IOException {

	}

	public Boolean uploadFile(MultipartFile multipartFile) {
		boolean file = false;

		try {
//			InputStream inputStream = multipartFile.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read(data);
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());
//			fos.write(data);
//			fos.close();

			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			file = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return file;
	}
}
