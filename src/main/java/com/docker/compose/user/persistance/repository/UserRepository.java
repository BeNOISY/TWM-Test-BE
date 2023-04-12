package com.docker.compose.user.persistance.repository;


import com.docker.compose.user.persistance.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <User, String > {
    Optional<User> getUserByUsername(String username);
}
