package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.entitydto.ImageDto;

import java.util.List;

public interface ImageService {
    List<ImageDto> getImageByObjId(String objId);

    List<ImageDto> replaceImages(String objId, List<ImageDto> newImages);
}
