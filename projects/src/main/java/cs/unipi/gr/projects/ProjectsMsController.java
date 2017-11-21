package cs.unipi.gr.projects;

import cs.unipi.gr.projects.exceptions.ProjectNotFoundException;
import cs.unipi.gr.projects.models.Project;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */
@RestController
public class ProjectsMsController {

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/projects",method = RequestMethod.GET)
    public List<Project> getProjects()  {
        List<Project> projects = ProjectsApplication.projectsDao.getList();
        if (null == projects && projects.size() <= 0) {
            throw new ProjectNotFoundException();
        }
        return projects;
    }

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/projects/create",method = RequestMethod.GET)
    public String createProject(@RequestBody() Project project )  {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", project.getName());

        List<Project> projects = ProjectsApplication.projectsDao.search(params);

        if (null != projects && projects.size() > 0) {
            //   logger.info("User already exists");
            return "Project already exists";
        } else {
            // logger.info("No matching user was found...");
            ProjectsApplication.projectsDao.insert(project);
            return "OK";
        }
    }

    @RequestMapping(value = "/secure/api/v1_0/projects/update",method = RequestMethod.PUT)
    public void update(@RequestBody() Project project )  {
        //  logger.info("Updating User",user.toString());
        ProjectsApplication.projectsDao.update(project);
    }
}
