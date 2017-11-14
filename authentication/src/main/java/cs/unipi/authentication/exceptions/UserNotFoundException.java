package cs.unipi.authentication.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Panagiotis Papadopoulos P10095
 * @University University of Pireus Cs Department
 */

/**
 * Allow the controller to return a 404 if an account is not found by simply
 * throwing this exceptions. The @ResponseStatus causes Spring MVC to return a
 * 404 instead of the usual 500.
 *
 * @author Paul Chapman
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String email) {
        super("No such user found: " + email);
    }
}
