package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;

import java.util.List;

public interface ExcanMenuService {

    public ExcanMenu find(int id);

    public List<ExcanMenu> findAll();

    public void modify(List<ExcanMenu> entityList);

    public ExcanMenu register(ExcanMenu entity);

    public void remove(int id);

    List<ExcanMenu> getLeftMenuByPermission(List<Integer> permissionList);
}
