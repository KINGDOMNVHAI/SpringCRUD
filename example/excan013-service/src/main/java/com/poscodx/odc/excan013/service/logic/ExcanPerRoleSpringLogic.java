package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanPerRoleLogic;
import com.poscdx.odc.excan013.domain.store.ExcanPerRoleStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanPerRoleSpringLogic extends ExcanPerRoleLogic
{
    public ExcanPerRoleSpringLogic(ExcanPerRoleStore store) {
        super(store);
    }
}
