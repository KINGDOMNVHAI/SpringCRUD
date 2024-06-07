package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanPermissionLogic;
import com.poscdx.odc.excan013.domain.store.ExcanPermissionStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanPermissionSpringLogic extends ExcanPermissionLogic
{
    public ExcanPermissionSpringLogic(ExcanPermissionStore store) {
        super(store);
    }
}
