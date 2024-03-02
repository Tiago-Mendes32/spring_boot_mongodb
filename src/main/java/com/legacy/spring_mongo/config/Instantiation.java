package com.legacy.spring_mongo.config;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.spring_mongo.domain.Post;
import com.legacy.spring_mongo.domain.User;
import com.legacy.spring_mongo.dto.AuthorDTO;
import com.legacy.spring_mongo.repositories.PostRepository;
import com.legacy.spring_mongo.repositories.UserRepository;
import com.legacy.spring_mongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userService.save(maria);
		userService.save(alex);
		userService.save(bob);
		
		Post post1 = new Post(null, Instant.now(), "Partiu viagem!", "Vou viajar para São Pulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.now(), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));	
	}

}
