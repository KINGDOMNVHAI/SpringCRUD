package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.FileConstants;
import com.codewithproject.springsecurity.config.MessageConstants;
import com.codewithproject.springsecurity.repository.BladeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private BladeRepository bladeRepo;

    public String storeFile(String uploadType, MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            System.out.println(file);

            if (file.getOriginalFilename() != null) {
                // Get the file name
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());

                // Create the target file path
                Path targetFilePath = Paths.get(uploadPath + File.separator + fileName);

                // Copy the uploaded file to the target location
                Files.copy(file.getInputStream(), targetFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        if (uploadType.equals(FileConstants.FILE_TYPE_PDF)) {
            System.out.println(uploadType);
        }

        return MessageConstants.MESS_FILE_UPLOAD_SUCCESS;
    }
}
