package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2PropertyBean extends FileTxt {

  public H2PropertyBean() {

line("package co.simasoft.authentication;\n");

line("import java.util.Calendar;");
line("import java.util.Date;\n");

line("import javax.enterprise.inject.Model;");
line("import javax.faces.context.FacesContext;");
line("import javax.servlet.http.HttpSession;\n");

line("@Model");
line("public class PropertyBean {\n");

line("    public String getProperty(String key) {");
line("        return System.getProperty(key);");
line("    }\n");

line("    public Date getDate() {");
line("        return Calendar.getInstance().getTime();");
line("    }\n");

line("	  public String getSessionId() {");
line("        FacesContext fCtx = FacesContext.getCurrentInstance();");
line("        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);");
line("        String sessionId = session.getId();");
line("        return sessionId;");
line("    }\n");

line("}");



  } // Constructor

} // Fin de clase