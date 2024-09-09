package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PayOSTransactionResponse {

    private String reference;

    private int orderCode; // Mã đơn hàng thanh toán (id của Payment)

    private int amount; // Số tiền thanh toán

    private int accountNumber;

    private String description;

    private Date transactionDateTime;

    private String virtualAccountName;

    private Integer virtualAccountNumber;

    private Integer counterAccountBankId;

    private String counterAccountBankName;

    private String counterAccountName;

    private Integer counterAccountNumber;
}
