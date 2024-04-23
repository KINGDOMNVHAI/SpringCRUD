package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.Answer;
import com.codewithproject.springsecurity.entities.Question;
import com.codewithproject.springsecurity.enums.TypeQuestion;
import com.codewithproject.springsecurity.repository.AnswerRepository;
import com.codewithproject.springsecurity.repository.ExamRepository;
import com.codewithproject.springsecurity.repository.QuestionRepository;
import com.codewithproject.springsecurity.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestQuestionAnswerSeeder {

    @Autowired
    public AnswerRepository answerRepo;

    @Autowired
    public QuestionRepository questionRepo;

    @Autowired
    public TestRepository testRepo;

    @Autowired
    public ExamRepository examRepo;

    public List<Question> seederQuestions() {
        List<Question> result = new ArrayList<>();
        try {
            int idQuestion1 = 1;
            Question question1 = new Question();
            question1.setContentQuestionVI("Sự khác nhau giữa @RestController và @Controller là gì?");
            question1.setContentQuestionEN("What is difference between @RestController and @Controller?");
            question1.setListIdAnswer("1,2,3,4");
            question1.setUrlTest("java-beginner-1");
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
            question2.setContentQuestionVI("Collections.shuffle() là gì?");
            question2.setContentQuestionEN("What is Collections.shuffle()?");
            question2.setListIdAnswer("5,6,7,8");
            question2.setUrlTest("java-beginner-1");
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

            int idQuestion3 = 3;
            Question question3 = new Question();
            question3.setContentQuestionVI("Regex: [^\\sa-zA-Z1-9]\n" +
                    "String: Kujira2024@\n" +
                    "Chọn đáp án đúng.");
            question3.setContentQuestionEN("Regex: [^\\sa-zA-Z1-9]\n" +
                    "String: Kujira2024@\n" +
                    "Choose correct answer.");
            question3.setExplainQuestionVI("Kết quả trùng khớp: 0 và @");
            question3.setExplainQuestionEN("Matcher: 0 and @");
            question3.setListIdAnswer("9,10");
            question3.setUrlTest("java-beginner-1");
            question3.setTypeQuestion(TypeQuestion.MULTI_CHOICE_RADIO.getValue());
            questionRepo.save(question3);
            result.add(question3);

            Answer answer9 = new Answer();
            answer9.setContentAnswerVI("1 kết quả trùng khớp");
            answer9.setContentAnswerEN("1 match");
            answer9.setResultQuestion(false);
            answer9.setIdQuestion((long) idQuestion3);
            answerRepo.save(answer9);

            Answer answer10 = new Answer();
            answer10.setContentAnswerVI("2 kết quả trùng khớp");
            answer10.setContentAnswerEN("2 matches");
            answer10.setResultQuestion(true);
            answer10.setIdQuestion((long) idQuestion3);
            answerRepo.save(answer10);

            int idQuestion4 = 4;
            Question question4 = new Question();
            question4.setContentQuestionVI("String a = \"\";\n" +
                    "System.out.println(a.length);\n" +
                    "Chọn đáp án đúng.");
            question4.setContentQuestionEN("String a = \"\";\n" +
                    "System.out.println(a.length);\n" +
                    "Choose correct answer.");
            question4.setExplainQuestionVI("a không phải chuỗi rỗng");
            question4.setExplainQuestionEN("a is not null");
            question4.setListIdAnswer("11,12");
            question4.setUrlTest("java-beginner-1");
            question4.setTypeQuestion(TypeQuestion.MULTI_CHOICE_RADIO.getValue());
            questionRepo.save(question4);
            result.add(question4);

            Answer answer11 = new Answer();
            answer11.setContentAnswerVI("null");
            answer11.setContentAnswerEN("null");
            answer11.setResultQuestion(false);
            answer11.setIdQuestion((long) idQuestion4);
            answerRepo.save(answer11);

            Answer answer12 = new Answer();
            answer12.setContentAnswerVI("0");
            answer12.setContentAnswerEN("0");
            answer12.setResultQuestion(true);
            answer12.setIdQuestion((long) idQuestion4);
            answerRepo.save(answer12);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
