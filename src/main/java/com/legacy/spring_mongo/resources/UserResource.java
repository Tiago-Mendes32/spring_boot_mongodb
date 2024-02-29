package com.legacy.spring_mongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.spring_mongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "Maria Silva Email");
		User pedro = new User("2", "Pedro", "Pedro Silva Email");
		List<User> list = new ArrayList<>();

		list.addAll(Arrays.asList(pedro, maria));

		return ResponseEntity.ok().body(list);
	}
}
