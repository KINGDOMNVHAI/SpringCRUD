package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanSItem;

import java.util.List;

public interface ExcanSItemService {

    public ExcanSItem find(int id);

    public List<ExcanSItem> findAll();

    void modify(ExcanSItem entity);

    public void modify(List<ExcanSItem> entityList);

    List<ExcanSItem> search(String settingId);

    public ExcanSItem register(ExcanSItem entity);

    public void remove(int id);

    public void removeAllBySettingId(int settingId);
}
