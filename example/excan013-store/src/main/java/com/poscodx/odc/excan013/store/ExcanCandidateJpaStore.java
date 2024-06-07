package com.poscodx.odc.excan013.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;
import com.poscdx.odc.excan013.domain.store.ExcanCandidateStore;
import com.poscodx.odc.excan013.store.jpo.ExcanCandidateJpo;
import com.poscodx.odc.excan013.store.repository.ExcanCandidateRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public class ExcanCandidateJpaStore
        implements ExcanCandidateStore {
    private final ExcanCandidateRepository repository;

    public ExcanCandidateJpaStore(ExcanCandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExcanCandidate retrieve(int id) {
        Optional<ExcanCandidateJpo> retVal = this.repository.findById(id);
        return retVal.map(ExcanCandidateJpo::toDomain).orElse(null);
    }

    @Override
    public List<ExcanCandidate> retrieveAll() {
        List<ExcanCandidateJpo> retVal = this.repository.findAll();
        return ExcanCandidateJpo.toDomains(retVal);
    }

    @Override
    public List<Tuple> retrieveByCond(SearchCandidateDto searchDto) {
        int[] status = ArrayUtils.isNotEmpty(searchDto.getStatus()) ? searchDto.getStatus() : null;
        return this.repository.findByCond(searchDto.getName(), status, searchDto.getEmail(), searchDto.getScore(), searchDto.getInterviewDateFrom(),
                searchDto.getInterviewDateTo());
    }

    @Override
    public ExcanCandidate update(ExcanCandidate entity) {
        ExcanCandidateJpo jpoToUpdate = new ExcanCandidateJpo(entity);
        ExcanCandidateJpo updatedJpo = this.repository.save(jpoToUpdate);
        return updatedJpo.toDomain();
    }

    @Override
    public ExcanCandidate create(ExcanCandidate entity) {
        ExcanCandidateJpo jpoToSave = new ExcanCandidateJpo(entity);
        ExcanCandidateJpo savedJpo = this.repository.save(jpoToSave);
        return savedJpo.toDomain();
    }

    @Override
    public void delete(int id) {
        this.repository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Tuple> getCanCheckingListForDashboard() {
        return this.repository.getCanCheckingListForDashboard();
    }

    /**
     * @return
     */
    @Override
    public List<Tuple> getCanResultListForDashboard() {
        return this.repository.getCanResultListForDashboard();
    }
}
