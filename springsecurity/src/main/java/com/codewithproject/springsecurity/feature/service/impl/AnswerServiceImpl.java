package com.codewithproject.springsecurity.feature.service.impl;

import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.repository.AnswerRepository;
import com.codewithproject.springsecurity.feature.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepo;

    public List<Answer> getListAnswerByListId(List<Integer> listId) {
        return answerRepo.getListAnswerByListId(listId);
    }
}
