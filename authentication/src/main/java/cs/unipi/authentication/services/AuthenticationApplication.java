package cs.unipi.authentication.services;

import cs.unipi.authentication.generic.GenericDAO;
import cs.unipi.authentication.generic.GenericDAOImpl;
import cs.unipi.authentication.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class AuthenticationApplication {
	public static final GenericDAO<User, Serializable> usersDao = new GenericDAOImpl<User, Serializable>(User.class) {};

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "server");
		SpringApplication.run(AuthenticationApplication.class, args);
	}
}
