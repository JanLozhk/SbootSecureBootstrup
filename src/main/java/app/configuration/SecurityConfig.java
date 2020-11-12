package app.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration //позволяет нам использовать @Bean, проксируются через CGLIB
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    /*private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        *//* auth.inMemoryAuthentication().withUser("ADMIN").
        password("ADMIN").roles("ADMIN");*//*
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
*//*            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            filter.setEncoding("UTF-8");
            filter.setForceEncoding(true);
            http.addFilterBefore(filter, CsrfFilter.class);*//*
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(new UserSuccessHandler()).permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        ;
        http.userDetailsService(userDetailsService);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }*/

}