package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<User> showAllUsers() {
        List<User> users = em.createNativeQuery("SELECT * FROM users", User.class).getResultList();
        return users;
    }

    @Transactional
    public User getUserById(long id){
        User userById = em.find(User.class, id);
        return userById;
    }

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    @Transactional
    public void update(long id, User updateUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());
        em.merge(userToBeUpdated);
    }

    @Transactional
    public void delete(long id) {
        User user = getUserById(id);
        em.remove(user);
    }
}
