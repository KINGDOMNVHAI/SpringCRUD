package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.TestQuestionSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TestQuestionSectionRepository extends JpaRepository<TestQuestionSection, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE test_question_section", nativeQuery = true)
    void truncateTable();
}
