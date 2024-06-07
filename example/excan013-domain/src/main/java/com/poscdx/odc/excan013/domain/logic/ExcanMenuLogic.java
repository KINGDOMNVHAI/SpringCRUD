package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import com.poscdx.odc.excan013.domain.spec.ExcanMenuService;
import com.poscdx.odc.excan013.domain.store.ExcanMenuStore;

import java.util.List;

public class ExcanMenuLogic implements ExcanMenuService
{
    private final ExcanMenuStore store;

    public ExcanMenuLogic(ExcanMenuStore store) {
        this.store = store;
    }

    @Override
    public ExcanMenu find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanMenu> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public ExcanMenu register(ExcanMenu entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(List<ExcanMenu> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }

    @Override
    public List<ExcanMenu> getLeftMenuByPermission(List<Integer> permissionList) {
        return this.store.getLeftMenuByPermission(permissionList);
    }
}
