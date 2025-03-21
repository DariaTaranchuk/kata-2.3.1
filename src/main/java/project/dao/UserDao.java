package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {

    List<User> showAllUsers();

    User getUserById(long id);

    void save(User user);

    void update(long id, User updateUser);

    void delete(long id);

}
