package com.codewithproject.springsecurity.dto.entitydto;

import com.codewithproject.springsecurity.dto.AnswerQuestionDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {

    private Integer seqQuestion;

    private String contentQuestion;

    private String listAnswer; // Ex: 1,7,8,10

    private List<AnswerQuestionDto> answers;

    private Integer typeQuestion;
}
