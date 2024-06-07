package com.poscdx.odc.excan013.domain.entity;

import com.poscdx.odc.excan013.domain.utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Tuple;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExcanCandidate {
    private Integer id;
    private String name;
    private Date birthday;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String desc;
    private String linkRefer;
    private Date interviewDate;
    private Integer status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
    private Integer score;
    private String updateUserName;
    private String updateUserAvatar;

    private Integer position;
    private String positionName;

    private Integer department;
    private String departmentName;

    private Integer university;
    private String universityName;

    private String skill;

    private Integer yearOfExperience;
    private String yearOfExperienceName;

    private String expectSalary;
    private Date expectStartDate;

    private Integer interviewer;
    private String interviewerName;

    private Integer interviewResult;
    private String interviewResultName;

    private String linkCV;
    private Integer examId;
    private Integer examStatus;

    private Integer totalScore;

    public ExcanCandidate(Tuple objects) {
        this.id = objects.get("ID", Integer.class);
        this.name = objects.get("NAME", String.class);
        this.birthday = objects.get("BIRTHDAY", Date.class);
        this.email = objects.get("EMAIL", String.class);
        this.phone = objects.get("PHONE", String.class);
        this.address = objects.get("ADDRESS", String.class);
        this.avatar = Constants.formatUrl(objects.get("AVATAR", String.class));
        this.desc = objects.get("DESCRIPTION", String.class);
        this.createAt = objects.get("CREATE_AT", Date.class);
        this.createBy = objects.get("CREATE_BY", String.class);
        this.updateAt = objects.get("UPDATE_AT", Date.class);
        this.updateBy = objects.get("UPDATE_BY", String.class);
        this.deleteAt = objects.get("DELETE_AT", Date.class);
        this.linkRefer = objects.get("LINK_REFER", String.class);
        this.status = objects.get("STATUS", Integer.class);
        this.interviewDate = objects.get("INTERVIEW_DATE", Date.class);
        this.score = objects.get("SCORE", Integer.class);
        this.updateUserName = objects.get("UPDATE_USER_NAME", String.class);
        this.updateUserAvatar = Constants.formatUrl(objects.get("UPDATE_USER_AVATAR", String.class));
        this.position = objects.get("POSITION", Integer.class);
        this.department = objects.get("DEPARTMENT", Integer.class);
        this.university = objects.get("UNIVERSITY", Integer.class);
        this.skill = objects.get("EXPERIENCE", String.class);
        this.yearOfExperience = objects.get("YEAR_OF_EXPERIENCE", Integer.class);
        this.expectSalary = objects.get("EXPECT_SALARY", String.class);
        this.expectStartDate = objects.get("EXPECT_START_DATE", Date.class);
        this.interviewer = objects.get("INTERVIEWER", Integer.class);
        this.interviewResult = objects.get("INTERVIEW_RESULT", Integer.class);
        this.linkCV = Constants.formatUrl(objects.get("LINK_CV", String.class));
        this.examId = objects.get("EXAM_ID", Integer.class);
        this.examStatus = objects.get("EXAM_STATUS", Integer.class);
        this.totalScore = objects.get("TOTAL_SCORE", Integer.class);
    }
}
