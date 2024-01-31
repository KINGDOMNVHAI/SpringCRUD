package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerQuestionDto {

    private Long idAnswer;

    private String contentAnswer;

    private String numberAnswerInTest; // Ex: A,B,C,D
}
