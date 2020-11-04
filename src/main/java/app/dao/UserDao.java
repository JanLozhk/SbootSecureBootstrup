package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
   void create(User user);
   List<User> readAllUsers();
   void update(User user);
   void delete(User user);

   List<User> findUser(User user);
   List<User> userListByModelAndSeries(String model, int series);

}
