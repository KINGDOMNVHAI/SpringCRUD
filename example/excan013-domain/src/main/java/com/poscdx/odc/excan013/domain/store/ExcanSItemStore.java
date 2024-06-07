package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanSItem;

import java.util.List;

public interface ExcanSItemStore {

    public ExcanSItem retrieve(int id);

    public List<ExcanSItem> retrieveAll();

    List<ExcanSItem> search(String settingId);

    public ExcanSItem update(ExcanSItem entity);

    public ExcanSItem create(ExcanSItem entity);

    public void delete(int id);

    void deleteAllBySettingId(int settingId);
}
