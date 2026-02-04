package com.smartfileorganizer.smartfileorganizer.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartfileorganizer.smartfileorganizer.entity.FileInfo;
import com.smartfileorganizer.smartfileorganizer.repository.FileInfoRepository;

@Service
public class FileOrganizerService {

	
    @Autowired
    private FileInfoRepository fileRepository;

    private final String BASE_DIR = "C:/SmartFiles/"; // Change path as per your system

    public void saveAndOrganize(MultipartFile file) {
        try {
            // 1️⃣ Determine file type folder
            String typeFolder = getTypeFolder(file.getOriginalFilename());
            File dir = new File(BASE_DIR + typeFolder);
            if (!dir.exists()) dir.mkdirs();

            // 2️⃣ Save file
            File destFile = new File(dir, file.getOriginalFilename());
            file.transferTo(destFile);

            // 3️⃣ Save metadata to DB
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(file.getOriginalFilename());
            fileInfo.setFileType(typeFolder);
            fileInfo.setFilePath(destFile.getAbsolutePath());
            fileInfo.setFileSize(file.getSize());
            fileInfo.setUploadedAt(LocalDateTime.now());

            fileRepository.save(fileInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTypeFolder(String fileName) {
        String lower = fileName.toLowerCase();
        if (lower.endsWith(".jpg") || lower.endsWith(".png") || lower.endsWith(".jpeg"))
            return "Images";
        else if (lower.endsWith(".pdf"))
            return "PDFs";
        else if (lower.endsWith(".doc") || lower.endsWith(".docx"))
            return "Docs";
        else if (lower.endsWith(".mp4") || lower.endsWith(".mkv"))
            return "Videos";
        else
            return "Others";
    }
}
