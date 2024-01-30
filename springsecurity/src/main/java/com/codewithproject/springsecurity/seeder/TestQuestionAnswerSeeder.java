package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.config.ChannelContants;
import com.codewithproject.springsecurity.dto.TestDto;
import com.codewithproject.springsecurity.dto.TestQuestionDto;
import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.entities.Question;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.TestQuestion;
import com.codewithproject.springsecurity.enums.TypeQuestion;
import com.codewithproject.springsecurity.repository.AnswerRepository;
import com.codewithproject.springsecurity.repository.QuestionRepository;
import com.codewithproject.springsecurity.repository.TestQuestionRepository;
import com.codewithproject.springsecurity.repository.TestRepository;
import com.codewithproject.springsecurity.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TestQuestionAnswerSeeder {

    @Autowired
    public AnswerRepository answerRepo;

    @Autowired
    public QuestionRepository questionRepo;

    @Autowired
    public TestRepository testRepo;

    @Autowired
    public TestQuestionRepository testQuestionRepo;

    public List<Test> seederTests() {
        Random r = new Random();
        List<Test> result = new ArrayList<>();
        try {
            Test test1 = new Test();
            test1.setTitleTest("Java Test: Beginner 1");
            testRepo.save(test1);
            result.add(test1);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    public List<Question> seederQuestions() {
        Random r = new Random();
        List<Question> result = new ArrayList<>();
        try {
            int idQuestion1 = 1;
            Question question1 = new Question();
            question1.setTitleQuestionVI("Sự khác nhau giữa @RestController và @Controller là gì?");
            question1.setTitleQuestionEN("What is difference between @RestController and @Controller?");
            question1.setListAnswer("1,2,3,4");
            question1.setTypeQuestion(TypeQuestion.MULTI_CHOICE_RADIO.getValue());
            questionRepo.save(question1);
            result.add(question1);

            Answer answer1 = new Answer();
            answer1.setContentAnswer("@RestController includes the @Controller and @ResponseBody");
            answer1.setResultQuestion(true);
            answer1.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer1);

            Answer answer2 = new Answer();
            answer2.setContentAnswer("@RestController includes the @Controller and @RequestBody");
            answer2.setResultQuestion(false);
            answer2.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer2);

            Answer answer3 = new Answer();
            answer3.setContentAnswer("@RestController includes the @Controller and @RequestParam");
            answer3.setResultQuestion(false);
            answer3.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer3);

            Answer answer4 = new Answer();
            answer4.setContentAnswer("@RestController includes the @Controller and @PathVariable");
            answer4.setResultQuestion(false);
            answer4.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer4);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    public List<TestQuestion> seederTestQuestion() {
        Random r = new Random();
        List<TestQuestion> result = new ArrayList<>();
        try {
            int idTest1 = 1;
            TestQuestion TestQuestion1 = new TestQuestion();
            TestQuestion1.setIdTest((long) idTest1);
            TestQuestion1.setIdQuestion((long) 1);
            testQuestionRepo.save(TestQuestion1);
            result.add(TestQuestion1);



        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
