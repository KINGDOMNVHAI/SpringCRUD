package com.codewithproject.springsecurity.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "platform")
    private String platform; // code nền tảng thanh toán

    @Column(name = "id_payment_platform")
    private String idPayment; // id của nền tảng thanh toán

    @Column(name = "account_number")
    private String accountNumber; // id của nền tảng thanh toán

    @Column(name = "account_name")
    private String accountName; // id của nền tảng thanh toán

    @Column(name = "description")
    private String description; // Mô tả thanh toán

    @Column(name = "orderCode")
    private String orderCode; // Mô tả thanh toán

    @Column(name = "paymentLinkId")
    private String paymentLinkId;

    @Column(name = "status")
    private Integer status; // Trạng thái link thanh toán

    @Column(name = "amount")
    private Double amount; // Số tiền thanh toán

    @Column(name = "currency")
    private String currency;

    @Column(name = "checkout_url")
    private String checkoutUrl;

    @Column(name = "qrcode")
    private String qrCode;

    @Column(name = "signature")
    private String signature;

//    @Column(name = "amount_paid")
//    private Integer amountPaid; // Số tiền thanh toán
//
//    @Column(name = "amount_remaining")
//    private Integer amountRemaining; // Số tiền thanh toán

    @Column(name = "created_at")
    private Date createdAt;
}
