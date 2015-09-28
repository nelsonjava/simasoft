package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Resources extends FileTxt {

  public H2Resources() {

line("package co.simasoft.authentication;\n");

line("import javax.enterprise.context.RequestScoped;");
line("import javax.enterprise.inject.Produces;");
line("import javax.faces.context.FacesContext;\n");

line("public class Resources {\n");

line("    @Produces");
line("    @RequestScoped");
line("    public FacesContext produceFacesContext() {");
line("        return FacesContext.getCurrentInstance();");
line("    }\n");

line("}");



  } // Constructor

} // Fin de clase