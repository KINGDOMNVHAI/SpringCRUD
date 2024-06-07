package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;

import java.util.List;

public interface ExcanAnswerStore {

    public ExcanAnswer retrieve(int id);

    public List<ExcanAnswer> retrieveAll();

    public ExcanAnswer update(ExcanAnswer entity);

    public ExcanAnswer create(ExcanAnswer entity);

    public void delete(int id);

    List<ExcanAnswer> findByQuestionId(int questionId);

}
