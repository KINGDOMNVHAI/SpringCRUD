package com.codewithproject.springsecurity.dto;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommunityDto {

    private Long idCom;

    private String titleCom;

    private String descriptionCom;

    private String createdDateCom;

    private String idChannel;

    private String nameChannel;

    private String urlChannel;

    private Integer subscribe;

    private String thumbnailChannel;

    public CommunityDto convertObjectToDto(Object[] object) {
        CommunityDto dto = new CommunityDto();
        dto.setIdCom((Long) object[0]);
        dto.setTitleCom((String) object[1]);
        dto.setDescriptionCom((String) object[2]);
        dto.setCreatedDateCom(DateUtil.toDateString((Date) object[3], Constants.FORMAT_YYYY_MM_DD_HH_MM_SS));
        dto.setIdChannel((String) object[4]);
        dto.setNameChannel((String) object[5]);
        dto.setUrlChannel((String) object[6]);
        dto.setSubscribe((Integer) object[7]);
        dto.setThumbnailChannel((String) object[8]);
        return dto;
    }
}
