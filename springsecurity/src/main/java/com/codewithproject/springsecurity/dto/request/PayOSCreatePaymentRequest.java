package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayOSCreatePaymentRequest {

    private int amount; // Số tiền thanh toán
    private String description; // Mô tả thanh toán
    private int orderCode; // Mã đơn hàng thanh toán (id của Payment)
    private String cancelUrl; // Đơn vị tiền tệ
    private String returnUrl; // Mã link thanh toán

    // User Info
    private String buyerName;
    private String buyerEmail;
    private String buyerPhone;
    private String buyerAddress;
}
