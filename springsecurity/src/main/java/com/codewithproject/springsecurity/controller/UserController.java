package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.dto.SignInDto;
import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.model.ResponseModel;
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

import java.util.List;
import java.util.Map;

import static com.codewithproject.springsecurity.config.MessageConstants.MESS_NOT_FOUND;
import static com.codewithproject.springsecurity.config.MessageConstants.MESS_SUCCESS;

@RestController
@RequestMapping("/api/v1/public/user")
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

    @GetMapping("/user")
    public ResponseModel<List<User>> migrateUser() {
        List<User> result = userService.seederUser();
        if (result.isEmpty()) {
            return ResponseModel.error(MESS_NOT_FOUND);
        }
        return ResponseModel.ok(result, MESS_SUCCESS);
    }
}
