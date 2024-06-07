package com.poscdx.odc.excan013.domain.store;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;

import javax.persistence.Tuple;
import java.util.List;

public interface ExcanCandidateStore {

    public ExcanCandidate retrieve(int id);

    public List<ExcanCandidate> retrieveAll();

    public List<Tuple> retrieveByCond(SearchCandidateDto searchDto);

    public ExcanCandidate update(ExcanCandidate entity);

    public ExcanCandidate create(ExcanCandidate entity);

    public void delete(int id);

    List<Tuple> getCanCheckingListForDashboard();

    List<Tuple> getCanResultListForDashboard();
}
