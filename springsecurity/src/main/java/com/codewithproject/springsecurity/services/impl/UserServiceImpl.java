package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.repository.UserRepository;
import com.codewithproject.springsecurity.seeder.UserSeeder;
import com.codewithproject.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
