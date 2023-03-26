package com.docker.compose.service;

import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.model.User;
import com.docker.compose.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional < User > userDb = this.userRepository.findById(user.getId());

        if (userDb.isPresent()) {
            User userUpdate = userDb.get();
            userUpdate.setId(user.getId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setRealname(user.getRealname());
            userUpdate.setAdmin(user.getAdmin());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setAdress(user.getAdress());
            userUpdate.setCity(user.getCity());
            userRepository.save(userUpdate);
            return userUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + user.getId());
        }
    }


    @Override
    public List < User > getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {

        Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }

    @Override
    public List<User> getUserByCategory(String category) {
        return this.userRepository.findAll();
    }


    @Override
    public void deleteUser(long userId) {
        Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            this.userRepository.delete(userDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }

    }

    @Override
    public void deleteCollection() {
        this.userRepository.deleteAll();
    }
}
