package com.codewithproject.springsecurity.feature.controller;

import com.codewithproject.springsecurity.config.MessageConstants;
import com.codewithproject.springsecurity.feature.service.FTPService;
import com.codewithproject.springsecurity.feature.service.impl.FileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/public/file")
@RequiredArgsConstructor
public class FileController {

    @Autowired
    private FTPService ftpService;

    @Autowired
    private FileServiceImpl fileServiceImpl;


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

    @PostMapping("/public/blade/upload-image")
    public Map<String,Object> uploadImageBlade(@RequestParam MultipartFile[] files) throws IOException {
        Map<String,Object> result = new HashMap<>();
        String type = "img";
        if (files == null) {
            result.put("success", false);
            result.put("message", MessageConstants.MESS_TYPE_OR_FILE_EMPTY);
            return result;
        }
        String message = fileServiceImpl.storeFile(type, files);

        result.put("message", message);
        return result;
    }

//    @PostMapping("/public/line/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        String s = ftpService.uploadFile(file);
//        if (s == null) {
//            return ResponseEntity.badRequest().body("Fail");
//        }
//        return ResponseEntity.ok("File uploaded successfully: " + s);
//    }

//    @PostMapping("/public/line/line-progress/{lpId}/images")
//    public ResponseEntity<?> updateImages(@PathVariable Long lpId, @RequestBody ImageReplaceRequest request) {
//        LineProgressDto res;
//        try {
//
//            res = lineServiceImpl.updateLineProgressImage(lpId,request.getImages());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        return ResponseEntity.ok(res);
//    }
}
