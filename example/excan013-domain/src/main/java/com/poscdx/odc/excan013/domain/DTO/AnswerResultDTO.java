package com.poscdx.odc.excan013.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AnswerResultDTO {
    private int questionId;
    private int answerId;
    private int score;
    private String answerOrder;
    private String candidateAnswer;
    private int status;
    private String correctAnswerContent;
    private int questionType;

    public AnswerResultDTO(Object[] object) {
        this.questionId = (int) object[0];
        this.answerId = (int) object[1];
        this.score = (int) object[2];
        this.answerOrder = object[3] == null ? "" : (String) object[3];
        this.candidateAnswer = (String) object[4];
        this.status = object[5] == null ? -1 : (int) object[5];
        this.correctAnswerContent = object[6] == null ? "" : (String) object[6];
        this.questionType = (int) object[7];
    }
}
