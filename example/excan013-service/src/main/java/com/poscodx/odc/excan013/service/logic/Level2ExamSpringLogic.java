package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.Level2ExamLogic;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanExamService;
import com.poscdx.odc.excan013.domain.spec.ExcanSItemService;
import com.poscdx.odc.excan013.domain.spec.ExcanSettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2ExamSpringLogic extends Level2ExamLogic
{
    public Level2ExamSpringLogic(ExcanSettingService excanSettingService, ExcanSItemService excanSItemService,
                                 ExcanExamService excanExamService, ExcanCandidateService excanCandidateService) {
        super(excanSettingService, excanSItemService, excanExamService, excanCandidateService);
    }

}
