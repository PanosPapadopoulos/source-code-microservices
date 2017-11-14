package cs.unipi.authentication.services;

import cs.unipi.authentication.exceptions.UserNotFoundException;
import cs.unipi.authentication.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */

@RestController
public class UsersController {
    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @RequestMapping(value = "/secure/authentication/register",method = RequestMethod.POST)
    public String register(@RequestBody() User user )  {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", user.getEmail());

        // logger.info("Search users with Email: " + user.getEmail());

        List<User> users = AuthenticationApplication.usersDao.search(params);

        if (null != users && users.size() > 0) {
            //   logger.info("User already exists");
            return "User already exists";
        } else {
            // logger.info("No matching user was found...");
            AuthenticationApplication.usersDao.insert(user);
            return "OK";
        }
    }


    @RequestMapping(value = "/secure/authentication/user/{email}")
    public User authenticate(@PathVariable("email") String email) {
        User user = new User();
        user.setEmail(email);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", user.getEmail());

        //   logger.info("Search users with Email: " + email + ", Password: " + password);

        List<User> users = AuthenticationApplication.usersDao.search(params);

        if (null != users && users.size() > 0) {
            // logger.info("Found matching user...logging into system");
            return users.get(0);
        } else {
            //   logger.info("No matching user was found...");
            throw new UserNotFoundException(email);
        }
    }

    @RequestMapping(value = "/secure/authentication/update",method = RequestMethod.PUT)
    public void update(@RequestBody() User user )  {
        //  logger.info("Updating User",user.toString());
        AuthenticationApplication.usersDao.update(user);
    }
}
