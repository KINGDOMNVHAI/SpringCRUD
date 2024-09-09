package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.MessageConstants;
import com.codewithproject.springsecurity.dto.request.RefreshTokenRequest;
import com.codewithproject.springsecurity.dto.request.SignInGoogleRequest;
import com.codewithproject.springsecurity.dto.request.SignInRequest;
import com.codewithproject.springsecurity.dto.request.SignUpRequest;
import com.codewithproject.springsecurity.dto.response.JwtAuthenticationResponse;
import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.enums.Role;
import com.codewithproject.springsecurity.repository.UserRepository;
import com.codewithproject.springsecurity.services.AuthenticationService;
import com.codewithproject.springsecurity.services.JWTService;
import com.codewithproject.springsecurity.util.PassUtil;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String CLIENT_ID;

    public User signup(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getSecondname());
        user.setUsername(signUpRequest.getSecondname());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest) {
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        String email = "";
        String username = "";
        String firstname = "";
        String lastname = "";
        String pass = signInRequest.getPassword();
        String passMD5 = PassUtil.encryptMD5(pass);
        String jwt = null;
        String refreshToken = null;
        String message = MessageConstants.MESS_INVALID_EMAIL_PASSWORD;

        Optional<User> user = userRepository.getUserByEmailOrUsername(signInRequest.getEmailOrUsername());
        if (user.isPresent() && !pass.isEmpty()) {
            User dto = user.get();
            if (dto.getPassword().equals(passMD5)) {
                jwt = jwtService.generateToken(dto);
                refreshToken = jwtService.generateRefreshToken(new HashMap<>(), dto);
                message = MessageConstants.MESS_LOGIN_SUCCESS;
                email = dto.getEmail();
                username = dto.getUsername();
                firstname = dto.getFirstname();
                lastname = dto.getLastname();
            } else {
                message = MessageConstants.MESS_INVALID_WRONG_PASSWORD;
                jwtAuthenticationResponse.setMessage(message);
                return jwtAuthenticationResponse;
            }
        }

        jwtAuthenticationResponse.setEmail(email);
        jwtAuthenticationResponse.setUsername(username);
        jwtAuthenticationResponse.setFirstname(firstname);
        jwtAuthenticationResponse.setLastname(lastname);
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        jwtAuthenticationResponse.setMessage(message);

//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    signInRequest.getEmailOrUsername(), passMD5));
//        } catch (Exception ex) {
//            System.out.println("Error");
//            System.out.println(ex);
//        }
        return jwtAuthenticationResponse;
    }
    private String getUsernameFromEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        // Split the email at the "@" symbol and return the first part
        return email.split("@")[0];
    }
    public JwtAuthenticationResponse signInWithGoogle(SignInGoogleRequest signInRequest) throws Exception {
        NetHttpTransport transport = new NetHttpTransport();
            JsonFactory jsonFactory = new GsonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(CLIENT_ID)).build();

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(signInRequest.getCredential());
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (idToken == null) {
            throw new Exception("INVALID TOKEN");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        // Print user identifier
        String userId = payload.getSubject();
        System.out.println("User ID: " + userId);

        // Get profile information from payload
        String email = payload.getEmail();
        boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
        String name = (String) payload.get("name");
        String pictureUrl = (String) payload.get("picture");
        String locale = (String) payload.get("locale");
        String familyName = (String) payload.get("family_name");
        String givenName = (String) payload.get("given_name");
        String sub = (String) payload.get("sub");
        String username = getUsernameFromEmail(email);
        String jwt = null;
        String refreshToken = null;
        String message = MessageConstants.MESS_INVALID_EMAIL_PASSWORD;

        Optional<User> user = userRepository.getUserByEmailOrUsername(email);
        User userNew;
        if (user.isPresent()) {
            userNew = user.get();

        } else {

            userNew = new User();
            userNew.setEmail(email);
            userNew.setFirstname(familyName);
            userNew.setLastname(givenName);
            userNew.setUsername(sub);
            userNew.setRole(Role.USER);
            //TODO: FIX PASSWORD
            userNew.setPassword("GOOGLE_LOGIN");
            try{
                userRepository.save(userNew);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        jwt = jwtService.generateToken(userNew);
        refreshToken = jwtService.generateRefreshToken(new HashMap<>(), userNew);
        message = MessageConstants.MESS_LOGIN_SUCCESS;
        email = userNew.getEmail();

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setEmail(email);
        jwtAuthenticationResponse.setUsername(sub);
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        jwtAuthenticationResponse.setMessage(message);


        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            var jwt = jwtService.generateToken(user);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

    public JwtAuthenticationResponse loginGoogle() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User auth2User = (OAuth2User) authentication.getPrincipal();
        return getInfoLoginGoogle(auth2User);
    }

    public JwtAuthenticationResponse getInfoLoginGoogle(OAuth2User principal) {
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        if (principal != null) {
            String picture = principal.getAttribute("picture");
            response.setEmail(principal.getAttribute("email"));
            response.setFirstname(principal.getAttribute("given_name"));
            response.setLastname(principal.getAttribute("family_name"));
            response.setLocale(principal.getAttribute("locale"));
        }
        return response;
    }

    private void insertLoginGoogleToDB() {
        System.out.println("insertLoginGoogleToDB");
    }
}
