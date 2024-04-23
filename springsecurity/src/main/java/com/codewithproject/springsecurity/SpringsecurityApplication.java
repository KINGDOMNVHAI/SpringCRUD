package com.codewithproject.springsecurity;

import com.codewithproject.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class SpringsecurityApplication implements CommandLineRunner {

//	Spring Boot 3.1 With JWT
//	https://www.youtube.com/playlist?list=PLgYFT7gUQL8HCIyTncupOEl8c6cgXAO4j

	@Autowired
	private UserRepository userRepository;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	public void run(String... args) {
//		User adminAccount = userRepository.findByRole(Role.ADMIN);
//		if (null == adminAccount) {
//			User user = new User();
//			user.setEmail("admin@gmail.com");
//			user.setFirstname("admin");
//			user.setLastname("admin");
//			user.setUsername("admin");
//			user.setRole(Role.ADMIN);
//			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//			userRepository.save(user);
//		}
	}

}
