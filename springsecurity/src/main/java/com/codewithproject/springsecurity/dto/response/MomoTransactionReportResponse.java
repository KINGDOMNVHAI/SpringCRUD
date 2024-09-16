package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MomoTransactionReportResponse {

    private String id;
    private Date createdDate; // 2024-05-15T08:19:09.067
    private String billId;
    private String sourceBillId;
    private Long coreTranId;
    private String status;
    private String statusDescription;
    private String customerName;
    private String customerPhoneNumber;
    private String type;
    private String typeDescription;
    private Integer totalAmount;
    private Integer voucherAmount;
    private Integer cashbackAmount;
    private Integer prepaidAmount;
    private String paymentChannel;
    private String paymentChannelDescription;
    private String paymentMethod;
    private String paymentMethodDescription;
    private String description;
    private String storeCode;
    private String storeName;
    private String contractCode;
    private String classify;
    private String companyName;
    private String product;
    private String userName;
    private String address;
    private String contractId;
    private String platform;
    private String information1;
    private String information2;
    private String information3;
    private String information4;
    private String information5;
    private String moneySource;
    private String merchantCode;
    private String team;
    private Boolean enabledConfirm;
    private Object[] subTrans;
}
