package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2SimpleAuthenticator extends FileTxt {

  public H2SimpleAuthenticator() {

line("package co.simasoft.authentication;\n");

line("import org.picketlink.annotations.PicketLink;");
line("import org.picketlink.authentication.BaseAuthenticator;");
line("import org.picketlink.credential.DefaultLoginCredentials;");
line("import org.picketlink.idm.model.basic.User;\n");

line("import javax.faces.application.FacesMessage;");
line("import javax.faces.context.FacesContext;");
line("import javax.inject.Inject;\n");

line("@PicketLink");
line("public class SimpleAuthenticator extends BaseAuthenticator {\n");

line("    @Inject");
line("    private DefaultLoginCredentials credentials;\n");

line("    @Inject");
line("    private FacesContext facesContext;\n");

line("    @Override");
line("    public void authenticate() {");
line("        if (\"admin\".equals(credentials.getUserId()) && \"ajetres\".equals(credentials.getPassword())) {");
line("            setStatus(AuthenticationStatus.SUCCESS);");
line("            setAccount(new User(\"admin\"));");
line("        } else {");
line("            setStatus(AuthenticationStatus.FAILURE);");
line("            facesContext.addMessage(null, new FacesMessage(\"Authentication Failure - The username or password you provided were invalid.\"));");
line("        }");
line("    }\n");

line("}");

  } // Constructor

} // Fin de clase