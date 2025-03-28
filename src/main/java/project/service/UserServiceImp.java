package project.service;

import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.model.User;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Transactional(readOnly = true)
    public User getUser(long id){
        return userDao.getUserById(id);
    }

    @Transactional
    public void createUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public void updateUser(long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
