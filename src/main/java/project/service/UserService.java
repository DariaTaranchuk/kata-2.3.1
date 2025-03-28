package project.service;

import project.model.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();

    User getUser(long id);

    void createUser(User user);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);
}
