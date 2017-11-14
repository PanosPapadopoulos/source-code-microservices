package cs.unipi.gr.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ProjectsApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "projects-config");
		SpringApplication.run(ProjectsApplication.class, args);
	}
}
