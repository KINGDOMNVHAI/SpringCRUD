package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.store.ExcanExamStore;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.spec.ExcanExamService;

import java.util.List;

public class ExcanExamLogic implements ExcanExamService
{
    private final ExcanExamStore store;

    public ExcanExamLogic(ExcanExamStore store) {
        this.store = store;
    }

    @Override
    public ExcanExam find(int id) {
        return this.store.retrieve(id);
    }
    @Override
    public List<ExcanAnswer> findAnswersInExam(int id){
        return this.store.findAnswersInExam(id);
    }
    @Override
    public ExcanExam findByCandidateId(int id) {
        return this.store.retrieveByCandidateId(id);
    }

    @Override
    public List<ExcanExam> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanExam register(ExcanExam entity) {
        return this.store.create(entity);
    }

    @Override
    public int generateExam(int examId, int profileId, String creator) {
        return this.store.generateExam(examId, profileId, creator);
    }

    @Override
    public void modify(List<ExcanExam> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public ExcanExam modify(ExcanExam entity) {
        return this.store.update(entity);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }
}
