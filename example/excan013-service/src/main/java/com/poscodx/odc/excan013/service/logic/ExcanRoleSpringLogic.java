package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanRoleLogic;
import com.poscdx.odc.excan013.domain.store.ExcanRoleStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanRoleSpringLogic extends ExcanRoleLogic
{
    public ExcanRoleSpringLogic(ExcanRoleStore store) {
        super(store);
    }
}
