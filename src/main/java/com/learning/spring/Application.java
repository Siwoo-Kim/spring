package com.learning.spring;

import com.learning.spring.domain.Address;
import com.learning.spring.domain.User;
import com.learning.spring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner addUser(UserRepository userRepository){
		return args -> {
			userRepository.saveAll(
					Arrays.asList(
							User.builder().email("user1@email.com").age(20).telephone("648-423-1234").point(100).name("Song Hyun")
							.address(new Address("Toronto","Altamontd","MS1-311")).build(),
							User.builder().email("user2@email.com").age(26).telephone("648-523-1234").point(200).name("James")
									.address(new Address("York","Altamontd","MS1-211")).build(),
							User.builder().email("user3@email.com").age(32).telephone("648-223-1234").point(160).name("Kim")
									.address(new Address("New York","Altamontd","MS1-541")).build(),
							User.builder().email("user4@email.com").age(23).telephone("648-123-1234").point(250).name("Lee")
									.address(new Address("Seoul","Altamontd","MTD-653")).build(),
							User.builder().email("user5@email.com").age(43).telephone("648-823-1234").point(300).name("Alex Messi")
									.address(new Address("Busan","Altamontd","MS2-777")).build()
							)
			);
		};
	}
}
