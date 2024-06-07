package com.poscdx.odc.excan013.domain.logic;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.enums.QuestionLevel;
import com.poscdx.odc.excan013.domain.entity.enums.QuestionType;
import com.poscdx.odc.excan013.domain.spec.*;
import com.poscdx.odc.excan013.domain.utils.Constants;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class Level2QuestionLogic implements Level2QuestionService {

    private final ExcanQuestionService questionService;
    private final ExcanUserService userService;
    private final ExcanEQuestionService eQuestionService;
    private final ExcanAnswerService answerService;

    @Override
    public ExcanQuestion find(int id) {
        ExcanQuestion question = this.questionService.find(id);

        List<ExcanUser> users = this.userService.findAllByIdIn(Arrays.asList(question.getCreateBy(), question.getUpdateBy()));
        users.forEach(user -> {
            if (user.getId().equals(question.getCreateBy())) {
                question.setCreateBy(user.getId());
                question.setCreateByName(user.getName());
                question.setCreateByAvatar(user.getAvatar());
            }

            if (user.getId().equals(question.getUpdateBy())) {
                question.setUpdateBy(user.getId());
                question.setUpdateByName(user.getName());
                question.setUpdateByAvatar(user.getAvatar());
            }
        });

//        if (question.getImage() != null && !question.getImage().isEmpty()) {
//            question.setImageURL(question.getImage());
//        }

        return question;
    }

    /**
     * @return
     */
    @Override
    public List<ExcanQuestion> findAll() {
        List<ExcanQuestion> questionList = questionService.findAll();
        List<ExcanEQuestion> excanEQuestionList = eQuestionService.findAll();
        for (ExcanQuestion question : questionList) {

            question.setDeleteFlag(true);
            //Set delete flag
            for (ExcanEQuestion exeq : excanEQuestionList) {
                if (exeq.getQuestionId() == question.getId()) question.setDeleteFlag(false);
            }

            //Set question type name
            if (question.getType() == QuestionType.ONE_SELECTION.value) {
                question.setQuestionTypeName(QuestionType.ONE_SELECTION.name);
            } else if (question.getType() == QuestionType.MULTI_SELECTION.value) {
                question.setQuestionTypeName(QuestionType.MULTI_SELECTION.name);
            } else if (question.getType() == QuestionType.FILL_IN_THE_BLANK.value) {
                question.setQuestionTypeName(QuestionType.FILL_IN_THE_BLANK.name);
            } else if (question.getType() == QuestionType.SHORT_ANSWER.value) {
                question.setQuestionTypeName(QuestionType.SHORT_ANSWER.name);
            }

            //Set level name
            if (question.getLevel() == QuestionLevel.EASY.value) {
                question.setQuestionLevelName(QuestionLevel.EASY.name);
            } else if (question.getLevel() == QuestionLevel.NORMAL.value) {
                question.setQuestionLevelName(QuestionLevel.NORMAL.name);
            } else if (question.getLevel() == QuestionLevel.HARD.value) {
                question.setQuestionLevelName(QuestionLevel.HARD.name);
            } else if (question.getLevel() == QuestionLevel.VERY_HARD.value) {
                question.setQuestionLevelName(QuestionLevel.VERY_HARD.name);
            }
        }

        return questionList;
    }

    /**
     * @param newExcanQuestionData
     * @return
     */
    @Override
    public ExcanQuestion createQuestion(JsonObject newExcanQuestionData) {
        ExcanQuestion newExcanQuestion = new ExcanQuestion();
        newExcanQuestion.setCategoryId(newExcanQuestionData.get("categoryId").getAsInt());
        newExcanQuestion.setContent(newExcanQuestionData.get("content").getAsString());
        newExcanQuestion.setType(newExcanQuestionData.get("type").getAsInt());
        newExcanQuestion.setScore(newExcanQuestionData.get("score").getAsInt());
        newExcanQuestion.setLevel(newExcanQuestionData.get("level").getAsInt());

//        newExcanQuestion.setImage(newExcanQuestionData.get("image").getAsString());
        newExcanQuestion.setCreateAt(new Date());
        newExcanQuestion = questionService.register(newExcanQuestion);


        JsonArray listAnswerJA = newExcanQuestionData.get("answerData").getAsJsonArray();
        ExcanAnswer newExcanAnswer;
        for (JsonElement je : listAnswerJA) {
            JsonObject answerJO = je.getAsJsonObject();
            newExcanAnswer = new ExcanAnswer();
            newExcanAnswer.setContent(answerJO.get("content").getAsString());
            newExcanAnswer.setQuestionId(newExcanQuestion.getId());
            newExcanAnswer.setIsCorrect(answerJO.get("isCorrect").getAsInt());
            newExcanAnswer.setAnswerOrder(answerJO.get("answerOrder").getAsString());
            newExcanAnswer.setScore(answerJO.get("score").getAsInt());
            newExcanAnswer.setCreateAt(new Date());
            answerService.register(newExcanAnswer);
        }
        return newExcanQuestion;
    }

    /**
     * @param updateExcanQuestionData
     * @return
     */
    @Override
    public ExcanQuestion updateQuestion(JsonObject updateExcanQuestionData) {
        ExcanQuestion updateQuestion =
                questionService.find(updateExcanQuestionData.get("id").getAsInt());
        ExcanQuestion newExcanQuestion = new ExcanQuestion();
        updateQuestion.setCategoryId(updateExcanQuestionData.get("categoryId").getAsInt());
        updateQuestion.setContent(updateExcanQuestionData.get("content").getAsString());
        updateQuestion.setType(updateExcanQuestionData.get("type").getAsInt());
//        updateQuestion.setImage(updateExcanQuestionData.get("image").getAsString());
        updateQuestion.setScore(updateExcanQuestionData.get("score").getAsInt());
        updateQuestion.setLevel(updateExcanQuestionData.get("level").getAsInt());
        updateQuestion.setUpdateAt(new Date());
        questionService.register(updateQuestion);

        JsonArray listAnswerJA = updateExcanQuestionData.get("answerData").getAsJsonArray();
        ExcanAnswer updateExcanAnswer;
        List<ExcanAnswer> removeAnswerList = answerService.findByQuestionId(updateQuestion.getId());

        for (JsonElement je : listAnswerJA) {
            JsonObject answerJO = je.getAsJsonObject();
            updateExcanAnswer = answerService.find(answerJO.get("id").getAsInt());
            if ((answerJO.has("flag") && "new".equals(answerJO.get("flag").getAsString())) || updateExcanAnswer == null) {
                updateExcanAnswer = new ExcanAnswer();
                updateExcanAnswer.setQuestionId(updateQuestion.getId());
            } else {
                for (ExcanAnswer exa : removeAnswerList) {
                    if (updateExcanAnswer.getId() == exa.getId()) {
                        removeAnswerList.remove(exa);
                        break;
                    }
                }
            }
            updateExcanAnswer.setContent(answerJO.get("content").getAsString());
            updateExcanAnswer.setIsCorrect(answerJO.get("isCorrect").getAsInt());
            updateExcanAnswer.setAnswerOrder(answerJO.get("answerOrder").getAsString());
            updateExcanAnswer.setScore(answerJO.get("score").getAsInt());
            updateExcanAnswer.setUpdateAt(new Date());
            answerService.register(updateExcanAnswer);
        }

        for (ExcanAnswer exa : removeAnswerList) answerService.remove(exa.getId());

        return newExcanQuestion;
    }

    /**
     * @param questionId
     * @return
     */
    @Override
    public boolean deleteQuestion(int questionId) {
        try {

            for (ExcanEQuestion exeq : eQuestionService.findAll()) {
                if (exeq.getQuestionId() == questionId) return false;
            }
            List<ExcanAnswer> answerList = answerService.findByQuestionId(questionId);
            for (ExcanAnswer exa : answerList) {
                answerService.remove(exa.getId());
            }

            questionService.remove(questionId);
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }
}
