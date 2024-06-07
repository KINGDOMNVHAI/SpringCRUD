package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanQuestionLogic;
import com.poscdx.odc.excan013.domain.store.ExcanQuestionStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanQuestionSpringLogic extends ExcanQuestionLogic
{
    public ExcanQuestionSpringLogic(ExcanQuestionStore store) {
        super(store);
    }
}
