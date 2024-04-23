package com.codewithproject.springsecurity.dto.entitydto;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.entities.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto {

    private Integer idTest;

    private String urlTest;

    private String titleTest;

    private String codeCategoryTest;

    private int duration; // seconds

    public Test convertToEntity(String lang) {
        Test entity = new Test();
        entity.setIdTest(this.idTest);
        entity.setUrlTest(this.urlTest);
        if (lang.equals(Constants.LANG_EN)) {
            entity.setTitleTestEN(this.titleTest);
        } else if (lang.equals(Constants.LANG_JP)) {
            entity.setTitleTestJP(this.titleTest);
        } else {
            entity.setTitleTestVI(this.titleTest);
        }
        return entity;
    }
}
