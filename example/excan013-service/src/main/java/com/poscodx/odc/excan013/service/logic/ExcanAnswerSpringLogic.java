package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanAnswerLogic;
import com.poscdx.odc.excan013.domain.store.ExcanAnswerStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanAnswerSpringLogic extends ExcanAnswerLogic
{
    public ExcanAnswerSpringLogic(ExcanAnswerStore store) {
        super(store);
    }
}
