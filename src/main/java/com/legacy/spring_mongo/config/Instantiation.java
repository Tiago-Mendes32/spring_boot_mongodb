package com.legacy.spring_mongo.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.spring_mongo.domain.Post;
import com.legacy.spring_mongo.domain.User;
import com.legacy.spring_mongo.dto.AuthorDTO;
import com.legacy.spring_mongo.dto.CommentDTO;
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
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userService.save(maria);
		userService.save(alex);
		userService.save(bob);
		
		Post post1 = new Post(null, LocalDate.parse("2024-03-02", fmt), "Partiu viagem!", "Vou viajar para São Pulo, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("2024-03-02", fmt), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem, mano!", LocalDate.parse("2024-03-02", fmt), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", LocalDate.parse("2024-03-02", fmt), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("2024-03-02", fmt), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));	
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
