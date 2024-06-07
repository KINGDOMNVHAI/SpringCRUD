package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.*;
import com.poscdx.odc.excan013.domain.entity.enums.CandidateStatus;
import com.poscdx.odc.excan013.domain.entity.enums.ExamStatus;
import com.poscdx.odc.excan013.domain.entity.payload.request.SubmitExamRequest;
import com.poscdx.odc.excan013.domain.entity.payload.response.MessageResponse;

import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Logic for doing exam Class
 *
 * @author 202304_Cuong
 * @since 2024-1-2
 */
public class Level2DoingExamLogic implements Level2DoingExamService {

    /**
     * Retrieves a list of ExcanQuestion objects based on the given examId.
     *
     * @param serviceLifecycle the ServiceLifecycle object used to request the ExcanEQuestionService
     * @param examId           the ID of the exam
     * @return a list of ExcanQuestion objects found for the given examId
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @Override
    public List<ExcanQuestion> findQuestionsByExamId(ServiceLifecycle serviceLifecycle, int examId) {
        return serviceLifecycle.requestExcanEQuestionService().findQuestionsByExamId(examId);
    }

    private boolean isValidExamTime(Date startTime,Date submitTime, int durationInMinutes){
        int BACKUP_NETWORK_LATENCY_IN_SECONDS = 60;

        long realityDurationInSeconds = Duration.between(startTime.toInstant(), submitTime.toInstant()).getSeconds();
        return realityDurationInSeconds <= durationInMinutes * 60 + BACKUP_NETWORK_LATENCY_IN_SECONDS;
    }

    /**
     * Starts an exam for a given exam ID.
     *
     * @param serviceLifecycle the service lifecycle object
     * @param examId           the ID of the exam to start
     * @return the ResponseEntity object containing the start time of the exam
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @Override
    public ResponseEntity<?> startExam(ServiceLifecycle serviceLifecycle, int examId) {
        ExcanExamService examService = serviceLifecycle.requestExcanExamService();
        ExcanSettingService settingService = serviceLifecycle.requestExcanSettingService();
        ExcanCandidateService candidateService = serviceLifecycle.requestExcanCandidateService();
        ExcanExam exam = examService.find(examId);

        if (exam == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Exam not found!"));
        }

        ExcanCandidate candidate = candidateService.find(exam.getCandidateId());
        if (candidate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Candidate not found!"));
        }

        ExcanSetting examSetting = settingService.find(exam.getSettingId());
        if (examSetting == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("ExamSetting not found!"));
        }

        if (exam.getStatus() == ExamStatus.NEW.getValue()) {
            Date startTime = new Date();
            exam.setStartTime(startTime);

            exam.setStatus(ExamStatus.TESTING.getValue());
            examService.modify(exam);

            candidate.setStatus(CandidateStatus.CHECKING.getValue());
            candidateService.modify(candidate);

            return ResponseEntity.status(HttpStatus.OK.value()).body(startTime);
        } else if (exam.getStatus() == ExamStatus.TESTING.getValue()) {
            if(exam.getStartTime() != null && !isValidExamTime(exam.getStartTime(), new Date(), examSetting.getDuration())){
                exam.setStatus(ExamStatus.COMPLETE.getValue());
                examService.modify(exam);
            }
            return ResponseEntity.status(HttpStatus.OK.value()).body(exam.getStartTime() == null ? new Date() : exam.getStartTime());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Exam is finished!"));
        }


    }


    /**
     * Finish the exam and update the exam status and candidate status accordingly.
     *
     * @param serviceLifecycle the service lifecycle object
     * @param id               the ID of the exam to finish
     * @param requestData  request data
     * @return the ResponseEntity object with the appropriate status and response message
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @Override
    public ResponseEntity<?> saveExam(ServiceLifecycle serviceLifecycle, int id, SubmitExamRequest requestData) {
        ExcanEQuestionService eQuestionService = serviceLifecycle.requestExcanEQuestionService();

        ExcanExamService examService = serviceLifecycle.requestExcanExamService();
        ExcanSettingService settingService = serviceLifecycle.requestExcanSettingService();

        List<ExcanEQuestion> excanEQuestions = requestData.getExamQuestions();
        boolean isFinished = requestData.isFinished();
        ExcanExam exam = examService.find(id);
        if (exam == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Exam not found!"));
        }


        ExcanSetting examSetting = settingService.find(exam.getSettingId());


        if (examSetting == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("ExamSetting not found!"));
        }
        if (exam.getStatus() != ExamStatus.TESTING.getValue()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Exam status is not valid for finish the exam!"));
        }
        if (exam.getStartTime() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Start time not found! Can't finish the exam!"));
        }

        if(isFinished){
            exam.setStatus(ExamStatus.COMPLETE.getValue());
            exam = examService.modify(exam);
        }

        Date submitTime = new Date();
        boolean isValidExam = isValidExamTime(exam.getStartTime(),submitTime, examSetting.getDuration());

        if (isValidExam) {

            if(isFinished){
                exam.setSubmitTime(submitTime);
                examService.modify(exam);
            }

            List<ExcanEQuestion> modifiedList = new ArrayList<>();
            for (ExcanEQuestion eQuestionJson : excanEQuestions) {
                ExcanEQuestion eQuestion = eQuestionService.find(eQuestionJson.getId());
                if (eQuestion == null) {
                    eQuestionService.register(eQuestionJson);
                } else {
                    eQuestion.setChosenAnswer(eQuestionJson.getChosenAnswer());
                    modifiedList.add(eQuestion);
                }
            }
            eQuestionService.modify(modifiedList);

            return ResponseEntity.status(HttpStatus.OK.value()).body(new MessageResponse("Submit successfully!"));
        }
//        examService.modify(exam);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("StartTime and FinishTime are not valid with the duration! So you are rejected"));
    }
}
