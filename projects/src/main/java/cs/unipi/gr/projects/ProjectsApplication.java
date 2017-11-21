package cs.unipi.gr.projects;

import cs.unipi.gr.projects.generic.GenericDAO;
import cs.unipi.gr.projects.generic.GenericDAOImpl;
import cs.unipi.gr.projects.models.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ProjectsApplication {
	public static final GenericDAO<Project, Serializable> projectsDao = new GenericDAOImpl<Project, Serializable>(Project.class) {};

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "projects-config");
		SpringApplication.run(ProjectsApplication.class, args);
	}
}
