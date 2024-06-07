package com.poscodx.odc.excan013.store.jpo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poscdx.odc.excan013.domain.entity.ExcanAnswer;
import com.poscdx.odc.excan013.domain.utils.Constants;
import com.poscodx.odc.excan013.store.converter.image.StringCryptoConverter;
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
@Entity(name = "ExcanAnswer")
@Table(name = "TB_EXCAN_ANSWER", schema = "EXCAN013")
public class ExcanAnswerJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "QUESTION_ID")
    private int questionId;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private ExcanQuestionJpo question;


    @Column(name = "CONTENT")
    private String content;
    @Convert(converter = StringCryptoConverter.class)
    @Column(name = "IMAGE")
    private String image;
    @Column(name = "IS_CORRECT")
    private int isCorrect;
    @Column(name = "SCORE")
    private int score;
    @Column(name = "ANSWER_ORDER")
    private String answerOrder;
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

    public ExcanAnswerJpo() {
    }

    public ExcanAnswerJpo(ExcanAnswer entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanAnswer toDomain() {
        ExcanAnswer retVal = new ExcanAnswer();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanAnswer> toDomains(Iterable<ExcanAnswerJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanAnswerJpo::toDomain)).collect(Collectors.toList());
    }
//    @PostLoad
//    public void setFilePath() {
//        if (image != null  && !image.isEmpty()) {
//            image = Constants.applyEmployeeAvatarPath((String) image, "Answer");
//        }
//    }
}
