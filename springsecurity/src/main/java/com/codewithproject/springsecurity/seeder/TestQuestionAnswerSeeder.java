package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.entities.Question;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.TestQuestion;
import com.codewithproject.springsecurity.enums.TypeQuestion;
import com.codewithproject.springsecurity.repository.AnswerRepository;
import com.codewithproject.springsecurity.repository.QuestionRepository;
import com.codewithproject.springsecurity.repository.TestQuestionRepository;
import com.codewithproject.springsecurity.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            answer1.setContentAnswerVI("@RestController bao gồm @Controller và @ResponseBody");
            answer1.setContentAnswerEN("@RestController includes the @Controller and @ResponseBody");
            answer1.setResultQuestion(true);
            answer1.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer1);

            Answer answer2 = new Answer();
            answer2.setContentAnswerVI("@RestController bao gồm @Controller và @RequestBody");
            answer2.setContentAnswerEN("@RestController includes the @Controller and @RequestBody");
            answer2.setResultQuestion(false);
            answer2.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer2);

            Answer answer3 = new Answer();
            answer3.setContentAnswerVI("@RestController bao gồm @Controller và @RequestParam");
            answer3.setContentAnswerEN("@RestController includes the @Controller and @RequestParam");
            answer3.setResultQuestion(false);
            answer3.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer3);

            Answer answer4 = new Answer();
            answer4.setContentAnswerVI("@RestController bao gồm @Controller và @PathVariable");
            answer4.setContentAnswerEN("@RestController includes the @Controller and @PathVariable");
            answer4.setResultQuestion(false);
            answer4.setIdQuestion((long) idQuestion1);
            answerRepo.save(answer4);

            int idQuestion2 = 2;
            Question question2 = new Question();
            question2.setTitleQuestionVI("Collections.shuffle() là gì?");
            question2.setTitleQuestionEN("What is Collections.shuffle()?");
            question2.setListAnswer("5,6,7,8");
            question2.setTypeQuestion(TypeQuestion.MULTI_CHOICE_RADIO.getValue());
            questionRepo.save(question2);
            result.add(question2);

            Answer answer5 = new Answer();
            answer5.setContentAnswerVI("Một phương thức trong lớp Java Collections hoạt động bằng cách sắp xếp các phần tử trong danh sách.");
            answer5.setContentAnswerEN("Java Collections class method which works by sort the specified list elements.");
            answer5.setResultQuestion(false);
            answer5.setIdQuestion((long) idQuestion2);
            answerRepo.save(answer5);

            Answer answer6 = new Answer();
            answer6.setContentAnswerVI("Một phương thức trong lớp Java Collections hoạt động bằng cách xáo trộn ngẫu nhiên các phần tử trong danh sách.");
            answer6.setContentAnswerEN("Java Collections class method which works by randomly permuting the specified list elements.");
            answer6.setResultQuestion(true);
            answer6.setIdQuestion((long) idQuestion2);
            answerRepo.save(answer6);

            Answer answer7 = new Answer();
            answer7.setContentAnswerVI("Một phương thức trong lớp Java Collections hoạt động bằng cách hoán đổi các phần tử tại các vị trí được chỉ định trong danh sách.");
            answer7.setContentAnswerEN("Java Collections class method which works by swaps elements at specified positions in a selected list.");
            answer7.setResultQuestion(false);
            answer7.setIdQuestion((long) idQuestion2);
            answerRepo.save(answer7);

            Answer answer8 = new Answer();
            answer8.setContentAnswerVI("Tất cả đều sai");
            answer8.setContentAnswerEN("All is incorrect");
            answer8.setResultQuestion(false);
            answer8.setIdQuestion((long) idQuestion2);
            answerRepo.save(answer8);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    public List<TestQuestion> seederTestQuestion() {
        List<TestQuestion> result = new ArrayList<>();
        try {
            int idTest1 = 1;
            TestQuestion testQuestion1 = new TestQuestion();
            testQuestion1.setIdTest((long) idTest1);
            testQuestion1.setIdQuestion((long) 1);
            testQuestionRepo.save(testQuestion1);
            result.add(testQuestion1);

            TestQuestion testQuestion2 = new TestQuestion();
            testQuestion2.setIdTest((long) idTest1);
            testQuestion2.setIdQuestion((long) 2);
            testQuestionRepo.save(testQuestion2);
            result.add(testQuestion2);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
