package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanQuestionJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcanQuestionRepository
    extends JpaRepository<ExcanQuestionJpo, Integer>
{

}
