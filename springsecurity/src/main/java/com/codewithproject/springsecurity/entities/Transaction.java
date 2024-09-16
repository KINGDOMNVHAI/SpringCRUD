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
@Table(name = "tb_bb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trans", nullable = false)
    private int idTrans;

    @Column(name = "order_code")
    private int orderCode; // Mã đơn hàng thanh toán (id của Payment)

//    @Column(name = "reference")
//    private String reference;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "description")
    private String description; // Mô tả thanh toán

    @Column(name = "amount")
    private Integer amount; // Số tiền thanh toán

    @Column(name = "status")
    private String status;

    @Column(name = "transaction_datetime")
    private Date transactionDateTime;
}
