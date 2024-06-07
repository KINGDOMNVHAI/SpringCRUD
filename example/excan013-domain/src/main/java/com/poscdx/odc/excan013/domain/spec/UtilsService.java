package com.poscdx.odc.excan013.domain.spec;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UtilsService {

    String removeFile(String bucketName, String serviceName, List<String> fileName);

    String uploadFile(String bucketName, String serviceName, MultipartFile file);
}
