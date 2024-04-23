package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.TestDto;
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
    private Integer idTest;

    @Column(name = "url_test", nullable = false)
    private String urlTest;

    @Column(name = "title_test_vi", nullable = false)
    private String titleTestVI;

    @Column(name = "title_test_en", nullable = false)
    private String titleTestEN;

    @Column(name = "title_test_jp", nullable = false)
    private String titleTestJP;

    @Column(name = "desc_test_vi", nullable = true)
    private String descTestVI;

    @Column(name = "desc_test_en", nullable = true)
    private String descTestEN;

    @Column(name = "desc_test_jp", nullable = true)
    private String descTestJP;

    @Column(name = "code_category_test", nullable = false)
    private String codeCategoryTest;

    @Column(name = "duration")
    private int duration; // seconds

    public void convertToDto(TestDto dto, String lang) {
        dto.setIdTest(this.getIdTest());
        dto.setUrlTest(this.getUrlTest());
        dto.setCodeCategoryTest(this.getCodeCategoryTest());
        dto.setDuration(this.getDuration());
        if (lang.equals(Constants.LANG_EN)) {
            dto.setTitleTest(this.getTitleTestEN());
        } else if (lang.equals(Constants.LANG_JP)) {
            dto.setTitleTest(this.getTitleTestJP());
        } else {
            dto.setTitleTest(this.getTitleTestVI());
        }
    }
}
