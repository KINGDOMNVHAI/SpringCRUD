package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {

    private String username;

    private String token;

    private String refreshToken;
}
