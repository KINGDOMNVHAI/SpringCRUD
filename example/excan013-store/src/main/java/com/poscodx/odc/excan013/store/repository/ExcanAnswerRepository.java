package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanAnswerJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcanAnswerRepository
    extends JpaRepository<ExcanAnswerJpo, Integer>
{
    List<ExcanAnswerJpo> findByQuestionId(int questionId);
}
