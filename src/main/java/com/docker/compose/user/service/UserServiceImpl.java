package com.docker.compose.user.service;

import com.docker.compose.exception.ResourceNotFoundException;
import com.docker.compose.user.persistance.entity.User;
import com.docker.compose.user.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
            return this.userRepository.save(user);

    }

    @Override
    public User updateUser(User user) {
        Optional < User > userDb = this.userRepository.findById((user.getId()));

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

    @Override
    public List < User > getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email){
        if(this.userRepository.getUserByEmail(email) == null){
            throw new ResourceNotFoundException("User with email " + email + " not found!");
        }
        else {
            return this.userRepository.getUserByEmail(email);
        }
    }

    @Override
    public boolean loginUser(String email, String password) {

//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
//        SecretKeyFactory f = null;
//        try {
//            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        byte[] hash = new byte[0];
//        try {
//            hash = f.generateSecret(spec).getEncoded();
//        } catch (InvalidKeySpecException e) {
//            throw new RuntimeException(e);
//        }
//        Base64.Encoder enc = Base64.getEncoder();
//        System.out.printf("salt: %s%n", enc.encodeToString(salt));
//        System.out.printf("hash: %s%n", enc.encodeToString(hash));

        User user = userRepository.getUserByEmail(email);
        System.out.println("\nNajden user podla zadanej emailovej adresy:" + user + "\n");
        System.out.println("Jeho heslo je: " + user.getPassword() + "\n");
        return Objects.equals(user.getPassword(), password);
    }

    @Override
    public User getUserById(String userId) {

        Optional < User > userDb = this.userRepository.findById(userId);

        if (userDb.isPresent()) {
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + userId);
        }
    }


    @Override
    public void deleteUser(String userId) {
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
