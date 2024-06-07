package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExcanCandidateService {

    public ExcanCandidate find(int id);

    public List<ExcanCandidate> findAll();

    public List<ExcanCandidate> findCandidateList(SearchCandidateDto searchDto);

    public void modify(ExcanCandidate entityList);

    public ExcanCandidate register(ExcanCandidate entity);

    public void remove(int id);

    public List<ExcanCandidate> getCanCheckingListForDashboard();

    public List<ExcanCandidate> getCanResultListForDashboard();
}
