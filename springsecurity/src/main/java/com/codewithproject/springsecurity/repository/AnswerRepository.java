package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT a.* "
            + " FROM answers a "
            + " WHERE a.id_answer IN :listIntAnswer ORDER BY RAND() ", nativeQuery = true)
    List<Answer> getListAnswerByListId(List<Integer> listIntAnswer);
}
