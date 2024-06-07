package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;

import java.util.List;

public interface ExcanQuestionStore {

    public ExcanQuestion retrieve(int id);

    public List<ExcanQuestion> retrieveAll();

    public ExcanQuestion update(ExcanQuestion entity);

    public ExcanQuestion create(ExcanQuestion entity);

    public void delete(int id);

}
