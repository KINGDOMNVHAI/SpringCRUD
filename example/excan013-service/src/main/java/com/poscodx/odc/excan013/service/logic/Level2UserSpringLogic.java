package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.ExcanUserLogic;
import com.poscdx.odc.excan013.domain.logic.Level2UserLogic;
import com.poscdx.odc.excan013.domain.store.ExcanUserStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2UserSpringLogic extends Level2UserLogic
{
    public Level2UserSpringLogic() {
        super();
    }
}
