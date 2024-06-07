package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanExam")
@Table(name = "TB_EXCAN_EXAM", schema = "EXCAN013")
public class ExcanExamJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "SETTING_ID")
    private int settingId;
    @Column(name = "CANDIDATE_ID")
    private int candidateId;
    @Column(name = "START_TIME")
    private Date startTime;
    @Column(name = "SUBMIT_TIME")
    private Date submitTime;
    @Column(name = "SCORE", columnDefinition = "int default 0")
    private Integer score;
    @Column(name = "DESCRIPTION")
    private String desc;
    @Column(name = "STATUS", columnDefinition = "int default 0")
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
    @Column(name = "TOTAL_SCORE", columnDefinition = "int default 0")
    private Integer totalScore;

    @PrePersist
    public void beforeCreate() {
        createAt = new Date();
    }

    @PreUpdate
    public void beforeUpdate() {
        updateAt = new Date();
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "TB_EXCAN_EXAM_QUESTION",
            joinColumns = @JoinColumn(name = "EXAM_ID",insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false))
    private Set<ExcanQuestionJpo> questions;

    public ExcanExamJpo() {
    }

    public ExcanExamJpo(ExcanExam entity) {

        BeanUtils.copyProperties(entity, this);
        if(entity.getQuestions() != null){
            this.questions = entity.getQuestions().stream().map(ExcanQuestionJpo::new).collect(Collectors.toSet());
        }
    }

    public ExcanExam toDomain() {
        ExcanExam retVal = new ExcanExam();
        BeanUtils.copyProperties(this, retVal);
        if (this.getQuestions() != null) {
            retVal.setQuestions(this.getQuestions().stream().map(ExcanQuestionJpo::toDomain).collect(Collectors.toList()));
        }
        return retVal;
    }

    public static List<ExcanExam> toDomains(Iterable<ExcanExamJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanExamJpo::toDomain)).collect(Collectors.toList());
    }

    @PostLoad
    private void formatInt() {
        if(score == null) score = 0;
        if(status == null) status = 0;
    }
//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
