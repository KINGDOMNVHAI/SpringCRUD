package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String firstname;

    private String secondname;

    private String email;

    private String password;
}
