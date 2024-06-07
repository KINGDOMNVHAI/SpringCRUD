package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanAccessTokenLogic;
import com.poscdx.odc.excan013.domain.store.ExcanAccessTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanAccessTokenSpringLogic extends ExcanAccessTokenLogic
{
    public ExcanAccessTokenSpringLogic(ExcanAccessTokenStore store) {
        super(store);
    }
}
