package com.codewithproject.springsecurity.dto.logic;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
* Only use for logic and store
* */
@Getter
@Setter
public class ChannelVideoLogicStore {
    // Channel
    private String idChannel;
    private String nameChannel;
    private String createdDateChannel;
    private Integer fromSub;
    private Integer toSub;
    // Video
    private String idVideo;
    private String nameVideo;
    private Date createdDateVideo;
    // Community
}
