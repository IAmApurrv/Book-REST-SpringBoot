package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.UploadFileHelper;

@RestController
public class UploadFileController {

	@Autowired
	private UploadFileHelper fileHelper;

	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());

		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file.");
			}
			if (!file.getContentType().equals("image/png") || !file.getContentType().equals("image/png")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("only png & jpeg conent types are allowed");
			}

			// file upload code
			Boolean uploadFile = fileHelper.uploadFile(file);

			if (uploadFile) {
				// //return ResponseEntity.ok("File is uploaded successfully.");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
						.path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is not uploaded.");
	}

}
