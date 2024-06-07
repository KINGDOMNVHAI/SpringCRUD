package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanUserLogic;
import com.poscdx.odc.excan013.domain.logic.Level2QuestionLogic;
import com.poscdx.odc.excan013.domain.spec.ExcanAnswerService;
import com.poscdx.odc.excan013.domain.spec.ExcanEQuestionService;
import com.poscdx.odc.excan013.domain.spec.ExcanQuestionService;
import com.poscdx.odc.excan013.domain.spec.ExcanUserService;
import com.poscdx.odc.excan013.domain.store.ExcanQuestionStore;
import com.poscdx.odc.excan013.domain.store.ExcanUserStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2QuestionSpringLogic extends Level2QuestionLogic
{
    public Level2QuestionSpringLogic(ExcanQuestionService questionService, ExcanUserService userService,
                                     ExcanEQuestionService eQuestionService, ExcanAnswerService answerService) {
        super(questionService, userService, eQuestionService, answerService);
    }
}
