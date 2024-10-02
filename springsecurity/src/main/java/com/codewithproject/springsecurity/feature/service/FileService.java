package com.codewithproject.springsecurity.feature.service;

import com.codewithproject.springsecurity.dto.entitydto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<ImageDto> getImageByObjId(String objId);

//    List<ImageDto> replaceImages(String objId, List<ImageDto> newImages);

    String storeFile(String uploadType, MultipartFile[] files) throws IOException;
}
