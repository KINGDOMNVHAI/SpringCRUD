package com.poscodx.odc.excan013.service.logic;

import com.poscdx.odc.excan013.domain.logic.Level2ExamCheckingLogic;
import com.poscdx.odc.excan013.domain.store.ExcanAnswerStore;
import com.poscdx.odc.excan013.domain.store.ExcanCandidateStore;
import com.poscdx.odc.excan013.domain.store.ExcanEQuestionStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class Level2ExamCheckingSpringLogic extends Level2ExamCheckingLogic {
    public Level2ExamCheckingSpringLogic(ExcanAnswerStore EAStore, ExcanEQuestionStore EEQStore, ExcanCandidateStore ECSStore) {
        super(EAStore, EEQStore, ECSStore);
    }
}
