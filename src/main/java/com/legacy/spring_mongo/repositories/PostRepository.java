package com.legacy.spring_mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.legacy.spring_mongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
