package com.agutierrezl.user_service;

import com.agutierrezl.user_service.entity.UserEntity;
import com.agutierrezl.user_service.reposiroty.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UserServiceApplication implements CommandLineRunner {

	private final IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		userRepository.save(UserEntity.builder()
						.email("axelgutierrezlopez@agutierrezl.com")
						.name("Axel")
						.lastName("Gutierrez")
						.roles(new String[]{"USER", "SUPPORT"})
						.username("agutierrezl")
						.password("123")
				.build());

	}
}
