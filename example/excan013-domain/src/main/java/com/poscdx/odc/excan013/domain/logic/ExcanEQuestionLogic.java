package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.store.ExcanEQuestionStore;
import com.poscdx.odc.excan013.domain.spec.ExcanEQuestionService;

import java.util.List;

public class ExcanEQuestionLogic implements ExcanEQuestionService
{
    private final ExcanEQuestionStore store;

    public ExcanEQuestionLogic(ExcanEQuestionStore store) {
        this.store = store;
    }

    @Override
    public ExcanEQuestion find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanEQuestion> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanEQuestion register(ExcanEQuestion entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(List<ExcanEQuestion> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }

    @Override
    public List<ExcanQuestion> findQuestionsByExamId(int examId){
        return this.store.findQuestionsByExamId(examId);
    }

    @Override
    public List<ExcanAnswer> findAnswersByExamId(int examId) {
        return this.store.findAnswersByExamId(examId);
    }

    @Override
    public List<ExcanEQuestion> findByExamId(int examId) {
        return this.store.findByExamId(examId);
    }

    @Override
    public ExcanEQuestion findByExamIdAndQuestionId(int examId, int questionId) {
        return this.store.findByExamIdAndQuestionId(examId,questionId);
    }
}
