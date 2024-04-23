package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestSeeder {

    @Autowired
    private TestRepository testRepo;

    public List<Test> seederTests() {
        List<Test> result = new ArrayList<>();
        try {
            Test testN41 = new Test();
            testN41.setTitleTestVI("Test N4 bài 1");
            testN41.setTitleTestEN("Test N4 bài 1");
            testN41.setTitleTestJP("Test N4 bài 1");
            testN41.setUrlTest("n4-test-1");
            testN41.setCodeCategoryTest("CT_JP_N4_1");
            testN41.setDuration(1800);
            testRepo.save(testN41);
            result.add(testN41);

            Test testN51 = new Test();
            testN51.setTitleTestVI("Test N5 bài 1");
            testN51.setTitleTestEN("Test N5 bài 1");
            testN51.setTitleTestJP("Test N5 bài 1");
            testN51.setUrlTest("n5-test-1");
            testN51.setCodeCategoryTest("CT_JP_N5_1");
            testN51.setDuration(1800);
            testRepo.save(testN51);
            result.add(testN51);

            Test testJava1 = new Test();
            testJava1.setTitleTestVI("Java Test: Beginner 1");
            testJava1.setTitleTestEN("Java Test: Beginner 1");
            testJava1.setTitleTestJP("Java Test: Beginner 1");
            testJava1.setUrlTest("java-beginner-1");
            testJava1.setCodeCategoryTest("CT_DEV_JAVA_BEGINNER_1");
            testJava1.setDuration(1800);
            testRepo.save(testJava1);
            result.add(testJava1);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
