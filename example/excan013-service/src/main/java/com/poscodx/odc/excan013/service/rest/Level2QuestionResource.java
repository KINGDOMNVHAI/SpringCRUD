package com.poscodx.odc.excan013.service.rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.poscdx.odc.excan013.domain.entity.*;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Router API for question Class
 *
 * @author 202290_nh.hung724
 * @since 2023-12
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/question")
public class Level2QuestionResource {

    private final ServiceLifecycle serviceLifecycle;

    /**
     * Retrieves a list of all ExcanQuestion objects.
     *
     * @return List<ExcanQuestion>: a list of all ExcanQuestion objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @GetMapping(path = "/all")
    @PreAuthorize("hasAuthority('GET_QUESTION')")
    public List<ExcanQuestion> findAll() {
        return this.serviceLifecycle.requestLevel2QuestionService().findAll();
    }

    /**
     * Retrieves a list of ExcanAnswer objects by the given questionID.
     *
     * @param questionId: the ID of the ExcanQuestion to search for
     * @return List<ExcanAnswer>: a list of ExcanAnswer objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @GetMapping(path = "/{id}/answer")
    @PreAuthorize("hasAuthority('GET_QUESTION')")
    public List<ExcanAnswer> findAllAnswerByQuestionId(@PathVariable("id") int questionId) {
        return this.serviceLifecycle.requestExcanAnswerService().findByQuestionId(questionId);
    }

    /**
     * Retrieves a ExcanQuestion objects by the given questionID.
     *
     * @param questionId: the ID of the ExcanQuestion to search for
     * @return ExcanQuestion: a ExcanQuestion objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('GET_QUESTION')")
    public ExcanQuestion findByQuestionId(@PathVariable("id") int questionId) {
        return this.serviceLifecycle.requestLevel2QuestionService().find(questionId);
    }

    /**
     * Create new ExcanQuestion
     *
     * @param newExcanQuestionData: a JSON contain data to create new ExcanQuestion
     * @return ExcanQuestion: a ExcanQuestion objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @PostMapping(path = "")
    @PreAuthorize("hasAuthority('ADD_QUESTION')")
    public ExcanQuestion createQuestion(@RequestBody String newExcanQuestionData) {
        return this.serviceLifecycle.requestLevel2QuestionService().createQuestion(JsonParser.parseString(newExcanQuestionData).getAsJsonObject());
    }

    /**
     * Update an existed ExcanQuestion
     *
     * @param updateExcanQuestionData: a JSON contain data to update an existed ExcanQuestion
     * @return ExcanQuestion: a ExcanQuestion objects
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @PutMapping(path = "")
    @PreAuthorize("hasAuthority('UPDATE_QUESTION')")
    public ExcanQuestion updateQuestion(@RequestBody String updateExcanQuestionData) {
        return this.serviceLifecycle.requestLevel2QuestionService().updateQuestion(JsonParser.parseString(updateExcanQuestionData).getAsJsonObject());
    }

    /**
     * Delete an existed ExcanQuestion
     *
     * @param questionId: Delete an existed ExcanQuestion by provided questionId
     * @return boolean: Deletion status
     * @author 202290_nh.hung724
     * @since 2023-12
     */
    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('DELETE_QUESTION')")
    public boolean deleteQuestion(@PathVariable("id") int questionId) {
        return this.serviceLifecycle.requestLevel2QuestionService().deleteQuestion(questionId);
    }
}
