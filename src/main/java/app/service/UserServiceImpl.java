package app.service;

import app.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    User userNew = new User("Lokal", "Moka", "Toka");

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public void update(User toSave) {
//        User user = findUserById(toSave.getId());
//        BeanUtils.copyProperties(toSave, user);
        entityManager.merge(toSave);
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
        System.out.println(entityManager.find(User.class, id));
        return entityManager.find(User.class, id);
    }

    /*@Override
    public List<User> userListByModelAndSeries(String model, int series) {
        return null;
    }*/
}
