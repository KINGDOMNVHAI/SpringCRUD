package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.Level2CandidateLogic;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanCodeDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2CandidateSpringLogic extends Level2CandidateLogic
{
    public Level2CandidateSpringLogic(ExcanCandidateService candidateService,
                                      ExcanCodeDetailService codeDetailService) {
        super(candidateService, codeDetailService);
    }
}
