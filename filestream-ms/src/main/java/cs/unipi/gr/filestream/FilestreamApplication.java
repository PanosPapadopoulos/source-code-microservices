package cs.unipi.gr.filestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
@EnableEurekaServer
@SpringBootApplication
@EnableAutoConfiguration
public class FilestreamApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "filestream-config");
		SpringApplication.run(FilestreamApplication.class, args);
	}

}