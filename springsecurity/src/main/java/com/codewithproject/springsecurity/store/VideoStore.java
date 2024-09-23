package com.codewithproject.springsecurity.store;

import com.codewithproject.springsecurity.dto.logic.ChannelVideoLogicStore;
import com.codewithproject.springsecurity.entities.Video;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Store package: create Predicate
 * */
@Service
public class VideoStore {

    public List<Predicate> buildPredicateFindVideo(CriteriaBuilder criteriaBuilder, Root<Video> videoRoot, ChannelVideoLogicStore req) {
        List<Predicate> rootPredicates = new ArrayList<>();
        String idVideo = req.getIdVideo();
        String idChannel = req.getIdChannel();

        if (idVideo != null && !idVideo.isEmpty() && !idVideo.trim().isEmpty()) {
            Predicate preID = criteriaBuilder.like(videoRoot.get("idVideo"), idVideo);
            rootPredicates.add(preID);
        }
        if (idChannel != null && !idChannel.isEmpty() && !idChannel.trim().isEmpty()) {
            Predicate preIDChannel = criteriaBuilder.like(videoRoot.get("idChannel"), idChannel);
            rootPredicates.add(preIDChannel);
        }
        return rootPredicates;
    }
}
