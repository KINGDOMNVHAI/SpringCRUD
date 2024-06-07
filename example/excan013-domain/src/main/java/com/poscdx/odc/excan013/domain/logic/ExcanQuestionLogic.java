package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.spec.ExcanQuestionService;
import com.poscdx.odc.excan013.domain.store.ExcanQuestionStore;

import java.util.List;

public class ExcanQuestionLogic implements ExcanQuestionService
{
    private final ExcanQuestionStore store;

    public ExcanQuestionLogic(ExcanQuestionStore store) {
        this.store = store;
    }

    @Override
    public ExcanQuestion find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanQuestion> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanQuestion register(ExcanQuestion entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(List<ExcanQuestion> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }


}
