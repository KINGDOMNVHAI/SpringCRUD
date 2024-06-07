package com.poscdx.odc.excan013.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcanExam
{
    private Integer id;
    private int settingId;
    private int candidateId;
    private Date startTime;
    private Date submitTime;
    private int score;
    private String desc;
    private int status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
    private List<ExcanQuestion> questions;
    private int totalScore;
    private int duration;
    private String examTitle;
}
