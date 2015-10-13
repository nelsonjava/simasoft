package co.simasoft.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import co.simasoft.models.dev.users.Users;

@RequestScoped
public class UsersListProducer {

    @Inject
    private UsersRepository usersRepository;

    private List<Users> users;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Users> getUsers() {
        return users;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Users users) {
        retrieveAllUsersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllUsersOrderedByName() {
        users = usersRepository.findAllOrderedByName();
    }
}
