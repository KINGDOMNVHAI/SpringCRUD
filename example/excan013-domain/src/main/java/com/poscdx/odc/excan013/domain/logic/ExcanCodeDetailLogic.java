package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import com.poscdx.odc.excan013.domain.spec.ExcanCodeDetailService;
import com.poscdx.odc.excan013.domain.store.ExcanCodeDetailStore;

import java.util.List;
import java.util.Set;

public class ExcanCodeDetailLogic implements ExcanCodeDetailService
{
    private final ExcanCodeDetailStore store;

    public ExcanCodeDetailLogic(ExcanCodeDetailStore store) {
        this.store = store;
    }

    @Override
    public List<ExcanCodeDetail> findByCodeMaster(String code) {
        return this.store.findByCodeMaster(code);
    }

    @Override
    public List<ExcanCodeDetail> findAllByIdIn(List<Integer> id) {
        return this.store.findAllByIdIn(id);
    }

    @Override
    public List<ExcanCodeDetail> findAllByIdIn(Set<Integer> id) {
        return this.store.findAllByIdIn(id);
    }
}
