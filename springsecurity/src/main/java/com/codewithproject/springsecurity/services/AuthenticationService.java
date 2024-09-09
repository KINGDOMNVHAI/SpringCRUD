package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.request.SignInGoogleRequest;
import com.codewithproject.springsecurity.dto.response.JwtAuthenticationResponse;
import com.codewithproject.springsecurity.dto.request.RefreshTokenRequest;
import com.codewithproject.springsecurity.dto.request.SignInRequest;
import com.codewithproject.springsecurity.dto.request.SignUpRequest;
import com.codewithproject.springsecurity.entities.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signInRequest);

    JwtAuthenticationResponse signInWithGoogle(SignInGoogleRequest signInRequest) throws Exception;

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    JwtAuthenticationResponse getInfoLoginGoogle(OAuth2User principal);
}
