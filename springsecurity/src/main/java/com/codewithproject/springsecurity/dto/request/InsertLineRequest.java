package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InsertLineRequest {

    // Insert Line
    private String id;

    private String bladeUnitID;

    private Integer periodCnt;

    private String period;

    private Integer initPrice;

    private Integer deposit;

    private Integer depreciation;

    private Integer fee;

    private Integer endPrice;

    private String lineReq;

    private String registType;

    // Register Line
    private String token; // check user login or not

    private String lineID;

    private Integer seq;

    private String email;

    private boolean depositStatus;

    private Date startDate;
    private String bladeCD;
}
