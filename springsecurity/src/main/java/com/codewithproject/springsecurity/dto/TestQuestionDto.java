package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestQuestionDto {

    // TestDto
    private Long idTest;

    private String titleTest;

    // QuestionDto
    private List<QuestionDto> questions;
}
