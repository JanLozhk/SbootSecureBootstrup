package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
//    List<User> readAllUsers();
    List<User> getAllUsers();
    //void
    //void update(long id, User user);
    void update(User user);
//    void delete(User user);
    void delete(long id);

//    User findUser(String name);
    User findUserById(long id); //User user
    User findUserByLogin(String login); //User user
//    List<User> userListByModelAndSeries(String model, int series);

}
