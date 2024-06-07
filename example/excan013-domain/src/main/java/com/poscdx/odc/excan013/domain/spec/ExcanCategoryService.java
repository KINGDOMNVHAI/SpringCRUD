package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanCategory;

import java.util.List;

public interface ExcanCategoryService {

    public ExcanCategory find(int id);

    public List<ExcanCategory> findAll();

    public void modify(List<ExcanCategory> entityList);

    public ExcanCategory register(ExcanCategory entity);

    public void remove(int id);
}
