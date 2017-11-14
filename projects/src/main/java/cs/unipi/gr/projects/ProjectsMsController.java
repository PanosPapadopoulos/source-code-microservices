package cs.unipi.gr.projects;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
@RestController
public class ProjectsMsController {

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/projects",method = RequestMethod.GET)
    public List<String> getUsers()  {

        List<String> projects= new ArrayList<>();
        projects.add("Android");
        projects.add("Java");
        projects.add("Uni Project");

        return projects;
    }
}
