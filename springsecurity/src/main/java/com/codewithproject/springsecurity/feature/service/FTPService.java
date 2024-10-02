package com.codewithproject.springsecurity.feature.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FTPService {
    String uploadFile(MultipartFile file);

    List<String> uploadFiles(MultipartFile[] files);
}
