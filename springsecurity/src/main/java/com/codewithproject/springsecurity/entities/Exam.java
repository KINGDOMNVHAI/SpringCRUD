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
@Table(name = "exams")
public class Exam {

    // Test chứa các câu hỏi.
    // Mỗi khi có 1 người làm bài test, 1 exam được tạo ra, lưu điểm số, người làm bài...

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam", nullable = false)
    private Long idExam;

    @Column(name = "id_test", nullable = false)
    private Long idTest;

    @Column(name = "id_question", nullable = false)
    private Long idQuestion;

    @Column(name = "id_answer", nullable = false)
    private Integer idAnswer;

    @Column(name = "total_score")
    private Float totalScore;

    @Column(name = "code_category_test", nullable = false)
    private String codeCategoryTest;
}
