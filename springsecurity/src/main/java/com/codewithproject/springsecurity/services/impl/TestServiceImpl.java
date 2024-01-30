package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.AnswerQuestionDto;
import com.codewithproject.springsecurity.dto.QuestionDto;
import com.codewithproject.springsecurity.dto.TestDto;
import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.TestQuestion;
import com.codewithproject.springsecurity.repository.TestRepository;
import com.codewithproject.springsecurity.seeder.TestQuestionAnswerSeeder;
import com.codewithproject.springsecurity.util.ArrayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl {

    @Autowired
    private TestRepository testRepo;

    @Autowired
    private TestQuestionAnswerSeeder testSeeder;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    public List<Test> seederTests() {
        List<Test> result = new ArrayList<>();
        result = testSeeder.seederTests();
        return result;
    }

    public List<TestQuestion> seederTestQuestion() {
        List<TestQuestion> result = new ArrayList<>();
        result = testSeeder.seederTestQuestion();
        return result;
    }

    public TestQuestionDto getTest(Integer idTest) {
        TestQuestionDto result = new TestQuestionDto();
        Optional<Test> test = testRepo.getTestById(idTest);
        if (test.isPresent()) {
            Test testInfo = test.get();
            result.setIdTest(testInfo.getIdTest());
            result.setTitleTest(testInfo.getTitleTest());

            List<QuestionDto> questionDtos = questionServiceImpl.getListQuestionByIdTest(idTest);
            result.setQuestions(questionDtos);

            if (!questionDtos.isEmpty()) {
                List<AnswerQuestionDto> answers = questionDtos.stream().map(q -> {
                    AnswerQuestionDto dto = new AnswerQuestionDto();

                    // get list String
                    String listAnswerStr = q.getListAnswer();
                    List<String> listAnswer = ArrayUtil.stringToIntArray(listAnswerStr);

                    // String to Integer


                    // Get answer


                    return dto;

                }).toList();
            }

            return result;
        }
        return result;
    }
}
