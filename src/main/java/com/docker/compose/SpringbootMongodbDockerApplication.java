package com.docker.compose;

import com.docker.compose.dao.UserRepository;
import com.docker.compose.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/user")
public class SpringbootMongodbDockerApplication {

	@Autowired
	private UserRepository repository;

	@PostMapping
	public User saveUser(@RequestBody User user){
		return repository.save(user);
	}

	@GetMapping
	public List<User> getUsers(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerApplication.class, args);
	}

}
