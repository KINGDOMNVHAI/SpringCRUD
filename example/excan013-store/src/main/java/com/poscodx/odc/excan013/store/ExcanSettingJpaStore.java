package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import com.poscdx.odc.excan013.domain.store.ExcanSettingStore;
import com.poscodx.odc.excan013.store.jpo.ExcanSettingJpo;
import com.poscodx.odc.excan013.store.repository.ExcanSettingRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ExcanSettingJpaStore
    implements ExcanSettingStore
{
    private final ExcanSettingRepository repository;

    public ExcanSettingJpaStore(ExcanSettingRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanSetting retrieve(int id) {
        Optional<ExcanSettingJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanSettingJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanSetting> retrieveAll() {
        List<ExcanSettingJpo> retVal = this.repository.findAll();
        return ExcanSettingJpo.toDomains(retVal);
    }

    @Override
    public List<ExcanSetting> search(SettingSearchDTO dto) {
        List<Object[]> retVal = this.repository.search(dto.getName(), dto.getCreatedDateFrom(), dto.getCreatedDateTo(), dto.getStatus());
        List<ExcanSetting> result = new ArrayList<ExcanSetting>();
        retVal.forEach(entry -> {
            ExcanSetting temp = new ExcanSetting();
            temp.setId((int) entry[0]);
            temp.setName((String) entry[1]);
            temp.setDuration((int) entry[2]);
            temp.setNumberOfQuestion((int) entry[3]);
            temp.setDescription((String) entry[4]);
            temp.setStatus((int) entry[5]);
            temp.setCreateBy((String) entry[6]);
            temp.setCreateAt((Date) entry[7]);
            result.add(temp);
        });

        return result;
    }

    @Override
    public ExcanSetting update(ExcanSetting entity) {
        ExcanSettingJpo jpoToUpdate = new ExcanSettingJpo(entity);
        ExcanSettingJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanSetting create(ExcanSetting entity) {
        ExcanSettingJpo jpoToSave = new ExcanSettingJpo(entity);
        ExcanSettingJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }
}
