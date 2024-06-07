package com.poscodx.odc.excan013.store.jpo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscodx.odc.excan013.store.converter.image.StringCryptoConverter;
import lombok.EqualsAndHashCode;
import com.poscdx.odc.excan013.domain.utils.Constants;
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
@Entity(name = "ExcanQuestion")
@Table(name = "TB_EXCAN_QUESTION", schema = "EXCAN013")
public class ExcanQuestionJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "CONTENT")
    private String content;
    @Convert(converter = StringCryptoConverter.class)
    @Column(name = "IMAGE")
    private String image;
    @Column(name = "LEVEL")
    private int level;
    @Column(name = "SCORE")
    private int score;
    @Column(name = "QUESTION_TYPE")
    private int type;
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

    @OneToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "QUESTION_ID", updatable = false, insertable = false)
    private List<ExcanAnswerJpo> answers;

    public ExcanQuestionJpo() {
    }

    public ExcanQuestionJpo(ExcanQuestion entity) {

        BeanUtils.copyProperties(entity, this);
    }

    public ExcanQuestion toDomain() {
        ExcanQuestion retVal = new ExcanQuestion();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanQuestion> toDomains(Iterable<ExcanQuestionJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanQuestionJpo::toDomain)).collect(Collectors.toList());
    }
//
//    @PostLoad
//    public void setFilePath() {
//        if (image != null  && !image.isEmpty()) {
//            image = Constants.applyEmployeeAvatarPath((String) image, "Question");
//        }
//    }

//    @PostLoad
//    private void formatImage() {
//        if (image != null && !"".equals(image)) {
//            image = Constants.getUploadPath("Question") + image;
//        }
//    }
//    @PostLoad
//    private void formatImage() {
//        if (image != null && !"".equals(image) && !image.contains(Constants.getUploadPath("Question"))) {
//            image = Constants.getUploadPath("Question") + image;
//            System.out.println(image);
//            System.out.println("");
//
//        }
//    }
//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
