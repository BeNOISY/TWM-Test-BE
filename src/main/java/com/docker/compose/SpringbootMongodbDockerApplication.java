package com.docker.compose;

import com.docker.compose.user.persistance.entity.User;
import com.docker.compose.user.persistance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootMongodbDockerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository){
		return args -> {
			User user = new User(
					"Yondaime",
					"Simon baranec",
					true,
					"simonbaranec58@gmail.com",
					"prirodna 37",
					"Nova Bana"
			);
			repository.insert(user);
		};
	}

}