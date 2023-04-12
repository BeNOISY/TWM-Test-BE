package com.docker.compose.user.service;

import com.docker.compose.user.persistance.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    List < User > getAllUser();

    User getUserById(String userId);

    void deleteUser(String id);

    void deleteCollection();
}
