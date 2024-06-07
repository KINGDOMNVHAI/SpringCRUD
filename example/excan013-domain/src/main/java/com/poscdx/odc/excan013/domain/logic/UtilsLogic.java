package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.spec.UtilsService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UtilsLogic implements UtilsService {

    private final MinioClient minioClient;

    @Override
    public String removeFile(String bucketName, String serviceName, List<String> filenameList) {
        try {
            List<String> deleteList = new ArrayList<>();
            filenameList.forEach(filename -> deleteList.add("/" + serviceName + "/" + filename));

            for (String deleteString : deleteList) {
                minioClient.removeObject(bucketName, deleteString);
            }
            return "Delete successfully!";
        } catch (Exception e) {
            return "Delete unsuccessfully!";
        }
    }

    @Override
    public String uploadFile(String bucketName, String serviceName, MultipartFile file) {
        try {
            final String fileName = serviceName + "/" + file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(fileName)
                    .stream(inputStream, inputStream.available(), -1)
                    .contentType(file.getContentType())
                    .build());
            return fileName;
        } catch (Exception e) {
            return "Upload unsuccessfully!";
        }
    }
}
