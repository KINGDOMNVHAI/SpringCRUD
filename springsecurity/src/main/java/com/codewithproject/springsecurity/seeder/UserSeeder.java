package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.enums.Role;
import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder {

    @Autowired
    private UserRepository userRepo;

    public List<User> seederUser() {
        List<User> result = new ArrayList<>();
        try {
            User user1 = new User();
            user1.setFirstname("Hai");
            user1.setLastname("Nguyen Viet");
            user1.setEmail("nvhai061993@gmail.com");
            user1.setUsername("NVHAI");
            user1.setPassword(new BCryptPasswordEncoder().encode("Aa@123"));
            user1.setRole(Role.ADMIN);
            userRepo.save(user1);
            result.add(user1);

            User user2 = new User();
            user2.setFirstname("Mai Anh");
            user2.setLastname("Le");
            user2.setEmail("nvhai2306@gmail.com");
            user2.setUsername("maianh");
            user2.setPassword(new BCryptPasswordEncoder().encode("Aa@123"));
            user2.setRole(Role.USER);
            userRepo.save(user2);
            result.add(user2);
        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
