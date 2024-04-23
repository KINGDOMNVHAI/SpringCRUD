package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.CategoryTestDto;
import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.util.DateUtil;
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
@Table(name = "category_test")
public class CategoryTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category_test", nullable = false)
    private Long idCategoryTest;

    @Column(name = "code_category_test", nullable = false)
    private String codeCategoryTest;

    @Column(name = "parent_category_test")
    private String parentCategoryTest;

    @Column(name = "enable_category_test")
    private boolean enableCategoryTest;

    public void convertToDto(CategoryTestDto dto, String lang) {
        dto.setIdCategoryTest(this.idCategoryTest);
        dto.setCodeCategoryTest(this.codeCategoryTest);
        dto.setParentCategoryTest(this.parentCategoryTest);
        dto.setEnableCategoryTest(this.enableCategoryTest);
    }
}
