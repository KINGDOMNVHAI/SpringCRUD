package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.spec.ExcanAnswerService;
import com.poscdx.odc.excan013.domain.store.ExcanAnswerStore;

import java.util.List;

public class ExcanAnswerLogic implements ExcanAnswerService
{
    private final ExcanAnswerStore store;

    public ExcanAnswerLogic(ExcanAnswerStore store) {
        this.store = store;
    }

    @Override
    public ExcanAnswer find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanAnswer> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanAnswer register(ExcanAnswer entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(List<ExcanAnswer> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }

    /**
     * @param questionId
     * @return
     */
    @Override
    public List<ExcanAnswer> findByQuestionId(int questionId) {
        return this.store.findByQuestionId(questionId);
    }
}
