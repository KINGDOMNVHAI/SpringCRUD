package com.codewithproject.springsecurity.dto.request;

import com.codewithproject.springsecurity.dto.entitydto.ImageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ImageReplaceRequest {
    List<ImageDto> images;
}
