package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.Level2DashboardLogic;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2DashboardSpringLogic extends Level2DashboardLogic {

    public Level2DashboardSpringLogic(ExcanCandidateService candidateService, ExcanExamService examService) {
        super(candidateService, examService);
    }
}
