package com.docker.compose.dao;

import com.docker.compose.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Integer> {
}
