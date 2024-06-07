package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import com.poscdx.odc.excan013.domain.spec.ExcanSettingService;
import com.poscdx.odc.excan013.domain.store.ExcanSettingStore;

import java.util.List;

public class ExcanSettingLogic implements ExcanSettingService
{
    private final ExcanSettingStore store;

    public ExcanSettingLogic(ExcanSettingStore store) {
        this.store = store;
    }

    @Override
    public ExcanSetting find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanSetting> findAll() { return this.store.retrieveAll(); }

    @Override
    public List<ExcanSetting> search(SettingSearchDTO dto) {
        return this.store.search(dto);
    }

    @Override
    public ExcanSetting register(ExcanSetting entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(ExcanSetting entity) {
        this.store.update(entity);
    }

    @Override
    public void modify(List<ExcanSetting> entityList) {
        entityList.forEach( this.store::update);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }
}
