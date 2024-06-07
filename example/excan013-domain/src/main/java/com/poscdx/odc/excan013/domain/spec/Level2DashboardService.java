package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;

import java.util.List;

public interface Level2DashboardService {

    String getCandidateStats();

    String getExamStats();

    String getResultsStats();

    List<ExcanCandidate> getCanCheckingList();

    List<ExcanCandidate> getCanResultList();
}
