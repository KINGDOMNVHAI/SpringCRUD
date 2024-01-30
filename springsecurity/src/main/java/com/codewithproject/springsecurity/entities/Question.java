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
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question", nullable = false)
    private Long idQuestion;

    @Column(name = "title_question", nullable = false)
    private String titleQuestion;

    @Column(name = "list_id_answer")
    private String listAnswer; // Ex: 1,7,8,10

    @Column(name = "type_questions")
    private Integer typeQuestion;

    @Column(name = "id_test")
    private Long idTest;
}
