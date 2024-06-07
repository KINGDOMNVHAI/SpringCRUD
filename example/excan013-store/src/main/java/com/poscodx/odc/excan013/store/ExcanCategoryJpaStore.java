package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCategory;
import com.poscdx.odc.excan013.domain.store.ExcanCategoryStore;
import com.poscodx.odc.excan013.store.jpo.ExcanCategoryJpo;
import com.poscodx.odc.excan013.store.repository.ExcanCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExcanCategoryJpaStore
    implements ExcanCategoryStore
{
    private final ExcanCategoryRepository repository;

    public ExcanCategoryJpaStore(ExcanCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanCategory retrieve(int id) {
        Optional<ExcanCategoryJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanCategoryJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanCategory> retrieveAll() {
        List<ExcanCategoryJpo> retVal = this.repository.findAll();
        return ExcanCategoryJpo.toDomains(retVal);
    }

    @Override
    public ExcanCategory update(ExcanCategory entity) {
        ExcanCategoryJpo jpoToUpdate = new ExcanCategoryJpo(entity);
        ExcanCategoryJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanCategory create(ExcanCategory entity) {
        ExcanCategoryJpo jpoToSave = new ExcanCategoryJpo(entity);
        ExcanCategoryJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }
}
