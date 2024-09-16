package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
    List<Image> findImagesByObjId(String objId);
}
