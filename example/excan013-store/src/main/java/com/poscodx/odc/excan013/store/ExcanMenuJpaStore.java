package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import com.poscdx.odc.excan013.domain.store.ExcanMenuStore;
import com.poscodx.odc.excan013.store.jpo.ExcanMenuJpo;
import com.poscodx.odc.excan013.store.repository.ExcanMenuRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExcanMenuJpaStore implements ExcanMenuStore {
    private final ExcanMenuRepository repository;

    public ExcanMenuJpaStore(ExcanMenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanMenu retrieve(int id) {
        Optional<ExcanMenuJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanMenuJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanMenu> retrieveAll() {
        List<ExcanMenuJpo> retVal = this.repository.findAll();
        return ExcanMenuJpo.toDomains(retVal);
    }

    @Override
    public ExcanMenu update(ExcanMenu entity) {
        ExcanMenuJpo jpoToUpdate = new ExcanMenuJpo(entity);
        ExcanMenuJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanMenu create(ExcanMenu entity) {
        ExcanMenuJpo jpoToSave = new ExcanMenuJpo(entity);
        ExcanMenuJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<ExcanMenu> getLeftMenuByPermission(List<Integer> permissionList) {
        List<ExcanMenuJpo> retVal = this.repository.getLeftMenuByPermission(permissionList);
        return ExcanMenuJpo.toDomains(retVal);
    }
}
