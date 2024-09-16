package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserRequest {

    private String token; // check user login or not

    private String email;
}
