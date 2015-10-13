package co.simasoft.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import co.simasoft.models.dev.users.Users;

@ApplicationScoped
public class UsersRepository {

    @Inject
    private EntityManager em;

    public Users findById(Long id) {
        return em.find(Users.class, id);
    }

    public Users findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
        Root<Users> users = criteria.from(Users.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(users.get(Users_.name), email));
        criteria.select(users).where(cb.equal(users.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Users> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
        Root<Users> users = criteria.from(Users.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(users).orderBy(cb.asc(users.get("name")));
        return em.createQuery(criteria).getResultList();
    }
}
