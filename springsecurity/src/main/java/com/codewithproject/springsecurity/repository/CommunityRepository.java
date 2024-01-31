package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, String> {

    @Query(value = "SELECT com.id_com"
            + ", com.title_com"
            + ", com.description_com"
            + ", com.created_date_com"
            + ", com.id_channel "
            + ", c.name_channel_vi "
            + ", c.url_channel "
            + ", c.subscribe "
            + ", c.thumbnail_channel "
            + "FROM channels c, community com "
            + "WHERE c.id_channel = com.id_channel "
            + "AND com.id_channel LIKE :idChannel ", nativeQuery = true)
    List<Object[]> getListCommunityByIDChannel(@Param("idChannel") String idChannel);

    @Query(value = "SELECT com.id_com"
            + ", com.title_com"
            + ", com.description_com"
            + ", com.created_date_com"
            + ", com.id_channel "
            + ", c.name_channel_vi "
            + ", c.url_channel "
            + ", c.subscribe "
            + ", c.thumbnail_channel "
            + "FROM channels c, community com "
            + "WHERE c.id_channel = com.id_channel "
            + "AND com.id_com = :idCom ", nativeQuery = true)
    List<Object[]> getCommunityByID(@Param("idCom") Integer idCom);
}
