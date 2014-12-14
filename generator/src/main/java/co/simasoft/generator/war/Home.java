package co.simasoft.generator.war;

import co.simasoft.utils.*;

public class Home extends FileTxt {

  public Home(String artifactId,String groupId) {

line("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"");
line("         \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");

line("<html xmlns=\"http://www.w3.org/1999/xhtml\"");
line("      xmlns:ui=\"http://java.sun.com/jsf/facelets\"");
line("      xmlns:h=\"http://java.sun.com/jsf/html\"");
line("      xmlns:f=\"http://java.sun.com/jsf/core\">\n");

line("<head>");
line("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />");
line("  <title>"+artifactId+"</title>");
line("</head>\n");

line("<body>");
line("   <h1>Hello World!</h1>");
line("</body>\n");

line("</html>");

  } // Generar

} // Fin de clase
