package app.service;


import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")//не проксируются, объявление бинами @Bean
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userDao.findUserByLogin(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(String.format("User %1$s not found", username));
        }

        List<GrantedAuthority> authorities =
                userEntity.getAuthorityList()
                        .stream()
                        .map(e -> new SimpleGrantedAuthority(e.getAuthority()))
                        .collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(userEntity.getLogin())
                .password(userEntity.getPassword())
                .authorities(authorities)
                .build();
    }

}
