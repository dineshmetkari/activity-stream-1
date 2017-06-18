package com.stackroute.activity.rest.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.activity.model.FileInfo;

@RestController
public class FileUploadRestController {
	
 @Autowired
 ServletContext context;

	@RequestMapping(value = "/fileupload_image", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FileInfo> uploadImage(@RequestParam("file") MultipartFile inputFile) {
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File(
						context.getRealPath("/WEB-INF/uploaded") + File.separator + originalFilename);
				inputFile.transferTo(destinationFile);
				fileInfo.setFileName(destinationFile.getPath());
				fileInfo.setFileSize(inputFile.getSize());
				fileInfo.setFileType("image");
				fileInfo.setStatusMessage("File Uploaded successfully");
				headers.add("File Uploaded Successfully - ", originalFilename);
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			} catch (Exception e) {
				
				fileInfo.setStatusMessage("File was not uploaded");
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			}
		} else {
			
			fileInfo.setStatusMessage("File was not uploaded");
			return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);

		}
	}
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
		FileInfo fileInfo = new FileInfo();
		HttpHeaders headers = new HttpHeaders();
		if (!inputFile.isEmpty()) {
			try {
				String originalFilename = inputFile.getOriginalFilename();
				File destinationFile = new File(
						context.getRealPath("/WEB-INF/uploaded") + File.separator + originalFilename);
				inputFile.transferTo(destinationFile);
				fileInfo.setFileName(destinationFile.getPath());
				fileInfo.setFileSize(inputFile.getSize());
				fileInfo.setFileType("attachment");
				fileInfo.setStatusMessage("File Uploaded successfully");
				headers.add("File Uploaded Successfully - ", originalFilename);
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			} catch (Exception e) {
				
				fileInfo.setStatusMessage("File was not uploaded");
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			}
		} else {
			
			fileInfo.setStatusMessage("File was not uploaded");
			return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);

		}
	}
}
