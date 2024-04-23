package com.codewithproject.springsecurity.dto.entitydto;

import com.codewithproject.springsecurity.entities.CategoryTest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryTestDto {

    private Long idCategoryTest;
    private String codeCategoryTest;
    private String parentCategoryTest;
    private boolean enableCategoryTest;

    public CategoryTest convertToEntity(String lang) {
        CategoryTest entity = new CategoryTest();
        entity.setIdCategoryTest(this.idCategoryTest);
        entity.setCodeCategoryTest(this.codeCategoryTest);
        entity.setParentCategoryTest(this.parentCategoryTest);
        entity.setEnableCategoryTest(this.enableCategoryTest);
        return entity;
    }
}
