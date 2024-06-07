package com.poscdx.odc.excan013.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExcanAnswer
{
    private int id;
    private int questionId;
    private String content;
    private String image;
    private int isCorrect;
    private int score;
    private String answerOrder;
    private int status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
}
