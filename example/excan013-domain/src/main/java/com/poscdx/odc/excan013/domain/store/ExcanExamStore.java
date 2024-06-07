package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;

import java.util.List;

public interface ExcanExamStore {

    public ExcanExam retrieve(int id);

    List<ExcanAnswer>  findAnswersInExam(int id);

    public ExcanExam retrieveByCandidateId(int id);

    public List<ExcanExam> retrieveAll();

    public ExcanExam update(ExcanExam entity);

    public ExcanExam create(ExcanExam entity);

    int generateExam(int examId, int profileId, String creator);

    public void delete(int id);
    public ExcanExam findByCandidateId(int candidateId);
}
