package app.dao;

import app.model.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository //не проксируются, объявление бинами @Bean
public class AuthorityDaoImpl {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Authority authority) {
        entityManager.persist(authority);
    }

    public Authority findByAuthority(String auth) {
        TypedQuery<Authority> query = entityManager.createQuery(
                "from Authority a where a.authority = :auth ", Authority.class);
        query.setParameter("auth", auth);
        return query.getSingleResult();
    }

}
