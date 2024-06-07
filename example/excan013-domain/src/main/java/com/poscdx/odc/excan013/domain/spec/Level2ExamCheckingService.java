package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.DTO.AnswerResultDTO;
import com.poscdx.odc.excan013.domain.DTO.BaseResponse;
import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;

import java.util.List;

public interface Level2ExamCheckingService {
    List<ExcanAnswer> findAnswersByQuestionId(int questionId);

    ExcanEQuestion findCandidateAnswerByQuestionId(int examId, int questionId);

    List<ExcanEQuestion> findCandidateAnswersByExamId(int examId);

    List<AnswerResultDTO> getAnswerResult(int examId);

    List<AnswerResultDTO> getAnswerResultByQuestionIdAndExamId(int questionId, int examId);

    BaseResponse<String> checkCorrect(int examId, int questionId);

    BaseResponse<String> checkIncorrect(int examId, int questionId);

    BaseResponse<String> remark(int examId, int questionId);

    BaseResponse<String> changeStatusCandidate(int candidateId, int status);
}
