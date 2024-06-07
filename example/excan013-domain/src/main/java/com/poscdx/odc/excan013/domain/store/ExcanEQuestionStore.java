package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;

import java.util.List;

public interface ExcanEQuestionStore {

    public ExcanEQuestion retrieve(int id);

    public List<ExcanEQuestion> retrieveAll();


    public ExcanEQuestion update(ExcanEQuestion entity);

    public ExcanEQuestion create(ExcanEQuestion entity);

    public void delete(int id);

    public List<ExcanQuestion>  findQuestionsByExamId(int examId);

    public List<ExcanAnswer> findAnswersByExamId(int examId);
    public List<ExcanEQuestion> findByExamId(int examId);

    public ExcanEQuestion findByExamIdAndQuestionId(int examId, int questionId);

    public List<Object[]> getAnswerResult(int examId);

    public List<Object[]> getAnswerResultByQuestionIdAndExamId(int questionId, int examId);

    public ExcanEQuestion checkCorrect(int questionId, int examId);
    public ExcanEQuestion checkIncorrect(int questionId, int examId);

    public ExcanEQuestion remark(int questionId, int examId);
}
