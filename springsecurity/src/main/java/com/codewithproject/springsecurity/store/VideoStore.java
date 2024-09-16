package com.codewithproject.springsecurity.store;

import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.repository.VideoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Store package: create Predicate
 * */
@Service
public class VideoStore {

    @Autowired
    private VideoRepository videoRepo;

//    public VideoDto create(VideoDto entity) {
//        Video jpoToSave = new Video(entity);
//        Video savedJpo = this.videoRepo.save(jpoToSave);
//        return savedJpo.toDomain();
//    }

    public List<Predicate> buildPredicateFindVideo(CriteriaBuilder criteriaBuilder, Root<Video> videoRoot, String idVideo) {
        List<Predicate> rootPredicates = new ArrayList<>();

        if (idVideo != null && !idVideo.isEmpty() && !idVideo.trim().isEmpty()) {
            Predicate preVideo = criteriaBuilder.like(videoRoot.get("idVideo"), idVideo);
            rootPredicates.add(preVideo);
        }
        return rootPredicates;
    }
}
