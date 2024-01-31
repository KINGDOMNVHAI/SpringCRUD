package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.services.impl.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/test")
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @GetMapping("/{idTest}")
    public TestQuestionDto getTestByID(@PathVariable Integer idTest) {
        TestQuestionDto test = new TestQuestionDto();
        try {
            test = testServiceImpl.getTest(idTest);
            return test;
        } catch (Exception e) {

        }
        return test;
    }

}
