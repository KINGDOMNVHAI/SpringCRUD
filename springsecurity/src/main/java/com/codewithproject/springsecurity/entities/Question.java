package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.QuestionDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question", nullable = false)
    private Long idQuestion;

    @Column(name = "id_qs", nullable = false)
    private Integer idQuestionSection;

    @Column(name = "url_test", nullable = false)
    private String urlTest;

    @Column(name = "seq_question")
    private Integer seqQuestion; // 1,2,3,4

    @Column(name = "content_question_vi", nullable = false)
    private String contentQuestionVI;

    @Column(name = "content_question_en", nullable = false)
    private String contentQuestionEN;

    @Column(name = "explain_question_vi")
    private String explainQuestionVI;

    @Column(name = "explain_question_en")
    private String explainQuestionEN;

    @Column(name = "list_id_answer")
    private String listIdAnswer; // Ex: 1,7,8,10

    @Column(name = "type_questions")
    private Integer typeQuestion;

    @Column(name = "image")
    private String image;

    @Column(name = "score")
    private Double score;

    @Column(name = "enable_question")
    private boolean enableQuestion;

    public void convertToDto(QuestionDto dto, String lang) {
        dto.setListAnswer(this.listIdAnswer);
        dto.setSeqQuestion(this.seqQuestion);
        dto.setTypeQuestion(this.typeQuestion);
        if (lang.equals(Constants.LANG_EN)) {
            dto.setContentQuestion(this.getContentQuestionEN());
        } else {
            dto.setContentQuestion(this.getContentQuestionVI());
        }
    }
}
