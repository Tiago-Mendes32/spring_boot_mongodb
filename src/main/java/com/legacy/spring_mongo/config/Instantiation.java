package com.legacy.spring_mongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.legacy.spring_mongo.domain.User;
import com.legacy.spring_mongo.repositories.UserRepository;
import com.legacy.spring_mongo.services.UserService;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userService.save(maria);
		userService.save(alex);
		userService.save(bob);
	}

}
