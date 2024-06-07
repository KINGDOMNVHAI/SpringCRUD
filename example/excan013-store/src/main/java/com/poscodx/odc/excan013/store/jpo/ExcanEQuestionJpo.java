package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanEQuestion")
@Table(name = "TB_EXCAN_EXAM_QUESTION", schema = "EXCAN013")
public class ExcanEQuestionJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "QUESTION_ID")
    private int questionId;

    @Column(name = "EXAM_ID")
    private int examId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "EXAM_ID", insertable = false, updatable = false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private ExcanExamJpo exam;

    @Column(name = "ANSWER_ORDER")
    private String answerOrder;
    @Column(name = "CHOSEN_ANSWER")
    private String chosenAnswer;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "CREATE_AT")
    private Date createAt;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "UPDATE_AT")
    private Date updateAt;
    @Column(name = "UPDATE_BY")
    private String updateBy;
    @Column(name = "DELETE_AT")
    private Date deleteAt;

    public ExcanEQuestionJpo() {
    }

    public ExcanEQuestionJpo(ExcanEQuestion entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanEQuestion toDomain() {
        ExcanEQuestion retVal = new ExcanEQuestion();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanEQuestion> toDomains(Iterable<ExcanEQuestionJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanEQuestionJpo::toDomain)).collect(Collectors.toList());
    }

//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
