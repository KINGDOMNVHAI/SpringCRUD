package com.codewithproject.springsecurity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThirdPartyAuthResponse {

    private String token;

    // Momo
    private String username;

    // PayOS
    private String refreshToken;
    private String id;
    private String first_name;
    private String last_name;
    private String avatar_url;
    private String email;
}
