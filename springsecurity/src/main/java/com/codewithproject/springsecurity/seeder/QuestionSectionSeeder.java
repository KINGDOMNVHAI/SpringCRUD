package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.QuestionSection;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.TestQuestionSection;
import com.codewithproject.springsecurity.repository.QuestionSectionRepository;
import com.codewithproject.springsecurity.repository.TestQuestionSectionRepository;
import com.codewithproject.springsecurity.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionSectionSeeder {

    @Autowired
    public QuestionSectionRepository qsRepo;

    @Autowired
    public TestRepository testRepo;

    @Autowired
    public TestQuestionSectionRepository testQSRepo;

    public List<QuestionSection> seederQuestionSection() {
        List<QuestionSection> result = new ArrayList<>();
        try {
            QuestionSection qs1 = new QuestionSection();
            qs1.setTitleQS("no section");
            qsRepo.save(qs1);
            result.add(qs1);

            QuestionSection qs2 = new QuestionSection();
            qs2.setTitleQS("vocabulary");
            qsRepo.save(qs2);
            result.add(qs2);

            QuestionSection qs3 = new QuestionSection();
            qs3.setTitleQS("grammar");
            qsRepo.save(qs3);
            result.add(qs3);

            QuestionSection qs4 = new QuestionSection();
            qs4.setTitleQS("listening");
            qsRepo.save(qs4);
            result.add(qs4);

            QuestionSection qs5 = new QuestionSection();
            qs5.setTitleQS("speaking");
            qsRepo.save(qs5);
            result.add(qs5);

            QuestionSection qs6 = new QuestionSection();
            qs6.setTitleQS("reading");
            qsRepo.save(qs6);
            result.add(qs6);

            QuestionSection qs7 = new QuestionSection();
            qs7.setTitleQS("writing");
            qsRepo.save(qs7);
            result.add(qs7);

            QuestionSection qs8 = new QuestionSection();
            qs8.setTitleQS("語彙");
            qsRepo.save(qs8);
            result.add(qs8);

            QuestionSection qs9 = new QuestionSection();
            qs9.setTitleQS("文法 - 読解");
            qsRepo.save(qs9);
            result.add(qs9);

            QuestionSection qs10 = new QuestionSection();
            qs10.setTitleQS("聴解");
            qsRepo.save(qs10);
            result.add(qs10);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    public List<TestQuestionSection> seederTestQuestionSection() {
        List<TestQuestionSection> result = new ArrayList<>();
        try {
            Optional<Test> testN41 = testRepo.getTestByURL("n4-test-1");
            if (testN41.isPresent())
            {
                TestQuestionSection testQS1 = new TestQuestionSection();
                testQS1.setIdTest(testN41.get().getIdTest());
                testQS1.setIdQuestionSection(8);
                testQS1.setSeqQS(1);
                testQSRepo.save(testQS1);
                result.add(testQS1);

                TestQuestionSection testQS2 = new TestQuestionSection();
                testQS2.setIdTest(testN41.get().getIdTest());
                testQS2.setIdQuestionSection(9);
                testQS2.setSeqQS(2);
                testQSRepo.save(testQS2);
                result.add(testQS2);

                TestQuestionSection testQS3 = new TestQuestionSection();
                testQS3.setIdTest(testN41.get().getIdTest());
                testQS3.setIdQuestionSection(10);
                testQS3.setSeqQS(3);
                testQSRepo.save(testQS3);
                result.add(testQS3);
            }

            Optional<Test> testN51 = testRepo.getTestByURL("n5-test-1");
            if (testN51.isPresent())
            {
                TestQuestionSection testQS1 = new TestQuestionSection();
                testQS1.setIdTest(testN51.get().getIdTest());
                testQS1.setIdQuestionSection(8);
                testQS1.setSeqQS(1);
                testQSRepo.save(testQS1);
                result.add(testQS1);

                TestQuestionSection testQS2 = new TestQuestionSection();
                testQS2.setIdTest(testN51.get().getIdTest());
                testQS2.setIdQuestionSection(9);
                testQS2.setSeqQS(2);
                testQSRepo.save(testQS2);
                result.add(testQS2);

                TestQuestionSection testQS3 = new TestQuestionSection();
                testQS3.setIdTest(testN51.get().getIdTest());
                testQS3.setIdQuestionSection(10);
                testQS3.setSeqQS(3);
                testQSRepo.save(testQS3);
                result.add(testQS3);
            }

            Optional<Test> testJava1 = testRepo.getTestByURL("java-beginner-1");
            if (testJava1.isPresent())
            {
                TestQuestionSection testQS1 = new TestQuestionSection();
                testQS1.setIdTest(testJava1.get().getIdTest());
                testQS1.setIdQuestionSection(1);
                testQS1.setSeqQS(1);
                testQSRepo.save(testQS1);
                result.add(testQS1);
            }

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
