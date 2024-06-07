package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;

import java.util.List;
import java.util.Map;

public interface ExcanSettingService {

    public ExcanSetting find(int id);

    public List<ExcanSetting> findAll();

    public List<ExcanSetting> search(SettingSearchDTO dto);

    public void modify(List<ExcanSetting> entityList);

    public void modify(ExcanSetting entity);

    public ExcanSetting register(ExcanSetting entity);

    public void remove(int id);
}
