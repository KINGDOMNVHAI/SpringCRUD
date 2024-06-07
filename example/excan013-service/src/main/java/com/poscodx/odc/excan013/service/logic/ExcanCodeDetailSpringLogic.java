package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanCodeDetailLogic;
import com.poscdx.odc.excan013.domain.store.ExcanCodeDetailStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExcanCodeDetailSpringLogic extends ExcanCodeDetailLogic
{
    public ExcanCodeDetailSpringLogic(ExcanCodeDetailStore store) {
        super(store);
    }
}
