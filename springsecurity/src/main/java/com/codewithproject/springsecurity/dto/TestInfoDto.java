package com.codewithproject.springsecurity.dto;

import com.codewithproject.springsecurity.dto.entitydto.QuestionSectionDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestInfoDto {

    private Integer idTest;

    private String titleTest;

    private int duration; // seconds

    private List<QuestionSectionDto> questionSection;
}
