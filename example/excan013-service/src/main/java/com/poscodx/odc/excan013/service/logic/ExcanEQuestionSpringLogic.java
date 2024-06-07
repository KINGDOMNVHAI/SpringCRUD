package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanEQuestionLogic;
import com.poscdx.odc.excan013.domain.store.ExcanEQuestionStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanEQuestionSpringLogic extends ExcanEQuestionLogic
{
    public ExcanEQuestionSpringLogic(ExcanEQuestionStore store) {
        super(store);
    }
}
