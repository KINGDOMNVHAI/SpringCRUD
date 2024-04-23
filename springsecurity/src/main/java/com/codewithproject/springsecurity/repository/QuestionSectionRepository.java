package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.QuestionSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface QuestionSectionRepository extends JpaRepository<QuestionSection, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE question_section", nativeQuery = true)
    void truncateTable();
}
