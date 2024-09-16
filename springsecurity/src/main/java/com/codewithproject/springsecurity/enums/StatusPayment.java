package com.codewithproject.springsecurity.enums;

import lombok.Getter;

@Getter
public enum StatusPayment {

    NEW(1),
    PENDING(2),
    CANCELLED(3),
    SUCCESS(4);

    private final Integer status;

    private StatusPayment(Integer status){
        this.status = status;
    }
}
