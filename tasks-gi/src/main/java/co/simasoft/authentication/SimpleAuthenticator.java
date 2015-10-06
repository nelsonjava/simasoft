package co.simasoft.authentication;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@PicketLink
public class SimpleAuthenticator extends BaseAuthenticator {

    @Inject
    private DefaultLoginCredentials credentials;

    @Inject
    private FacesContext facesContext;

    @Override
    public void authenticate() {
        if ("admin".equals(credentials.getUserId()) && "ajetresgi".equals(credentials.getPassword())) {
            setStatus(AuthenticationStatus.SUCCESS);
            setAccount(new User("admin"));
        } else {
            setStatus(AuthenticationStatus.FAILURE);
            facesContext.addMessage(null, new FacesMessage("Authentication Failure - The username or password you provided were invalid."));
        }
    }

}
