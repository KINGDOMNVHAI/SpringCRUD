package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.CategoryTestDto;
import com.codewithproject.springsecurity.entities.CategoryTest;
import com.codewithproject.springsecurity.repository.CategoryTestRepository;
import com.codewithproject.springsecurity.seeder.CategoryTestSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryTestServiceImpl {

    @Autowired
    private CategoryTestRepository categorytestRepo;

    @Autowired
    private CategoryTestSeeder categorytestSeeder;

    public void truncateCategoryTest() {
        categorytestRepo.truncateTable();
    }

    public List<CategoryTest> seederCategoryTest() {
        truncateCategoryTest();
        return categorytestSeeder.seederCategoryTest();
    }

    public List<CategoryTestDto> getListCategoryTests(Integer limit, String filter) {
        List<CategoryTestDto> result = new ArrayList<>();
        List<CategoryTest> listCategoryTest = categorytestRepo.getListCategoryTests();
        if (!listCategoryTest.isEmpty()) {
            result = listCategoryTest.stream().map(c -> {
                CategoryTestDto dto = new CategoryTestDto();
                c.convertToDto(dto, Constants.LANG_VI);
                return dto;
            }).collect(Collectors.toList());
        }
        return result;
    }
}
