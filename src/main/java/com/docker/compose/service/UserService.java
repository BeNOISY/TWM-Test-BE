package com.docker.compose.service;
import com.docker.compose.model.User;

import java.util.List;


public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    List < User > getAllUser();

    User getUserById(long userId);

    List < User > getUserByCategory(String category);

    void deleteUser(long id);

    void deleteCollection(long userId);
}
