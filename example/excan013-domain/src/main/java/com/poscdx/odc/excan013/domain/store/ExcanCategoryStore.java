package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCategory;

import java.util.List;

public interface ExcanCategoryStore {

    public ExcanCategory retrieve(int id);

    public List<ExcanCategory> retrieveAll();

    public ExcanCategory update(ExcanCategory entity);

    public ExcanCategory create(ExcanCategory entity);

    public void delete(int id);
}
