package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanExamLogic;
import com.poscdx.odc.excan013.domain.store.ExcanExamStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanExamSpringLogic extends ExcanExamLogic
{
    public ExcanExamSpringLogic(ExcanExamStore store) {
        super(store);
    }
}
