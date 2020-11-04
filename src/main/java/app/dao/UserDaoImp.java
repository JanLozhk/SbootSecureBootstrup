package app.dao;

import app.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

//@Repository
//@Transactonal
public class UserDaoImp {//implements UserDao {
}
   //@Autowired
//   private SessionFactory sessionFactory;
  /* @Autowired
   EntityManager entityManager;
  *//* @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }*//*

    @Autowired
    public UserDaoImpl() {
    }

     @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        List<User> users = (List<User>) entityManager.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        int id = user.getId();
        User delUser = entityManager.find(User.class, id);
        entityManager.remove(delUser);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

  *//* @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }*//*

   @Override
//   @PostMapping
   public void create(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> readAllUsers() {

      TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
      return typedQuery.getResultList();
   }

   @Override
   public void update(User user) {
      entityManager.createQuery("update User u set u.name = :name, u.lastName= :lastName, u.email= :email where u.id = :id")//TypedQuery typedQuery =
              .setParameter("name", user.getFirstName())
              .setParameter("lastName", user.getLastName())
              .setParameter("email", user.getEmail())
              .setParameter("id", user.getId())
              .executeUpdate();
   }

   @Override
   public void delete(User user) {
      entityManager.createQuery("delete from User u where u.id = :id and u.name = :name and u.lastName = :lastName and u.email = :email")
              .setParameter("id", user.getId())
              .setParameter("name", user.getFirstName())
              .setParameter("lastName", user.getLastName())
              .setParameter("email", user.getEmail())
              .executeUpdate();
   }

   @Override
   public List<User> findUser(User user) {
      return null;
   }

   @Override
   public List<User> userListByModelAndSeries(String model, int series) {
      Query query = entityManager.createQuery("FROM User u WHERE u.car.model = :model AND u.car.series = :series", User.class)
              .setParameter("model", model)
              .setParameter("series", series);
      return query.getResultList();
   }
*/
 /*  @Override
   public void dropTable() {
      sessionFactory.getCurrentSession().createQuery("Drop Table User");
   }

   @Override
   public void deleteUsers() {
     //sessionFactory.getCurrentSession().delete(user);//
      sessionFactory.getCurrentSession().createQuery("DELETE User").executeUpdate();
     // TypedQuery<User> query =  query.getResultList();*/

//}