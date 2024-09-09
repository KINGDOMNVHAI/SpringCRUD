package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PayOSPaymentResponse {

    private Integer id;

//    private String idPayment; // id của nền tảng thanh toán
//
//    private Integer amountPaid; // Số tiền thanh toán
//
//    private Integer amountRemaining; // Số tiền thanh toán
//
//    private Date createdAt;
//
//    private PayOSTransactionResponse transactions;
//
//    private String cancellationReason; // Mã định danh ngân hàng (thường gọi là BIN)
//
//    private Date canceledAt;

    private String bin;

    private String platform; // code nền tảng thanh toán

    private String accountNumber; // Số tài khoản ngân hàng thụ hưởng, là số tài khoản ảo nếu Cổng thanh toán liên kết với VietQR PRO

    private String accountName; // Tên tài khoản ngân hàng

    private Double amount; // Số tiền thanh toán

    private String description; // Mô tả thanh toán

    private String orderCode; // Mã đơn hàng thanh toán (id của Payment)

    private String currency; // Đơn vị tiền tệ

    private String paymentLinkId; // Mã link thanh toán

    private String status; // Trạng thái link thanh toán

    private String checkoutUrl; // Link thanh toán

    private String qrCode; // Mã VietQR dạng text

    private String signature;
}
