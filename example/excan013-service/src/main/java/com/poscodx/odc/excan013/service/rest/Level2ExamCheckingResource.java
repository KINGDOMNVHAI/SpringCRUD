package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.DTO.*;
import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/exam-checking")
public class Level2ExamCheckingResource {
    private final ServiceLifecycle serviceLifecycle;

    @GetMapping(path = "/{examId}/questions")
    public List<ExcanQuestion> findQuestions(@PathVariable("examId") int id) {
        return this.serviceLifecycle.requestExcanExamService().find(id).getQuestions();
    }

    @GetMapping(path = "/{questionId}/answers")
    public List<ExcanAnswer> findAnswersByQuestionId(@PathVariable("questionId") int id) {
        return this.serviceLifecycle.getLevel2ExamCheckingService().findAnswersByQuestionId(id);
    }

    @GetMapping(path = "/{examId}/answer-results-exam")
    public List<AnswerResultDTO> getAnswerResult(@PathVariable("examId") int id) {
        return this.serviceLifecycle.getLevel2ExamCheckingService().getAnswerResult(id);
    }

    @GetMapping(path = "/answer-results-question")
    public List<AnswerResultDTO> getAnswerResultByQuestionId(@RequestParam("questionId") int questionId, @RequestParam("examId") int examId) {
        return this.serviceLifecycle.getLevel2ExamCheckingService().getAnswerResultByQuestionIdAndExamId(questionId, examId);
    }

    @PutMapping(path = "/checkCorrect")
    public BaseResponse<String> checkCorrect(@RequestBody CheckCorrectRequest checkCorrectRequest) {
        if (checkCorrectRequest.getQuestionStatus() == 1)
            return this.serviceLifecycle.getLevel2ExamCheckingService().checkCorrect(checkCorrectRequest.getExamId(), checkCorrectRequest.getQuestionId());
        else if (checkCorrectRequest.getQuestionStatus() == 0)
            return this.serviceLifecycle.getLevel2ExamCheckingService().checkIncorrect(checkCorrectRequest.getExamId(), checkCorrectRequest.getQuestionId());
        else
            return this.serviceLifecycle.getLevel2ExamCheckingService().remark(checkCorrectRequest.getExamId(), checkCorrectRequest.getQuestionId());
    }

    @PutMapping("/changeStatus")
    public BaseResponse<String> changeStatusOfCandidate(@RequestBody ChangeStatusRequest req) {
        return this.serviceLifecycle.getLevel2ExamCheckingService().changeStatusCandidate(req.getCandidateId(), req.getStatus());
    }

    @PutMapping("/saveScore")
    public BaseResponse<String> saveScore(@RequestBody SaveScoreRequest scoreRequest) {
         ExcanExam exam = this.serviceLifecycle.requestExcanExamService().find(scoreRequest.getExamId());
         exam.setScore(scoreRequest.getScore());
         this.serviceLifecycle.requestExcanExamService().modify(exam);
         return BaseResponse.<String>builder()
                 .isSuccess(true)
                 .data("Save score success")
                 .statusCode(200)
                 .build();

    }
}
