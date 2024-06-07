package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanSItemLogic;
import com.poscdx.odc.excan013.domain.store.ExcanSItemStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanSItemSpringLogic extends ExcanSItemLogic
{
    public ExcanSItemSpringLogic(ExcanSItemStore store) {
        super(store);
    }
}
