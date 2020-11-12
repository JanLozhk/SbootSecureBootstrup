package app.service;


import org.springframework.stereotype.Service;

@Service("userDetailsService")//не проксируются, объявление бинами @Bean
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {

    /*@Autowired
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
    }*/

}
