package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanCategory;
import com.poscdx.odc.excan013.domain.store.ExcanCategoryStore;
import com.poscdx.odc.excan013.domain.spec.ExcanCategoryService;

import java.util.List;

public class ExcanCategoryLogic implements ExcanCategoryService
{
    private final ExcanCategoryStore store;

    public ExcanCategoryLogic(ExcanCategoryStore store) {
        this.store = store;
    }

    @Override
    public ExcanCategory find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanCategory> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanCategory register(ExcanCategory entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(List<ExcanCategory> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }
}
