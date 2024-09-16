package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterBladeRequest {

    private String emailOrUsername;

    private String token;
}
