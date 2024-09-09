package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String email;

    private String username;

    private String firstname;

    private String lastname;

    private String locale;

    private String token;

    private String refreshToken;

    private String message;
}
