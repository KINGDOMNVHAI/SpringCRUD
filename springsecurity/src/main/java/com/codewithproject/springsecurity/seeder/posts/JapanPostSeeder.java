package com.codewithproject.springsecurity.seeder.posts;

import com.codewithproject.springsecurity.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JapanPostSeeder {

    @Autowired
    private PostRepository postRepo;

}
