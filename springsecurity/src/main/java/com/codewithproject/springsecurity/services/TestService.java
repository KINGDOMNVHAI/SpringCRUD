package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.entities.Test;

import java.util.List;

public interface TestService {

    List<Test> seederTests();

    TestQuestionDto getTestQuestion(String urlTest, String lang);

}
