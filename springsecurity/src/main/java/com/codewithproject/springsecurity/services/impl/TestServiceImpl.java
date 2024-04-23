package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.AnswerQuestionDto;
import com.codewithproject.springsecurity.dto.entitydto.QuestionDto;
import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.repository.TestRepository;
import com.codewithproject.springsecurity.seeder.QuestionSectionSeeder;
import com.codewithproject.springsecurity.seeder.TestQuestionAnswerSeeder;
import com.codewithproject.springsecurity.seeder.TestSeeder;
import com.codewithproject.springsecurity.services.TestService;
import com.codewithproject.springsecurity.util.ArrayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    @Autowired
    private AnswerServiceImpl answerServiceImpl;

    @Autowired
    private TestRepository testRepo;

    @Autowired
    private TestSeeder testSeeder;

    @Autowired
    private QuestionSectionSeeder qsSeeder;

    @Autowired
    private TestQuestionAnswerSeeder testQuestionAnswerSeeder;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    public void truncateTests() {
        testRepo.truncateTable();
    }

    public List<Test> seederTests() {
        truncateTests();
        List<Test> listTest = new ArrayList<>();
        listTest = testSeeder.seederTests();
        qsSeeder.seederQuestionSection();
        qsSeeder.seederTestQuestionSection();
        return listTest;
    }

    public TestQuestionDto getTestQuestion(String urlTest, String lang) {
        TestQuestionDto result = new TestQuestionDto();
        Optional<Test> test = testRepo.getTestByURL(urlTest);
        if (test.isPresent()) {
            Test testInfo = test.get();
            result.setIdTest(testInfo.getIdTest());
            if (lang.equals(Constants.LANG_EN)) {
                result.setTitleTest(testInfo.getTitleTestEN());
            } if (lang.equals(Constants.LANG_JP)) {
                result.setTitleTest(testInfo.getTitleTestJP());
            } else {
                result.setTitleTest(testInfo.getTitleTestVI());
            }

            List<QuestionDto> questionDtos = questionServiceImpl.getListQuestionByIdTest(urlTest);

            if (!questionDtos.isEmpty()) {
                for (QuestionDto q : questionDtos) {
                    // get list answers of question
                    List<String> listStrAnswer = ArrayUtil.stringToIntArray(q.getListAnswer());
                    // Collections.shuffle(listStrAnswer);

                    // String to Integer
                    List<Integer> listIntAnswer = listStrAnswer.stream().map(Integer::parseInt).toList();

                    // Get answer
                    List<AnswerQuestionDto> answers = new ArrayList<>();
                    List<Answer> listAnswer = answerServiceImpl.getListAnswerByListId(listIntAnswer);
                    List<String> listAlphabet = ArrayUtil.ARRAY_ALPHABET;

                    for (int i = 0; i < listAnswer.size(); i++) {
                        AnswerQuestionDto dto = new AnswerQuestionDto();
                        dto.setNumberAnswerInTest(listAlphabet.get(i));
                        dto.setContentAnswer(listAnswer.get(i).getContentAnswerVI());
                        answers.add(dto);
                    }
                    q.setAnswers(answers);
                }
                result.setQuestions(questionDtos);
            }
            return result;
        }
        return result;
    }
}
