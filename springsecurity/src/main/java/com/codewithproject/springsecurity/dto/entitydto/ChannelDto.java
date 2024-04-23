package com.codewithproject.springsecurity.dto.entitydto;

import lombok.Getter;
import lombok.Setter;

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

}
