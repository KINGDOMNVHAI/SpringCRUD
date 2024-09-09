package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.services.FTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/v1/public/file")
@RequiredArgsConstructor
public class FileController {

    @Autowired
    private FTPService ftpService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String s = ftpService.uploadFile(file);
        if (s == null) {
            return ResponseEntity.badRequest().body("Fail");
        }
        return ResponseEntity.ok("File uploaded successfully: " + s);

    }

    @PostMapping("/uploads")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files) {

        List<String> paths = ftpService.uploadFiles(files);
        if (paths == null) {
            return ResponseEntity.badRequest().body(Collections.singletonList("Fail"));
        }
        return ResponseEntity.ok(paths);

    }


//    @PostMapping("/public/line/queue-register")
//    public Map<String,Object> registerToQueueLine(@RequestBody InsertLineRequest req) {
//        Map<String,Object> result = new HashMap<>();
//        result = lineServiceImpl.registerToLine(req);
//
//        return result;
//    }
}
