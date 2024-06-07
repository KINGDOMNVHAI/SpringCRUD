package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.store.ExcanExamStore;
import com.poscodx.odc.excan013.store.jpo.ExcanAnswerJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanExamJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanQuestionJpo;
import com.poscodx.odc.excan013.store.repository.ExcanExamRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ExcanExamJpaStore
    implements ExcanExamStore
{
    private final ExcanExamRepository repository;

    public ExcanExamJpaStore(ExcanExamRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanExam retrieve(int id) {
        Optional<ExcanExamJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanExamJpo::toDomain).orElse(null);
    }
    @Override
    public List<ExcanAnswer> findAnswersInExam(int id) {
        Optional<ExcanExamJpo> retVal = this.repository.findById(id);
        if (retVal.isPresent()){
            List<ExcanAnswerJpo> answers = retVal.get().getQuestions().stream().map(ExcanQuestionJpo::getAnswers).flatMap(Collection::stream).collect(Collectors.toList());
            return ExcanAnswerJpo.toDomains(answers);
        }
       return  null;
    }

    @Override
    public ExcanExam retrieveByCandidateId(int id) {
        Optional<ExcanExamJpo> retVal = Optional.ofNullable(this.repository.findByCandidateId(id));
        return retVal.map(ExcanExamJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanExam> retrieveAll() {
        List<ExcanExamJpo> retVal = this.repository.findAll();
        return ExcanExamJpo.toDomains(retVal);
    }

    @Override
    public ExcanExam update(ExcanExam entity) {
        ExcanExamJpo jpoToUpdate = new ExcanExamJpo(entity);
        ExcanExamJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanExam create(ExcanExam entity) {
        ExcanExamJpo jpoToSave = new ExcanExamJpo(entity);
        ExcanExamJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public int generateExam(int examId, int profileId, String creator) {
        return this.repository.generateExam(examId, profileId, creator);
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public ExcanExam findByCandidateId(int candidateId) {
        return this.repository.findByCandidateId(candidateId).toDomain();
    }


}
