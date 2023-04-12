package com.docker.compose;

import com.docker.compose.user.persistance.entity.User;
import com.docker.compose.user.persistance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class SpringbootMongodbDockerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			String username = "Yondaime";
			User user = new User(
					username,
					"Simon Baranec",
					true,
					"simonbaranec58@gmail.com",
					"Prirodna 37",
					"Nova Bana"
			);

			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(username));

			List<User> users = mongoTemplate.find(query, User.class);

			repository.insert(user);
		};
	}

}