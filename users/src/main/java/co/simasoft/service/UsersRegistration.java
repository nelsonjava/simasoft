package co.simasoft.service;

import co.simasoft.models.dev.users.Users;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class UsersRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Users> usersEventSrc;

    public void register(Users users) throws Exception {
        log.info("Registering " + users.getName());
        em.persist(users);
        usersEventSrc.fire(users);
    }
}
