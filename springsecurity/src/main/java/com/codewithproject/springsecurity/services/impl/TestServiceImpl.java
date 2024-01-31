package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.dto.AnswerQuestionDto;
import com.codewithproject.springsecurity.dto.QuestionDto;
import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.TestQuestion;
import com.codewithproject.springsecurity.repository.TestRepository;
import com.codewithproject.springsecurity.seeder.TestQuestionAnswerSeeder;
import com.codewithproject.springsecurity.util.ArrayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl {

    @Autowired
    private AnswerServiceImpl answerServiceImpl;

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

            if (!questionDtos.isEmpty()) {
                for (QuestionDto q : questionDtos) {
                    // get list answers of question
                    List<String> listStrAnswer = ArrayUtil.stringToIntArray(q.getListAnswer());
//                    Collections.shuffle(listStrAnswer);

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
