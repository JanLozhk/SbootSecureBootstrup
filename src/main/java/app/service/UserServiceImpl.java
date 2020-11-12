package app.service;

import app.dao.AuthorityDaoImpl;
import app.dao.UserDao;
import app.model.Authority;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service//не проксируются, объявление бинами @Bean
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthorityDaoImpl authorityDao;

    @Transactional
    @Override
    public void create(User user) {
        Authority authority =  authorityDao.findByAuthority("USER");
        user.setAuthorityList(Collections.singletonList(authority));
        userDao.create(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void update(User user) {
        User old = userDao.findUserById(user.getId());
        old.setLogin(user.getLogin());
        old.setFirstName(user.getFirstName());
        old.setLastName(user.getLastName());
        old.setEmail(user.getEmail());
        userDao.update(old);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional//transactional javax?
    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public User findByLogin(String login) {
        return userDao.findUserByLogin(login);
    }
}
