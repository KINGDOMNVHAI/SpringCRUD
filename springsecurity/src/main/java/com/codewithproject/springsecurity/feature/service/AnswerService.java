package com.codewithproject.springsecurity.feature.service;

import com.codewithproject.springsecurity.entities.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getListAnswerByListId(List<Integer> listId);
}
