package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;

import java.util.List;
import java.util.Set;

public interface ExcanCodeDetailStore {

    List<ExcanCodeDetail> findByCodeMaster(String code);

    List<ExcanCodeDetail> findAllByIdIn(List<Integer> id);

    List<ExcanCodeDetail> findAllByIdIn(Set<Integer> id);
}
