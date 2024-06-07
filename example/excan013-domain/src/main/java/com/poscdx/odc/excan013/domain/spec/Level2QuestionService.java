package com.poscdx.odc.excan013.domain.spec;

import com.google.gson.JsonObject;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;

import java.util.List;

public interface Level2QuestionService {
    ExcanQuestion find(int id);

    List<ExcanQuestion> findAll();

    ExcanQuestion createQuestion(JsonObject newExcanQuestionData);

    ExcanQuestion updateQuestion(JsonObject updateExcanQuestionData);

    boolean deleteQuestion(int questionId);
}
