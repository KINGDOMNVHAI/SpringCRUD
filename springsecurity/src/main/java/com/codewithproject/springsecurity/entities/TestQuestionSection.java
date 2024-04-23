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
@Table(name = "test_question_section")
public class TestQuestionSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test_qs", nullable = false)
    private Long idTestQS;

    @Column(name = "id_test", nullable = false)
    private Integer idTest;

    @Column(name = "id_qs", nullable = false)
    private Integer idQuestionSection;

    @Column(name = "seq_qs", nullable = false)
    private Integer seqQS;
}
