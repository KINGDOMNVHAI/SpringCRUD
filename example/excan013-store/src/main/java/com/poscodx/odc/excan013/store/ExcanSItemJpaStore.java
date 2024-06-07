package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanSItem;
import com.poscdx.odc.excan013.domain.store.ExcanSItemStore;
import com.poscodx.odc.excan013.store.jpo.ExcanSItemJpo;
import com.poscodx.odc.excan013.store.repository.ExcanSItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExcanSItemJpaStore
    implements ExcanSItemStore
{
    private final ExcanSItemRepository repository;

    public ExcanSItemJpaStore(ExcanSItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanSItem retrieve(int id) {
        Optional<ExcanSItemJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanSItemJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanSItem> retrieveAll() {
        List<ExcanSItemJpo> retVal = this.repository.findAll();
        return ExcanSItemJpo.toDomains(retVal);
    }

    @Override
    public List<ExcanSItem> search(String settingId) {
        List<Object[]> retVal = this.repository.search(settingId);
        List<ExcanSItem> result = new ArrayList<ExcanSItem>();
        retVal.forEach(entry -> {
            ExcanSItem temp = new ExcanSItem();
            temp.setId((int) entry[0]);
            temp.setCategoryId((int) entry[1]);
            temp.setLevel((int) entry[2]);
            temp.setNumberOfQuestion((int) entry[3]);
            temp.setStatus((int) entry[4]);
            result.add(temp);
        });

        return result;
    }

    @Override
    public ExcanSItem update(ExcanSItem entity) {
        ExcanSItemJpo jpoToUpdate = new ExcanSItemJpo(entity);
        ExcanSItemJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanSItem create(ExcanSItem entity) {
        ExcanSItemJpo jpoToSave = new ExcanSItemJpo(entity);
        ExcanSItemJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public void deleteAllBySettingId(int settingId) {
        this.repository.deleteBySettingId(settingId);
    }
}
