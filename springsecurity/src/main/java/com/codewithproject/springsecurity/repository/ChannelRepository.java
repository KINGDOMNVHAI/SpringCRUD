package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE channels", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT c.id_channel FROM channels c", nativeQuery = true)
    List<String> getAllIdChannels();

    @Query(value = "SELECT c.* FROM channels c ORDER BY c.subscribe DESC", nativeQuery = true)
    List<Channel> getListChannels();
}
