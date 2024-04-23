package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
import com.codewithproject.springsecurity.entities.Video;

import java.util.List;

public interface VideoService {

    List<Video> seederVideos();

    VideoDto getVideo(String idVideo);

    List<Video> getListVideoByIdChannel(String idChannel);
}
