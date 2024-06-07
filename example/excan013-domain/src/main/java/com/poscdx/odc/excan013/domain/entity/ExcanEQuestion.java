package com.poscdx.odc.excan013.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExcanEQuestion
{
    private int id;
    private int questionId;
    private int examId;
    private String answerOrder;
    private String chosenAnswer;
    private Integer status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
}
