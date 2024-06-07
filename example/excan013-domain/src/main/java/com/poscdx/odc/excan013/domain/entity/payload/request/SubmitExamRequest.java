package com.poscdx.odc.excan013.domain.entity.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SubmitExamRequest {
    @JsonProperty
    private boolean isFinished;

    List<ExcanEQuestion> examQuestions;
}
