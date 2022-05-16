package com.ludis.users;

import com.ludis.users.model.User;
import com.ludis.users.repository.UserRepository;
import com.ludis.users.config.RibbonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableMongoRepositories
@SpringBootApplication
@RibbonClient(
		name = "users-server",
		configuration = RibbonConfig.class)
public class UsersApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	UserRepository userRepository;

	private final static String QUEUE_NAME = "users";

	static Logger logger
			= LoggerFactory.getLogger(UsersApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
