package app.service;

import app.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

/*
    @Override
    public List<User> readAllUsers() {
    }
*/

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void update(User user, long id) {
        entityManager.merge(user);
    }


    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(findUserById(id));
    }

/*    @Override
    public User findUser(String name) {
        return null;
    }*/

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    /*@Override
    public List<User> userListByModelAndSeries(String model, int series) {
        return null;
    }*/
}
