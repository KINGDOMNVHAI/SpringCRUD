package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.repository.VideoRepository;
import com.codewithproject.springsecurity.seeder.VideoSeeder;
import com.codewithproject.springsecurity.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codewithproject.springsecurity.config.ParamConstants.PARAM_KEYWORD;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

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

        VideoDto result = new VideoDto();
        video.convertToDto(result, Constants.LANG_VI);
        return result;
    }

    public List<Video> getListVideoByIdChannel(String idChannel) {
        List<Video> listVideo = new ArrayList<>();
        listVideo = videoRepo.getListVideoByIdChannel(idChannel);
        return listVideo;
    }

    public void insertVideo(VideoDto request) {
        Video video = new Video();
        video = request.convertToEntity(Constants.LANG_VI);
        videoRepo.save(video);
    }
}
