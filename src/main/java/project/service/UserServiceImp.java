package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.model.User;

import javax.transaction.Transactional;
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

    @Transactional
    public User getUserById(long id){
        return userDao.getUserById(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
}
