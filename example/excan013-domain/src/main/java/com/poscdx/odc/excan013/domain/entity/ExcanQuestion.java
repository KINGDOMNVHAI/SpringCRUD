package com.poscdx.odc.excan013.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcanQuestion {
    private Integer id;
    private int categoryId;
    private String content;
    private String image;
    //    private String imageURL;
    private int level;
    private int score;
    private int type;
    private int status;
    private Date createAt;
    private String createBy;
    private String createByName;
    private String createByAvatar;
    private Date updateAt;
    private String updateBy;
    private String updateByName;
    private String updateByAvatar;
    private Date deleteAt;
    private String questionTypeName;
    private String questionLevelName;
    private boolean deleteFlag;
}