package com.poscdx.odc.excan013.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExcanSetting
{
    private int id;
    private String name;
    private String description;
    private int duration;
    private int numberOfQuestion;
    private int status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
}
