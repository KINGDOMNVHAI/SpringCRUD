package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.store.ExcanQuestionStore;
import com.poscodx.odc.excan013.store.jpo.ExcanQuestionJpo;
import com.poscodx.odc.excan013.store.repository.ExcanQuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExcanQuestionJpaStore
    implements ExcanQuestionStore
{
    private final ExcanQuestionRepository repository;

    public ExcanQuestionJpaStore(ExcanQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanQuestion retrieve(int id) {
        Optional<ExcanQuestionJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanQuestionJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanQuestion> retrieveAll() {
        List<ExcanQuestionJpo> retVal = this.repository.findAll();
        return ExcanQuestionJpo.toDomains(retVal);
    }

    @Override
    public ExcanQuestion update(ExcanQuestion entity) {
        ExcanQuestionJpo jpoToUpdate = new ExcanQuestionJpo(entity);
        ExcanQuestionJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanQuestion create(ExcanQuestion entity) {
        ExcanQuestionJpo jpoToSave = new ExcanQuestionJpo(entity);
        ExcanQuestionJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

}
