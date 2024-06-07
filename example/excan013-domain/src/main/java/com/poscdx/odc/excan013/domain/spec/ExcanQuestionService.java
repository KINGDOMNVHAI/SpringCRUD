package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;

import java.util.List;

public interface ExcanQuestionService {

    public ExcanQuestion find(int id);

    public List<ExcanQuestion> findAll();

    public void modify(List<ExcanQuestion> entityList);

    public ExcanQuestion register(ExcanQuestion entity);

    public void remove(int id);

}
