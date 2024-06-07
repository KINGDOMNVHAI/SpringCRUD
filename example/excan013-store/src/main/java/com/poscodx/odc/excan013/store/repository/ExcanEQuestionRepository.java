package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanEQuestionJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ExcanEQuestionRepository
    extends JpaRepository<ExcanEQuestionJpo, Integer>
{
    public List<ExcanEQuestionJpo> findByExamId(int examId);
    public List<ExcanEQuestionJpo> findByExamIdAndQuestionId(int examId, int questionId);

    @Query(
        value = "select eeq.questionId, ea.id as answerId, eq.score, eeq.answerOrder, eeq.chosenAnswer, eeq.status, ea.content, eq.type " +
                "from ExcanAnswer ea " +
                "join ExcanEQuestion eeq on ea.questionId = eeq.questionId " +
                "join ExcanQuestion eq on eq.id = ea.questionId " +
                "where ea.isCorrect = 1 and eeq.examId = :#{#examId}"
    )
    List<Object[]> getAnswerResult(@Param("examId") int examId);

    @Query(
            value = "select eeq.questionId, ea.id as answerId, eq.score, eeq.answerOrder, eeq.chosenAnswer, eeq.status, ea.content, eq.type " +
                    "from ExcanAnswer ea " +
                    "join ExcanEQuestion eeq on ea.questionId = eeq.questionId " +
                    "join ExcanQuestion eq on eq.id = ea.questionId " +
                    "where ea.isCorrect = 1 and ea.questionId = :questionId and eeq.examId = :examId"
    )
    List<Object[]> getAnswerResultQuestionIdAndExamId(@Param("questionId") int questionId, @Param("examId") int examId);

}
