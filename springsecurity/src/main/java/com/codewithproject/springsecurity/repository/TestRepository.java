package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE tests", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT t.* "
            + " FROM tests t "
            + " WHERE t.id_test = :idTest", nativeQuery = true)
    Optional<Test> getTestById(Integer idTest);

    @Query(value = "SELECT t.* "
            + " FROM tests t "
            + " WHERE t.url_test = :urlTest", nativeQuery = true)
    Optional<Test> getTestByURL(String urlTest);
}
