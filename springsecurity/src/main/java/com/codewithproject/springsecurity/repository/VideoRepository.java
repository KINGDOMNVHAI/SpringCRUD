package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE videos", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT v.* "
            + " FROM videos v "
            + " WHERE v.id_video = :idVideo", nativeQuery = true)
    Video getVideoById(String idVideo);

    @Query(value = "SELECT v.* "
            + " FROM videos v "
            + " WHERE v.id_channel = :idChannel", nativeQuery = true)
    List<Video> getListVideoByIdChannel(String idChannel);
}
