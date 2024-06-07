package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.DTO.AnswerResultDTO;
import com.poscdx.odc.excan013.domain.DTO.BaseResponse;
import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.spec.Level2ExamCheckingService;
import com.poscdx.odc.excan013.domain.store.ExcanAnswerStore;
import com.poscdx.odc.excan013.domain.store.ExcanCandidateStore;
import com.poscdx.odc.excan013.domain.store.ExcanEQuestionStore;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Level2ExamCheckingLogic implements Level2ExamCheckingService {
    private final ExcanAnswerStore EAStore;
    private final ExcanEQuestionStore EEQStore;
    private final ExcanCandidateStore ECSStore;

    @Override
    public List<ExcanAnswer> findAnswersByQuestionId(int questionId) {
        return EAStore.findByQuestionId(questionId);
    }

    @Override
    public ExcanEQuestion findCandidateAnswerByQuestionId(int examId, int questionId) {
        return EEQStore.findByExamIdAndQuestionId(examId, questionId);
    }

    @Override
    public List<ExcanEQuestion> findCandidateAnswersByExamId(int examId) {
        return EEQStore.findByExamId(examId);
    }

    @Override
    public List<AnswerResultDTO> getAnswerResult(int examId) {
        List<Object[]> resultList = EEQStore.getAnswerResult(examId);
        List<AnswerResultDTO> answerResultDTOS = new ArrayList<>();
        AnswerResultDTO resultItemDto;
        for (Object[] object : resultList) {
            resultItemDto = new AnswerResultDTO(object);
            answerResultDTOS.add(resultItemDto);
        }
        return answerResultDTOS;
    }

    @Override
    public List<AnswerResultDTO> getAnswerResultByQuestionIdAndExamId(int questionId, int examId) {
        List<Object[]> resultList = EEQStore.getAnswerResultByQuestionIdAndExamId(questionId, examId);
        List<AnswerResultDTO> answerResultDTOS = new ArrayList<>();
        AnswerResultDTO resultItemDto;
        for (Object[] object : resultList) {
            resultItemDto = new AnswerResultDTO(object);
            answerResultDTOS.add(resultItemDto);
        }
        return answerResultDTOS;
    }

    @Override
    public BaseResponse<String> checkCorrect(int examId, int questionId) {
        ExcanEQuestion excanEQuestion = EEQStore.checkCorrect(examId, questionId);
        if (excanEQuestion == null) {
            return BaseResponse.<String>builder()
                    .isSuccess(false)
                    .statusCode(400)
                    .data("Check correct fail")
                    .build();
        }
        return BaseResponse.<String>builder()
                .isSuccess(true)
                .statusCode(200)
                .data("Check correct success")
                .build();
    }

    @Override
    public BaseResponse<String> checkIncorrect(int examId, int questionId) {
        ExcanEQuestion excanEQuestion = EEQStore.checkIncorrect(examId, questionId);
        if (excanEQuestion == null) {
            return BaseResponse.<String>builder()
                    .isSuccess(false)
                    .statusCode(400)
                    .data("Check incorrect fail")
                    .build();
        }
        return BaseResponse.<String>builder()
                .isSuccess(true)
                .statusCode(200)
                .data("Check incorrect success")
                .build();
    }

    @Override
    public BaseResponse<String> remark(int examId, int questionId) {
        ExcanEQuestion excanEQuestion = EEQStore.remark(examId, questionId);
        if (excanEQuestion == null) {
            return BaseResponse.<String>builder()
                    .isSuccess(false)
                    .statusCode(400)
                    .data("Remark fail")
                    .build();
        }
        return BaseResponse.<String>builder()
                .isSuccess(true)
                .statusCode(200)
                .data("Remark success")
                .build();
    }

    @Override
    public BaseResponse<String> changeStatusCandidate(int candidateId, int status) {
        ExcanCandidate excanCandidate = ECSStore.retrieve(candidateId);
        if (excanCandidate == null) {
            return BaseResponse.<String>builder()
                    .isSuccess(false)
                    .statusCode(400)
                    .data("Can not find candidate.")
                    .build();
        }
        excanCandidate.setStatus(status);
        ExcanCandidate updatedCandidate = ECSStore.update(excanCandidate);
        if (updatedCandidate == null) {
            return BaseResponse.<String>builder()
                    .isSuccess(false)
                    .statusCode(400)
                    .data("Can not update status of candidate.")
                    .build();
        }
        return BaseResponse.<String>builder()
                .isSuccess(true)
                .statusCode(200)
                .data("Update status of candidate success.")
                .build();
    }
}
