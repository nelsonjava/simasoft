/*
  https://github.com/czetsuya/picketlink-authentication-jsf
*/

package co.simasoft.authentication;

import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * A simple PicketLink authenticator that will accept a hard coded username/password value. The
 * @PicketLink annotation is required to indicate to PicketLink that this is the default Authenticator
 * to be used.
 * 
 * @author Shane Bryzak
 *
 */
@PicketLink
public class SimpleAuthenticator extends BaseAuthenticator {

    @Inject 
    private DefaultLoginCredentials credentials;

    @Inject
    private FacesContext facesContext;

    @Override
    public void authenticate() {
        if ("admin".equals(credentials.getUserId()) &&
                "ajetres".equals(credentials.getPassword())) {
            setStatus(AuthenticationStatus.SUCCESS);
            setAccount(new User("admin"));
        } else {
            setStatus(AuthenticationStatus.FAILURE);
            facesContext.addMessage(null, new FacesMessage(
                    "Authentication Failure - The username or password you provided were invalid."));
        }
    }



}
