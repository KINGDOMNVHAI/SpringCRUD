package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.QuestionDto;
import com.codewithproject.springsecurity.entities.Question;
import com.codewithproject.springsecurity.repository.QuestionRepository;
import com.codewithproject.springsecurity.seeder.TestQuestionAnswerSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    public TestQuestionAnswerSeeder testSeeder;

    public List<Question> seederQuestions() {
        List<Question> result = new ArrayList<>();
        result = testSeeder.seederQuestions();
        return result;
    }

    public List<QuestionDto> getListQuestionByIdTest(Integer idTest) {
        List<QuestionDto> result = new ArrayList<>();
        List<Question> listQuest = questionRepo.getQuestionByIdTest(idTest);
        if (!listQuest.isEmpty()) {
            result = listQuest.stream().map(q -> {
                QuestionDto dto = new QuestionDto();
                q.convertToDto(dto, Constants.LANG_VI);
                return dto;
            }).collect(Collectors.toList());
        }
        return result;
    }
}
