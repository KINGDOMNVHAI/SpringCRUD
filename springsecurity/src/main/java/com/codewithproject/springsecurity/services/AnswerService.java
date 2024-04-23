package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.entities.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getListAnswerByListId(List<Integer> listId);
}
