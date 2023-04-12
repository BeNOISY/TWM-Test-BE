package com.docker.compose.user.persistance.repository;


import com.docker.compose.user.persistance.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String > {}
