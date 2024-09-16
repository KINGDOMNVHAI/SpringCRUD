package com.codewithproject.springsecurity.store;

import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.repository.TestRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Logic package: call repository or create CriteriaBuilder
 * */
@Service
public class TestStore {

    @Autowired
    private TestRepository brandRepo;

//    public BrandDto create(BrandDto entity) {
//        Brand jpoToSave = new Brand(entity);
//        Brand savedJpo = this.brandRepo.save(jpoToSave);
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
