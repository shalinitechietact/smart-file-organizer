package com.smartfileorganizer.smartfileorganizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartfileorganizer.smartfileorganizer.entity.FileInfo;
import com.smartfileorganizer.smartfileorganizer.repository.FileInfoRepository;
import com.smartfileorganizer.smartfileorganizer.service.FileOrganizerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/files")

public class FileController {

	
	 @Autowired
	    private FileOrganizerService fileService;

	 @Autowired
	     private FileInfoRepository fileRepository;
	    // Upload multiple files
	    @PostMapping("/upload")
	    public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
	        for(MultipartFile file : files) {
	            fileService.saveAndOrganize(file);
	        }
	        return files.length + " files uploaded and organized successfully!";
	    }
	    
	    @GetMapping("/all")
	    public List<FileInfo> getAllFiles() {
	    return fileRepository.findAll();
	    }
}
