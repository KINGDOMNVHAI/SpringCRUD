package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.store.ExcanSItemStore;
import com.poscdx.odc.excan013.domain.entity.ExcanSItem;
import com.poscdx.odc.excan013.domain.spec.ExcanSItemService;

import java.util.List;

public class ExcanSItemLogic implements ExcanSItemService
{
    private final ExcanSItemStore store;

    public ExcanSItemLogic(ExcanSItemStore store) {
        this.store = store;
    }

    @Override
    public ExcanSItem find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanSItem> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public List<ExcanSItem> search(String settingId) {
        return this.store.search(settingId);
    }

    @Override
    public ExcanSItem register(ExcanSItem entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(ExcanSItem entity) {
        this.store.update(entity);
    }
    @Override
    public void modify(List<ExcanSItem> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }

    @Override
    public void removeAllBySettingId(int settingId) { this.store.deleteAllBySettingId(settingId); }
}
