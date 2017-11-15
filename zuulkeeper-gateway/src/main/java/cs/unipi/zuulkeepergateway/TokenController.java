package cs.unipi.zuulkeepergateway;

import cs.unipi.zuulkeepergateway.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://10.132.0.2", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class TokenController {


    public User authenticateApi(User user) {

        String url = "10.132.0.2:9000";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", user.getEmail());
        User userRetrieved = restTemplate.getForObject(String.format("http://%s/secure/authentication/user/{email}", url), User.class, params);

        return userRetrieved;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = authenticateApi(login);

        if (user == null) {
            throw new ServletException("User email not found.");
        }

        String retrievedPassword = user.getPassword();

        if (!password.equals(retrievedPassword)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setId(Integer.toString(user.getUserId())).setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }
}
