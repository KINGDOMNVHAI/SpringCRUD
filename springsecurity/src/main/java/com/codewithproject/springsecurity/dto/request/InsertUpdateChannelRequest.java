package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InsertUpdateChannelRequest {
    private String idChannel;

    private String nameChannel;

    private String urlChannel;

    private String urlVideoPresent;

    private String descriptionChannel;

    private Date createdDateChannel;

    private Integer subscribe;

    private String thumbnailChannel;

    private String bannerChannel;

    private String facebookChannel;

    private String twitterChannel;

    private boolean enableChannel;
}
