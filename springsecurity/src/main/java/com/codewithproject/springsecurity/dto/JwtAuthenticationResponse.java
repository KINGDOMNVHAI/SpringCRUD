package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    private String message;
}
