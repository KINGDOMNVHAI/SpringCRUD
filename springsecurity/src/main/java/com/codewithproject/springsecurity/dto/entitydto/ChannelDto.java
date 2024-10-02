package com.codewithproject.springsecurity.dto.entitydto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class ChannelDto {

    private String idChannel;

    private String nameChannel;

    private String urlChannel;

    private String urlVideoPresent;

    private String descriptionChannel;

    private String createdDateChannel;

    private Integer subscribe;

    private String thumbnailChannel;

    private String bannerChannel;

    private boolean lockUpdate;

    private String websiteChannel;

    private String facebookChannel;

    private String twitterChannel;

    public ChannelDto toDomain() {
        ChannelDto entity = new ChannelDto();
        BeanUtils.copyProperties(this, entity);

//        entity.setBladeFullName(this.getBladeName() != null ? this.bladeName : null);

        return entity;
    }
}
