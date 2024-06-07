package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanPerRole;
import com.poscdx.odc.excan013.domain.store.ExcanPerRoleStore;
import com.poscodx.odc.excan013.store.jpo.ExcanPerRoleJpo;
import com.poscodx.odc.excan013.store.repository.ExcanPerRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExcanPerRoleJpaStore
    implements ExcanPerRoleStore
{
    private final ExcanPerRoleRepository repository;

    public ExcanPerRoleJpaStore(ExcanPerRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanPerRole retrieve(int id) {
        Optional<ExcanPerRoleJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanPerRoleJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanPerRole> retrieveAll() {
        List<ExcanPerRoleJpo> retVal = this.repository.findAll();
        return ExcanPerRoleJpo.toDomains(retVal);
    }

    @Override
    public ExcanPerRole update(ExcanPerRole entity) {
        ExcanPerRoleJpo jpoToUpdate = new ExcanPerRoleJpo(entity);
        ExcanPerRoleJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanPerRole create(ExcanPerRole entity) {
        ExcanPerRoleJpo jpoToSave = new ExcanPerRoleJpo(entity);
        ExcanPerRoleJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }
}
