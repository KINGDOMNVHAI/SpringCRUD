package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.services.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FileController {

    @Autowired
    private FileServiceImpl fileServiceImpl;

    @PostMapping("/public/blade/upload-image")
    public Map<String,Object> uploadImageBlade(@RequestParam MultipartFile[] files) throws IOException {
        Map<String,Object> result = new HashMap<>();
        String type = "img";
        if (files == null) {
            result.put("success", false);
            result.put("message", "type or files is empty!!");
            return result;
        }
        String message = fileServiceImpl.storeFile(type, files);

        result.put("message", message);
        return result;
    }
}
