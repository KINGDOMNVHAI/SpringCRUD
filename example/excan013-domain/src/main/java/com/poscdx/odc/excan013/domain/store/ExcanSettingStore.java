package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;

import java.util.List;

public interface ExcanSettingStore {

    public ExcanSetting retrieve(int id);

    public List<ExcanSetting> retrieveAll();

    List<ExcanSetting> search(SettingSearchDTO dto);

    public ExcanSetting update(ExcanSetting entity);

    public ExcanSetting create(ExcanSetting entity);

    public void delete(int id);
}
