package com.docker.compose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringbootMongodbDockerApplication {
	public static void main(String[] args) {
		SpringApplication.run
				(SpringbootMongodbDockerApplication.class, args);
	}
}
