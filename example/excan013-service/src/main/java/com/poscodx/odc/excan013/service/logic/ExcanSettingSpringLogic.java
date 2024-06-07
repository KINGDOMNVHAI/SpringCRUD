package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanSettingLogic;
import com.poscdx.odc.excan013.domain.store.ExcanSettingStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanSettingSpringLogic extends ExcanSettingLogic
{
    public ExcanSettingSpringLogic(ExcanSettingStore store) {
        super(store);
    }
}
