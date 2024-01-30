package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {

    private String titleQuestion;

    private String listAnswer; // Ex: 1,7,8,10

    private List<AnswerQuestionDto> answers;

    private Integer typeQuestion;
}
