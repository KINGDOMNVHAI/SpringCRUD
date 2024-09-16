package com.codewithproject.springsecurity.dto.response;

import com.codewithproject.springsecurity.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailResponse {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String password;

    private Role role;

    private String phone;

    private String addressShip;

    private String token; // check user login or not
}
