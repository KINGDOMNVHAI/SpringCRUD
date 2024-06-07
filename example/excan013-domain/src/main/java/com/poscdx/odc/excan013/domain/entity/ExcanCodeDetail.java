package com.poscdx.odc.excan013.domain.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExcanCodeDetail {
    private int id;
    private String codeMaster;
    private String name;
    private String description;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
}
