package cs.unipi.gr.projects;

import cs.unipi.gr.projects.exceptions.ProjectNotFoundException;
import cs.unipi.gr.projects.models.Project;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/secure/api/v1_0/projects/{id}",method = RequestMethod.GET)
    public Project getProject(@PathVariable("id") int id)  {
        Project project = ProjectsApplication.projectsDao.getByID(id);
        if (null == project) {
            throw new ProjectNotFoundException();
        }
        return project;
    }

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/projects/{param}",method = RequestMethod.GET)
    public List<Project> getProject(@PathVariable("param") String param)  {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name",param);
        params.put("description",param);
        params.put("Type",param);

        List<Project> projects = ProjectsApplication.projectsDao.search(params);
        if (null == projects && projects.size() <= 0) {
            throw new ProjectNotFoundException();
        }
        return projects;
    }

    @LoadBalanced
    @RequestMapping(value = "/secure/api/v1_0/projects/create",method = RequestMethod.POST)
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
