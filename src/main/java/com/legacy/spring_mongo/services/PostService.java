package com.legacy.spring_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.spring_mongo.domain.Post;
import com.legacy.spring_mongo.repositories.PostRepository;
import com.legacy.spring_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id));
	}

	public Post save(Post obj) {
		return repository.save(obj);
	}

	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
