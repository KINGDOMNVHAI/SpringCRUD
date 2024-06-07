package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;

import java.util.List;

public interface ExcanAnswerService {

    public ExcanAnswer find(int id);

    public List<ExcanAnswer> findAll();

    public void modify(List<ExcanAnswer> entityList);

    public ExcanAnswer register(ExcanAnswer entity);

    public void remove(int id);

    List<ExcanAnswer> findByQuestionId(int questionId);
}
