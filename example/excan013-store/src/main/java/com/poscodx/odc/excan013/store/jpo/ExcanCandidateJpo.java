package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscodx.odc.excan013.store.converter.image.StringCryptoConverter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanCandidate")
@Table(name = "TB_EXCAN_CANDIDATE", schema = "EXCAN013")
public class ExcanCandidateJpo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS")
    private String address;
    @Convert(converter = StringCryptoConverter.class)
    @Column(name = "AVATAR")
    private String avatar;
    @Column(name = "STATUS")
    private Integer status;
    @Column(name = "INTERVIEW_DATE")
    private Date interviewDate;
    @Column(name = "DESCRIPTION")
    private String desc;
    @Column(name = "LINK_REFER")
    private String linkRefer;
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
    @Column(name = "POSITION")
    private Integer position;
    @Column(name = "DEPARTMENT")
    private Integer department;
    @Column(name = "UNIVERSITY")
    private Integer university;
    @Column(name = "EXPERIENCE")
    private String skill;
    @Column(name = "YEAR_OF_EXPERIENCE")
    private Integer yearOfExperience;
    @Column(name = "EXPECT_SALARY")
    private String expectSalary;
    @Column(name = "EXPECT_START_DATE")
    private Date expectStartDate;
    @Column(name = "INTERVIEWER")
    private Integer interviewer;
    @Column(name = "INTERVIEW_RESULT")
    private Integer interviewResult;
    @Convert(converter = StringCryptoConverter.class)
    @Column(name = "LINK_CV")
    private String linkCV;

    public ExcanCandidateJpo() {
    }

    public ExcanCandidateJpo(ExcanCandidate entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanCandidate toDomain() {
        ExcanCandidate retVal = new ExcanCandidate();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanCandidate> toDomains(Iterable<ExcanCandidateJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanCandidateJpo::toDomain)).collect(Collectors.toList());
    }

//    @PostLoad
//    public void setFilePath() {
//        if (avatar != null  && !avatar.isEmpty()) {
//            avatar = Constants.applyEmployeeAvatarPath((String) avatar, "Candidate");
//        }
//    }
}
