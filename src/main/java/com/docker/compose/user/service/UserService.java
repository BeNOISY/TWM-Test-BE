package com.docker.compose.user.service;

import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.user.persistance.entity.User;
import com.docker.compose.user.persistance.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);

    }

    public User updateUser(User user) {
        Optional< User > userDb = this.userRepository.findById((user.getId()));

        if (userDb.isPresent()) {
            User userUpdate = userDb.get();
            userUpdate.setId(user.getId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setNumber(user.getNumber());

            userUpdate.setAdmin(user.isAdmin());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setAddress(user.getAddress());
            userUpdate.setCity(user.getCity());
            userRepository.save(userUpdate);
            return userUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + user.getId());
        }
    }


    public List < User > getAllUser() {
        return this.userRepository.findAll();
    }


    public User findUserByEmail(String email){
        if(this.userRepository.getUserByEmail(email) == null){
            throw new ResourceNotFoundException("User with email " + email + " not found!");
        }
        else {
            return this.userRepository.getUserByEmail(email);
        }
    }


    public boolean loginUser(String email, String password) {

        User user = userRepository.getUserByEmail(email);
        System.out.println("\nNajden user podla zadanej emailovej adresy:" + user + "\n");
        System.out.println("Jeho heslo je: " + user.getPassword() + "\n");
        return Objects.equals(user.getPassword(), password);
    }


    public User getUserById(String userId) {

        Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }



    public void deleteUser(String userId) {
        Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            this.userRepository.delete(userDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }

    }


    public void deleteCollection() {
        this.userRepository.deleteAll();
    }
}
