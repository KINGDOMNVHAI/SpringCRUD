package com.codewithproject.springsecurity.entities;

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
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer", nullable = false)
    private Integer idAnswer;

    @Column(name = "id_question")
    private Long idQuestion;

    @Column(name = "content_answer_vi")
    private String contentAnswerVI;

    @Column(name = "content_answer_en")
    private String contentAnswerEN;

    @Column(name = "result_question")
    private Boolean resultQuestion; // True, False, Null
}
