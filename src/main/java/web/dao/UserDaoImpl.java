package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(Long id, User updatedUser) {
        User userToBeUpdate = getById(id);
        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setSurname(updatedUser.getSurname());
        userToBeUpdate.setEmail(updatedUser.getEmail());
        entityManager.merge(userToBeUpdate);
    }
}
