package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.store.ExcanEQuestionStore;
import com.poscodx.odc.excan013.store.jpo.ExcanAnswerJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanEQuestionJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanQuestionJpo;
import com.poscodx.odc.excan013.store.repository.ExcanEQuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ExcanEQuestionJpaStore
    implements ExcanEQuestionStore
{
    private final ExcanEQuestionRepository repository;

    public ExcanEQuestionJpaStore(ExcanEQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanEQuestion retrieve(int id) {
        Optional<ExcanEQuestionJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanEQuestionJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanEQuestion> retrieveAll() {
        List<ExcanEQuestionJpo> retVal = this.repository.findAll();
        return ExcanEQuestionJpo.toDomains(retVal);
    }

    @Override
    public ExcanEQuestion update(ExcanEQuestion entity) {
        ExcanEQuestionJpo jpoToUpdate = new ExcanEQuestionJpo(entity);
        ExcanEQuestionJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanEQuestion create(ExcanEQuestion entity) {
        ExcanEQuestionJpo jpoToSave = new ExcanEQuestionJpo(entity);
        ExcanEQuestionJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<ExcanQuestion> findQuestionsByExamId(int examId){
//        List<ExcanEQuestionJpo> retVal = this.repository.findByExamId(examId);
//        List<ExcanQuestionJpo>  datas = retVal.stream().map(ExcanEQuestionJpo::getQuestion).collect(Collectors.toList());
//        return ExcanQuestionJpo.toDomains(datas);
        return null;
    }

    @Override
    public List<ExcanAnswer> findAnswersByExamId(int examId) {
//        List<ExcanEQuestionJpo> retVal = this.repository.findByExamId(examId);
//        List<ExcanQuestionJpo>  datas = retVal.stream().map(ExcanEQuestionJpo::getQuestion).collect(Collectors.toList());
//        List<ExcanAnswerJpo> answers = datas.stream().map(ExcanQuestionJpo::getAnswers).flatMap(List::stream).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<ExcanEQuestion> findByExamId(int examId) {
        List<ExcanEQuestionJpo> retVal = this.repository.findByExamId(examId);
        return ExcanEQuestionJpo.toDomains(retVal);
    }

    @Override
    public ExcanEQuestion findByExamIdAndQuestionId(int examId, int questionId) {
        List<ExcanEQuestionJpo> retVal = this.repository.findByExamIdAndQuestionId(examId, questionId);
        if(retVal.isEmpty()) return null;
        return ExcanEQuestionJpo.toDomains(retVal).get(0);
    }

    @Override
    public List<Object[]> getAnswerResult(int examId) {
        return this.repository.getAnswerResult(examId);
    }

    @Override
    public List<Object[]> getAnswerResultByQuestionIdAndExamId(int questionId, int examId) {
        return this.repository.getAnswerResultQuestionIdAndExamId(questionId, examId);
    }

    @Override
    public ExcanEQuestion checkCorrect(int questionId, int examId) {
        ExcanEQuestion excanEQuestion = findByExamIdAndQuestionId(questionId, examId);
        excanEQuestion.setStatus(1);
        return update(excanEQuestion);
    }

    @Override
    public ExcanEQuestion checkIncorrect(int questionId, int examId) {
        ExcanEQuestion excanEQuestion = findByExamIdAndQuestionId(questionId, examId);
        excanEQuestion.setStatus(0);
        return update(excanEQuestion);
    }

    @Override
    public ExcanEQuestion remark(int questionId, int examId) {
        ExcanEQuestion excanEQuestion = findByExamIdAndQuestionId(questionId, examId);
        excanEQuestion.setStatus(-1);
        return update(excanEQuestion);
    }
}
