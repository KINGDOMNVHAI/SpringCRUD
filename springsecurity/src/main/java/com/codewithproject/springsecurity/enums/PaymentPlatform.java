package com.codewithproject.springsecurity.enums;

public enum PaymentPlatform {

    MOMO("MOMO"),
    PAYOS("PAYOS");

    private final String plf;

    private PaymentPlatform(String plf){
        this.plf = plf;
    }

    public String getPlf() {
        return plf;
    }
}
