package ro.info.iasi.fiipractic.util;

import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Component;
import ro.info.iasi.fiipractic.model.User;

import java.util.Map;

@Component
public class UserUtil {

    public void patchUser(User user, Map<String, String> partialUser) {
        String firstName = partialUser.get("firstName");
        String lastName = partialUser.get("lastName");
        String email = partialUser.get("email");
        String password = partialUser.get("password");
        if (!StringUtils.isNullOrEmpty(firstName)) {
            user.setFirstName(firstName);
        }
        if (!StringUtils.isNullOrEmpty(lastName)) {
            user.setLastName(lastName);
        }
        if (!StringUtils.isNullOrEmpty(email)) {
            user.setEmail(email);
        }
        if (!StringUtils.isNullOrEmpty(password)) {
            user.setPassword(password);
        }
    }

}
