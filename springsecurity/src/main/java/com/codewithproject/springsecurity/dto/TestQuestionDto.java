package com.codewithproject.springsecurity.dto;

import com.codewithproject.springsecurity.dto.entitydto.QuestionDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestQuestionDto {

    // TestDto
    private Integer idTest;

    private String titleTest;

    // QuestionDto
    private List<QuestionDto> questions;
}
