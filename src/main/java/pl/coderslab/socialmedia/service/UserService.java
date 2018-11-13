package pl.coderslab.socialmedia.service;

import org.springframework.security.core.Authentication;
import pl.coderslab.socialmedia.model.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    User findByMail(String email);

    void saveUser(User user);

    List<User> findAll();

    User findById(long id);

    boolean checkIfValidOldPassword(User user, String oldPassword);

    void changeUserPassword(User user, String password);

    User save(User user);

    User getCurrentUser(Authentication authentication);
}
