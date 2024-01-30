package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {


}
