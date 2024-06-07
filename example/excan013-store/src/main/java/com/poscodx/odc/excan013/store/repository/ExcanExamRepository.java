package com.poscodx.odc.excan013.store.repository;

import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscodx.odc.excan013.store.jpo.ExcanExamJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ExcanExamRepository
    extends JpaRepository<ExcanExamJpo, Integer>
{
    @Procedure("CREATE_EXAM_INSTANCE")
    int generateExam(int examId, int profileId, String creator);

    ExcanExamJpo findByCandidateId(int candidateId);
}
