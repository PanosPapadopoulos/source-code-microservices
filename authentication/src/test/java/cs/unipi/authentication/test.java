package cs.unipi.authentication;
import cs.unipi.authentication.models.User;
import cs.unipi.authentication.services.AuthenticationApplication;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */

public class test {

    private final Logger logger = LoggerFactory.getLogger(test.class);

    private String url = "35.205.124.218:9000";

    @Test
    public void register()  {

        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setFirstName("Panagiotis");
        user.setSurName("Papadopoulos");
        user.setEmail("pa@gmail.com");
        user.setPassword("1234");
        user.setRole("Test");
        user.setActive(true);

        String message = restTemplate.postForObject(String.format("http://%s/secure/authentication/register", url), user, String.class);

        logger.info("Return Message:" +message.toString());
    }

    @Test
    public void registerPr()  {

        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setFirstName("Panagiotis");
        user.setSurName("Papadopoulos");
        user.setEmail("pa@gmail.com");
        user.setPassword("1234");
        user.setRole("Test");
        user.setActive(true);

        String message = restTemplate.postForObject(String.format("http://%s/secure/authentication/register", url), user, String.class);

        logger.info("Return Message:" +message.toString());
    }

//    @Test
//    public void authenticate() {
//
//        RestTemplate restTemplate = new AuthRestTemplate("admin","adminxx");
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("email", "m.bokas@protera.com");
//        params.put("password", "cyod8p");
//
//        Users user = restTemplate.getForObject(String.format("http://%s/flexbridge/v1_0_release/apis/1.0/authentication/users/{email}/{password}", url), Users.class, params);
//
//        if (null == user) {
//            logger.info("User Does Not Exist");
//        } else {
//            logger.info("Authenticated User:" +user.toString());
//        }
//
//
//    }
//
//    @Test
//    public void update() {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        Users[] users = restTemplate.getForObject(String.format("http://%s/flexbridge/v1_0_release/apis/1.0/authentication/users", url), Users[].class);
//
//        if (null != users && users.length > 0) {
//
//            Users user = users[0];
//
//            user.setPassword("gamietaiomaven");
//
//            logger.info("Updating User: " + user.toString());
//
//            restTemplate.put(String.format("http://%s/flexbridge/v1_0_release/apis/1.0/controllers/users", url), user, Users.class);
//
//            logger.info("Update User Complete");
//        }
//    }
//
//    @Test
//    public void getUsers() {
//
////        RestTemplate restTemplate = new AuthRestTemplate("admin","adminxx");
//        RestTemplate restTemplate = new RestTemplate();
//
//        Users[] users = restTemplate.getForObject(String.format("http://%s/flexbridge/v1_0_release/apis/1.0/controllers/users", url), Users[].class);
//
//        logger.info("Operation done");
//    }
//
//
//
//    public Users createUser() {
//        Users user = new Users();
//
//        user.setFirstName("Nicholas");
//        user.setSurName("Tousis");
//        user.setPassword("1");
//        user.setEmail("n.tousis@protera.biz");
//        user.setActive(true);
//
//        Customer customer = new Customer();
//        customer.setName("Protera");
//        customer.setAddress("Oakbrook 1");
//        customer.setCoid("PROT");
//        customer.setCreateDate(new Date());
//
//        Roles role = new Roles();
//        role.setName("Administrator");
//
//        Set<Roles> rolesSet = new HashSet<Roles>();
//        rolesSet.add(role);
//
//        user.setCustomer(customer);
//        user.setRoles(rolesSet);
//
//        return user;
//    }
}
