package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;

import java.util.List;

public interface ExcanMenuStore {

    public ExcanMenu retrieve(int id);

    public List<ExcanMenu> retrieveAll();

    public ExcanMenu update(ExcanMenu entity);

    public ExcanMenu create(ExcanMenu entity);

    public void delete(int id);

    List<ExcanMenu> getLeftMenuByPermission(List<Integer> permissionList);
}
