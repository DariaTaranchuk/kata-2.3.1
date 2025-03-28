package project.dao;

import org.springframework.stereotype.Repository;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public List<User> showAllUsers() {
        List<User> users = em.createNativeQuery("SELECT * FROM users", User.class).getResultList();
        return users;
    }

    public User getUserById(long id){
        User userById = em.find(User.class, id);
        return userById;
    }

    public void save(User user) {
        em.persist(user);
    }

    public void update(long id, User updateUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());
        em.merge(userToBeUpdated);
    }

    public void delete(long id) {
        User user = getUserById(id);
        em.remove(user);
    }
}
