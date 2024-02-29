package com.legacy.spring_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.spring_mongo.domain.User;
import com.legacy.spring_mongo.repositories.UserRepository;
import com.legacy.spring_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
	    Optional<User> obj = repository.findById(id);
	    return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id));
	}

	public User save(User obj) {
		return repository.save(obj);
		
	}
	
}
