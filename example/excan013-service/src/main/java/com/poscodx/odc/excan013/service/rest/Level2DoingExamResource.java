package com.poscodx.odc.excan013.service.rest;


import com.poscdx.odc.excan013.domain.entity.*;
import com.poscdx.odc.excan013.domain.entity.payload.request.SubmitExamRequest;
import com.poscdx.odc.excan013.domain.entity.payload.response.MessageResponse;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Router API for doing exam Class
 *
 * @author 202304_Cuong
 * @since 2024-1-2
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/doing-exam")
public class Level2DoingExamResource {

    private final ServiceLifecycle serviceLifecycle;

    /**
     * Retrieves a list of ExcanQuestion objects by the given ID.
     *
     * @param id: the ID of the ExcanExam to search for
     * @return List<ExcanQuestion>: a list of ExcanQuestion objects
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @GetMapping(path = "/{id}/questions")

    public List<ExcanQuestion> findQuestions(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanExamService().find(id).getQuestions();
    }

    /**
     * Retrieves a list of ExcanAnswer objects by the given ID.
     *
     * @param id: the ID of the ExcanExam to search for
     * @return List<ExcanAnswer>: a list of ExcanAnswer objects
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @GetMapping(path = "/{id}/answers")
    public List<ExcanAnswer> findAnswers(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanExamService().findAnswersInExam(id);
    }

    /**
     * Retrieves a list of exam questions for a given ID.
     *
     * @param  id  the ID of the exam
     * @return     a list of exam questions
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @GetMapping(path = "/{id}/exam-questions")
    public List<ExcanEQuestion> findExamQuestions(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanEQuestionService().findByExamId(id);
    }

    /**
     * Saves the exam questions and finishes the exam.
     *
     * @param id              the ID of the exam
     * @param requestData the list of exam questions
     * @return the response entity
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @PutMapping(path = "/{id}/save")
    public ResponseEntity<?> saveExamQuestions(@PathVariable("id") int id, @RequestBody SubmitExamRequest requestData) {
        return this.serviceLifecycle.requestLevel2DoingExamService().saveExam(this.serviceLifecycle, id, requestData);
    }


    /**
     * Start the exam.
     *
     * @param id the ID of the exam
     * @return the response entity
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @PutMapping(path = "/{id}/start")
    public ResponseEntity<?> startExam(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestLevel2DoingExamService().startExam(this.serviceLifecycle, id);
    }


    /**
     * Finds an exam by the given candidate ID.
     *
     * @param id the ID of candidate
     * @return the found exam
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @GetMapping(path = "/candidate/{id}/exam")
    public ResponseEntity<?> findExam(@PathVariable("id") int id) {
        ExcanExam exam = this.serviceLifecycle.requestExcanExamService().findByCandidateId(id);
        if(exam!=null){
            ExcanSetting setting = this.serviceLifecycle.requestExcanSettingService().find(exam.getSettingId());
            if(setting == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Exam is not available, please contact admin!"));
            }
            exam.setDuration(setting.getDuration());
            exam.setExamTitle(setting.getName());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Exam is not available, please contact admin!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(exam);
    }
    /**
     * Finds an candidate by the given ID.
     *
     * @param id the ID of candidate
     * @return the found exam
     * @author 202304_Cuong
     * @since 2024-1-2
     */
    @CrossOrigin
    @GetMapping(path = "candidate/{id}")
    public ExcanCandidate find(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanCandidateService().find(id);
    }
}
