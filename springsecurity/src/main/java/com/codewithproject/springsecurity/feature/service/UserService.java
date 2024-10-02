package com.codewithproject.springsecurity.feature.service;

import com.codewithproject.springsecurity.dto.request.SearchUserRequest;
import com.codewithproject.springsecurity.dto.response.UserDetailResponse;
import com.codewithproject.springsecurity.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDetailsService userDetailService();

    List<User> seederUser();

    UserDetailResponse getUserProfile(SearchUserRequest req);

    Optional<User> getUserDetail(String email);

    String getUserFullname(String email);
}
