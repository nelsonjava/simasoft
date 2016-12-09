package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

public class H2Keycloak extends FileTxt {

  public H2Keycloak() {

line("{");
line("  \"realm\": \"nafgkc\",\n");

line("  <security-constraint>");
line("    <web-resource-collection>");
line("      <url-pattern>/*</url-pattern>");
line("    </web-resource-collection>");
line("    <auth-constraint>");
line("      <role-name>admin</role-name>");
line("    </auth-constraint>");
line("  </security-constraint>\n");

line("  <security-constraint>");
line("    <web-resource-collection>");
line("      <url-pattern>/*</url-pattern>");
line("    </web-resource-collection>");
line("    <auth-constraint>");
line("      <role-name>user</role-name>");
line("    </auth-constraint>");
line("  </security-constraint>\n");

line("  <login-config>");
line("    <auth-method>KEYCLOAK</auth-method>");
line("    <realm-name>nafgkc</realm-name>");
line("  </login-config>\n");

line("  <security-role>");
line("    <role-name>admin</role-name>");
line("  </security-role>\n");

line("  <security-role>");
line("    <role-name>user</role-name>");
line("  </security-role>\n");

line("}");

  } // Constructor

} // Fin de clase
