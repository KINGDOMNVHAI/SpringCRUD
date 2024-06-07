package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import com.poscdx.odc.excan013.domain.store.ExcanCodeDetailStore;
import com.poscodx.odc.excan013.store.jpo.ExcanCodeDetailJpo;
import com.poscodx.odc.excan013.store.repository.ExcanCodeDetailRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ExcanCodeDetailJpaStore implements ExcanCodeDetailStore
{
    private final ExcanCodeDetailRepository repository;

    public ExcanCodeDetailJpaStore(ExcanCodeDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ExcanCodeDetail> findByCodeMaster(String code) {
        List<ExcanCodeDetailJpo> retVal = this.repository.findByCodeMaster(code);
        return ExcanCodeDetailJpo.toDomains(retVal);
    }

    @Override
    public List<ExcanCodeDetail> findAllByIdIn(List<Integer> id) {
        List<ExcanCodeDetailJpo> jpos = this.repository.findAllByIdIn(id);
        return ExcanCodeDetailJpo.toDomains(jpos);
    }

    @Override
    public List<ExcanCodeDetail> findAllByIdIn(Set<Integer> id) {
        List<ExcanCodeDetailJpo> jpos = this.repository.findAllByIdIn(id);
        return ExcanCodeDetailJpo.toDomains(jpos);
    }

}
