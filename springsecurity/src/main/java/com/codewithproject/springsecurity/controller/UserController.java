package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.dto.SignInDto;
import com.codewithproject.springsecurity.repository.UserRepository;
import com.codewithproject.springsecurity.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hi User");
    }

    @GetMapping("/truncate")
    public ResponseEntity<String> truncateTable() {
        userService.truncateUser();
        userService.seederUser();
        return ResponseEntity.ok("Success");
    }
}
