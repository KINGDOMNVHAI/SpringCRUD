package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.store.ExcanAnswerStore;
import com.poscodx.odc.excan013.store.jpo.ExcanAnswerJpo;
import com.poscodx.odc.excan013.store.repository.ExcanAnswerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExcanAnswerJpaStore
    implements ExcanAnswerStore
{
    private final ExcanAnswerRepository repository;

    public ExcanAnswerJpaStore(ExcanAnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanAnswer retrieve(int id) {
        Optional<ExcanAnswerJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanAnswerJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanAnswer> retrieveAll() {
        List<ExcanAnswerJpo> retVal = this.repository.findAll();
        return ExcanAnswerJpo.toDomains(retVal);
    }

    @Override
    public ExcanAnswer update(ExcanAnswer entity) {
        ExcanAnswerJpo jpoToUpdate = new ExcanAnswerJpo(entity);
        ExcanAnswerJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanAnswer create(ExcanAnswer entity) {
        ExcanAnswerJpo jpoToSave = new ExcanAnswerJpo(entity);
        ExcanAnswerJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    /**
     * @param questionId
     * @return
     */
    @Override
    public List<ExcanAnswer> findByQuestionId(int questionId) {
        List<ExcanAnswerJpo> retVal = this.repository.findByQuestionId(questionId);
        return ExcanAnswerJpo.toDomains(retVal);
    }
}
