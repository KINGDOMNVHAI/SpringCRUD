package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseDto {
    private Map<String, Object> data;
    // Momo
    private Integer status;
    private String message;
    // PayOS
    private String code;
    private String desc;
    private String signature;
}
