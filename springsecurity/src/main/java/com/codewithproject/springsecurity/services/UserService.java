package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    UserDetailsService userDetailService();

    List<User> seederUser();
}
