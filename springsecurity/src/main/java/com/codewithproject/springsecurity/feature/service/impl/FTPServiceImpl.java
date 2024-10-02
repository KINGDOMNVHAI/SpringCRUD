package com.codewithproject.springsecurity.feature.service.impl;

import com.codewithproject.springsecurity.feature.service.FTPService;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FTPServiceImpl implements FTPService {
    @Value("${ftp.host}")
    private String server;
    @Value("${ftp.port}")
    private int port; // Cập nhật nếu có port khác
    @Value("${ftp.user}")
    private String user;
    @Value("${ftp.pass}")
    private String pass; // Thay bằng mật khẩu FTP thực tế
    @Value("${ftp.publicUrl}")
    private String baseUrl;

    final private String REMOTE_DIR = "/images";
    public  String generateFileName(String originalFileName) {
        // Lấy phần mở rộng của file
        String extension = "";
        int i = originalFileName.lastIndexOf('.');
        if (i > 0) {
            extension = originalFileName.substring(i);
        }

        // Tạo UUID và gắn phần mở rộng
        String uniqueFileName = UUID.randomUUID().toString() + extension;

        return uniqueFileName;
    }
    @Override
    public String uploadFile(MultipartFile file) {
        FTPClient ftpClient = new FTPClient();
        try {
//            int portInt = Integer.parseInt(port);
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            String remoteDir = REMOTE_DIR;

            if (!ftpClient.changeWorkingDirectory(remoteDir)) {
                if (ftpClient.makeDirectory(remoteDir)) {
                    System.out.println("Created directory: " + remoteDir);
                } else {
                    throw new IOException("Failed to create directory: " + remoteDir);
                }
            }
            ftpClient.changeWorkingDirectory(remoteDir);

            String newName = generateFileName(Objects.requireNonNull(file.getOriginalFilename()));

            String remoteFilePath = remoteDir + newName;
            InputStream inputStream = file.getInputStream();

            boolean done = ftpClient.storeFile(remoteFilePath, inputStream);
            inputStream.close();
            if (done) {
                return baseUrl + newName;
            } else {
                throw new IOException("Failed to upload file to FTP");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<String> uploadFiles(MultipartFile[] files) {
        FTPClient ftpClient = new FTPClient();
        ArrayList<String> results = new ArrayList<>(){};
        try {
//            int portInt = Integer.parseInt(port);
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            String remoteDir = REMOTE_DIR;

            if (!ftpClient.changeWorkingDirectory(remoteDir)) {
                if (ftpClient.makeDirectory(remoteDir)) {
                    System.out.println("Created directory: " + remoteDir);
                } else {
                    throw new IOException("Failed to create directory: " + remoteDir);
                }
            }
            ftpClient.changeWorkingDirectory(remoteDir);
            for (MultipartFile file : files) {
                String newName = generateFileName(Objects.requireNonNull(file.getOriginalFilename()));

                String remoteFilePath = remoteDir +"/" + newName;
                InputStream inputStream = file.getInputStream();

                boolean done = ftpClient.storeFile(remoteFilePath, inputStream);
                inputStream.close();
                if (done) {
                    results.add(baseUrl + newName);
                } else {
                    throw new IOException("Failed to upload file to FTP");
                }
            }
            return  results;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
