package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;

import java.util.List;

public interface ExcanExamService {

    public ExcanExam find(int id);
    List<ExcanAnswer> findAnswersInExam(int id);
    public ExcanExam findByCandidateId(int id);
    public List<ExcanExam> findAll();

    int generateExam(int examId, int profileId, String creator);

    public void modify(List<ExcanExam> entityList);

    public ExcanExam modify(ExcanExam entity);

    public ExcanExam register(ExcanExam entity);

    public void remove(int id);
}
