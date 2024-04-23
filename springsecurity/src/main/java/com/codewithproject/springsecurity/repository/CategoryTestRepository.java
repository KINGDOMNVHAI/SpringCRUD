package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.CategoryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryTestRepository extends JpaRepository<CategoryTest, String> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE category_test", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT ct.code_category_test FROM category_test ct", nativeQuery = true)
    List<String> getAllCodeCategoryTests();

    @Query(value = "SELECT ct.* FROM category_test ct", nativeQuery = true)
    List<CategoryTest> getListCategoryTests();

    @Query(value = "SELECT ct.*"
            + " FROM category_test ct"
            + " WHERE ct.parent_category_test IS NOT NULL", nativeQuery = true)
    List<CategoryTest> getListCategoryTestsHaveParent();
}
