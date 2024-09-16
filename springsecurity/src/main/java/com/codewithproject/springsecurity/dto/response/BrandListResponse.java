package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandListResponse {

    // tb_bb_brand
    private Integer seq;
    private String brandCD;
    private String brandName;
    private String parentBrandCD;
    private String parentBrandName;
    private String thumbnail;

    public BrandListResponse convertObjectToDto(Object[] object) {
        BrandListResponse dto = new BrandListResponse();
        dto.setSeq((Integer) object[0]);
        dto.setBrandCD((String) object[1]);
        dto.setBrandName((String) object[2]);
        dto.setParentBrandCD((String) object[3]);
        dto.setThumbnail((String) object[4]);
        return dto;
    }
}
