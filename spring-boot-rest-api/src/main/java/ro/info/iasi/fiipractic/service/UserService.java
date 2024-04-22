package ro.info.iasi.fiipractic.service;

import ro.info.iasi.fiipractic.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUsers();

    void registerUser(User user);

    void updateUser(Integer id, User user);

    void patchUser(Integer id, Map<String, String> user);

    void deleteUser(Integer id);

    User getUserById(Integer id);
}
