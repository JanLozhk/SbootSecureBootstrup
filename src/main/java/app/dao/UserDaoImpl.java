package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
//@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

//    @Transactional
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

//    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

//    @Transactional
    @Override
    public void update(User user) {
//        User user = findUserById(toSave.getId());
//        BeanUtils.copyProperties(toSave, user);
        entityManager.merge(user);
    }

//    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(findUserById(id));
    }

//    @Transactional(readOnly = true)
    @Override
    public User findUserById(long id) {
        System.out.println(entityManager.find(User.class, id));
        return entityManager.find(User.class, id);
    }
}