package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.CategoryTest;
import com.codewithproject.springsecurity.repository.CategoryTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryTestSeeder {

    @Autowired
    private CategoryTestRepository categoryTestRepo;

    public List<CategoryTest> seederCategoryTest() {
        List<CategoryTest> result = new ArrayList<>();
        try {
            // parent
            CategoryTest engUS = new CategoryTest();
            engUS.setCodeCategoryTest("CT_US");
            engUS.setEnableCategoryTest(true);
            categoryTestRepo.save(engUS);
            result.add(engUS);

            CategoryTest japan = new CategoryTest();
            japan.setCodeCategoryTest("CT_JP");
            japan.setEnableCategoryTest(true);
            categoryTestRepo.save(japan);
            result.add(japan);

            CategoryTest korea = new CategoryTest();
            korea.setCodeCategoryTest("CT_KR");
            korea.setEnableCategoryTest(true);
            categoryTestRepo.save(korea);
            result.add(korea);

            CategoryTest dev = new CategoryTest();
            dev.setCodeCategoryTest("CT_DEV");
            dev.setEnableCategoryTest(true);
            categoryTestRepo.save(dev);
            result.add(dev);

            // child
            CategoryTest japanN1 = new CategoryTest();
            japanN1.setCodeCategoryTest("CT_JP_N1");
            japanN1.setParentCategoryTest("CT_JP");
            japanN1.setEnableCategoryTest(true);
            categoryTestRepo.save(japanN1);
            result.add(japanN1);

            CategoryTest japanN2 = new CategoryTest();
            japanN2.setCodeCategoryTest("CT_JP_N2");
            japanN2.setParentCategoryTest("CT_JP");
            japanN2.setEnableCategoryTest(true);
            categoryTestRepo.save(japanN2);
            result.add(japanN2);

            CategoryTest japanN3 = new CategoryTest();
            japanN3.setCodeCategoryTest("CT_JP_N3");
            japanN3.setParentCategoryTest("CT_JP");
            japanN3.setEnableCategoryTest(true);
            categoryTestRepo.save(japanN3);
            result.add(japanN3);

            CategoryTest japanN4 = new CategoryTest();
            japanN4.setCodeCategoryTest("CT_JP_N4");
            japanN4.setParentCategoryTest("CT_JP");
            japanN4.setEnableCategoryTest(true);
            categoryTestRepo.save(japanN4);
            result.add(japanN4);

            CategoryTest japanN5 = new CategoryTest();
            japanN5.setCodeCategoryTest("CT_JP_N5");
            japanN5.setParentCategoryTest("CT_JP");
            japanN5.setEnableCategoryTest(true);
            categoryTestRepo.save(japanN5);
            result.add(japanN5);

            CategoryTest devJava = new CategoryTest();
            devJava.setCodeCategoryTest("CT_DEV_JAVA");
            devJava.setParentCategoryTest("CT_DEV");
            devJava.setEnableCategoryTest(true);
            categoryTestRepo.save(devJava);
            result.add(devJava);

            CategoryTest devJavaScript = new CategoryTest();
            devJavaScript.setCodeCategoryTest("CT_DEV_JAVASCRIPT");
            devJavaScript.setParentCategoryTest("CT_DEV");
            devJavaScript.setEnableCategoryTest(true);
            categoryTestRepo.save(devJavaScript);
            result.add(devJavaScript);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}

