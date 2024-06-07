package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;

import java.util.List;

public interface ExcanEQuestionService {

    public ExcanEQuestion find(int id);

    public List<ExcanEQuestion> findAll();

    public void modify(List<ExcanEQuestion> entityList);

    public ExcanEQuestion register(ExcanEQuestion entity);

    public void remove(int id);

    List<ExcanQuestion> findQuestionsByExamId(int examId);
    List<ExcanAnswer> findAnswersByExamId(int examId);

    public List<ExcanEQuestion> findByExamId(int examId);

    public ExcanEQuestion findByExamIdAndQuestionId(int examId, int questionId);
}
