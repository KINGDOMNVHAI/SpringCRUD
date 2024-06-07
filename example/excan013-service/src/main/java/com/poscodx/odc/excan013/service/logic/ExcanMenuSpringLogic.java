package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanMenuLogic;
import com.poscdx.odc.excan013.domain.store.ExcanMenuStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanMenuSpringLogic extends ExcanMenuLogic
{
    public ExcanMenuSpringLogic(ExcanMenuStore store) {
        super(store);
    }
}
