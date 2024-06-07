package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanCandidateLogic;
import com.poscdx.odc.excan013.domain.store.ExcanCandidateStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanCandidateSpringLogic extends ExcanCandidateLogic
{
    public ExcanCandidateSpringLogic(ExcanCandidateStore store) {
        super(store);
    }
}
