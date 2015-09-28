package co.simasoft.authentication;

import java.util.Calendar;
import java.util.Date;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.AdapterUtils;
import org.keycloak.representations.IDToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.util.JsonSerialization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Model
public class PropertyBean {

    public String getProperty(String key) {
        return System.getProperty(key);
    }

    public Date getDate() {
        return Calendar.getInstance().getTime();
    }

    public static IDToken getIDToken(HttpServletRequest req) {
        KeycloakSecurityContext session = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());
        return session.getIdToken();

    }

    public String getSessionIdddd() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        String sessionId = session.getId();
        return sessionId;
    }

    public String getSessionId() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        KeycloakSecurityContext session = (KeycloakSecurityContext) fCtx.getExternalContext().getSession(false);
        IDToken iDToken = session.getIdToken();
        return iDToken.getName();
    }

}
