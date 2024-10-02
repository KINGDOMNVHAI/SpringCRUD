package com.codewithproject.springsecurity.feature.service.impl;

import com.codewithproject.springsecurity.dto.request.SearchUserRequest;
import com.codewithproject.springsecurity.dto.response.UserDetailResponse;
import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.repository.UserRepository;
import com.codewithproject.springsecurity.seeder.UserSeeder;
import com.codewithproject.springsecurity.feature.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserSeeder userSeeder;

    public void truncateUser() {
        userRepo.truncateTable();
    }

    public List<User> seederUser() {
        List<User> result = new ArrayList<>();
        result = userSeeder.seederUser();
        return result;
    }

    @Override
    public UserDetailsService userDetailService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public UserDetailResponse getUserProfile(SearchUserRequest req) {
        UserDetailResponse result = new UserDetailResponse();
        if (!req.getEmail().isEmpty()) {
            Optional<User> op = getUserDetail(req.getEmail());
            if (op.isPresent()) {
                User u = op.get();
                result.setFirstname(u.getFirstname());
                result.setLastname(u.getLastname());
                result.setUsername(u.getUsername());
                result.setEmail(u.getEmail());
                result.setPhone(u.getPhone());
                result.setAddressShip(u.getAddressShip());
                result.setRole(u.getRole());
            }
        }
        return result;
    }

    @Override
    public Optional<User> getUserDetail(String emailOrUsername) {
        return userRepo.getUserByEmailOrUsername(emailOrUsername);
    }

    @Override
    public String getUserFullname(String email) {
        String name = "";
        Optional<User> user = userRepo.getUserByEmailOrUsername(email);
        if (user.isPresent()) {
            name = user.get().getLastname() + " " + user.get().getFirstname();
        }
        return name;
    }
}
