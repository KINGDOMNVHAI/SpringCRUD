package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.dto.TestDto;
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
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test", nullable = false)
    private Long idTest;

    @Column(name = "title_test", nullable = false)
    private String titleTest;

    public void convertToDto(TestDto dto, String lang) {
        dto.setIdTest(this.getIdTest());
        dto.setTitleTest(this.getTitleTest());
    }
}
