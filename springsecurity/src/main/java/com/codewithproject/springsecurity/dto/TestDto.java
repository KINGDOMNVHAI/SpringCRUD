package com.codewithproject.springsecurity.dto;

import com.codewithproject.springsecurity.entities.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestDto {

    private Long idTest;

    private String titleTest;

    public Test convertToEntity(String lang) {
        Test entity = new Test();
        entity.setIdTest(this.idTest);
        entity.setTitleTest(this.titleTest);
        return entity;
    }
}
