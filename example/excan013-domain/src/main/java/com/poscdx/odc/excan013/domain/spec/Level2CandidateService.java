package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface Level2CandidateService {
    ExcanCandidate find(int id);

    List<ExcanCandidate> findCandidateList(SearchCandidateDto searchDto);

    void exportToExcel(HttpServletResponse response, SearchCandidateDto searchDto) throws IOException;
}
