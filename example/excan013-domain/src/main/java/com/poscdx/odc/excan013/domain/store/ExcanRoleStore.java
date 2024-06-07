package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanRole;

import java.util.List;

public interface ExcanRoleStore {

    public ExcanRole retrieve(int id);

    public List<ExcanRole> retrieveAll();

    public ExcanRole update(ExcanRole entity);

    public ExcanRole create(ExcanRole entity);

    public void delete(int id);
    ExcanRole findById(int id);

    List<ExcanRole> findByName(String name);
    List<ExcanRole> findAll();

}
