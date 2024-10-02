package com.codewithproject.springsecurity.feature.service.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
import com.codewithproject.springsecurity.dto.logic.ChannelVideoLogicStore;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.logic.VideoLogic;
import com.codewithproject.springsecurity.repository.VideoRepository;
import com.codewithproject.springsecurity.seeder.VideoSeeder;
import com.codewithproject.springsecurity.feature.service.VideoService;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    @Autowired
    public VideoLogic videoLogic;

    @Autowired
    public VideoRepository videoRepo;

    @Autowired
    public VideoSeeder videoSeeder;

    public List<Video> seederVideos() {
        return videoSeeder.seederVideos();
    }

    public VideoDto getVideo(String idVideo) {
        Video video = new Video();
        video = videoRepo.getVideoById(idVideo);

        ChannelVideoLogicStore req = new ChannelVideoLogicStore();
        req.setIdVideo(idVideo);
        TypedQuery<VideoDto> tqVideo = videoLogic.retrieveLineFindVideo(req);

        VideoDto result = new VideoDto();
        video.convertToDto(result, Constants.LANG_VI);
        return result;
    }

    public List<Video> getListVideoByIdChannel(String idChannel) {
        List<Video> listVideo = new ArrayList<>();
        listVideo = videoRepo.getListVideoByIdChannel(idChannel);

        ChannelVideoLogicStore req = new ChannelVideoLogicStore();
        req.setIdChannel(idChannel);
        TypedQuery<VideoDto> tqVideo = videoLogic.retrieveLineFindVideo(req);

        return listVideo;
    }

    public VideoDto insertVideo(VideoDto req) {
        return videoLogic.save(req);
    }
}
