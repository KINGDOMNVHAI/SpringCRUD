package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.dto.entitydto.QuestionSectionDto;
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
@Table(name = "question_section")
public class QuestionSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_qs", nullable = false)
    private Integer idQuestionSection;

    @Column(name = "title_qs", nullable = false)
    private String titleQS;

    public void convertToDto(QuestionSectionDto dto, String lang) {
        dto.setIdQuestionSection(this.idQuestionSection);
        dto.setTitleQS(this.titleQS);
    }
}
