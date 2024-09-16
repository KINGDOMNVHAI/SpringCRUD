package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.FileConstants;
import com.codewithproject.springsecurity.config.MessageConstants;
import com.codewithproject.springsecurity.dto.entitydto.ImageDto;
import com.codewithproject.springsecurity.entities.Image;
import com.codewithproject.springsecurity.repository.ImageRepository;
import com.codewithproject.springsecurity.services.FileService;
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
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ImageRepository imageRepo;

    @Override
    public List<ImageDto> getImageByObjId(String objId) {
        return imageRepo.findImagesByObjId(objId).stream().map(Image::toDto).toList();
    }

//    @Override
//    public List<ImageDto> replaceImages(String objId, List<ImageDto> newImages) {
//        List<Image> olds = imageRepo.findImagesByObjId(objId);
//        imageRepo.deleteAllInBatch(olds);
//        newImages = newImages.stream().map(img->{
//            img.setTableName(LineProgress.class.getSimpleName());
//            return img;
//        }).toList();
//        List<Image> res = imageRepo.saveAll(newImages.stream().map(ImageDto::toEntity).toList());
//        return res.stream().map(Image::toDto).toList();
//    }

    @Override
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

//    public LineProgressDto updateLineProgressImage(Long lpId, List<ImageDto> newImages) throws Exception {
//        Optional<LineProgress> lineProgressOptional = lineProgressRepo.findById(lpId);
//        if(lineProgressOptional.isEmpty()){
//            throw new Exception("Not Found lpId");
//        }
//
//        LineProgress lineProgress = lineProgressOptional.get();
//        LineProgressDto dto = lineProgress.toDto();
//        dto.setImages(imageService.replaceImages(lpId.toString(), newImages));
//        return dto;
//    }
}
