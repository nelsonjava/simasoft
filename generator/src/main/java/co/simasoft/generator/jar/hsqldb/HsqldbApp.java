package co.simasoft.generator.jar.hsqldb;

import co.simasoft.utils.*;

public class HsqldbApp extends FileTxt {

  public HsqldbApp(String artifactId,String groupId) {

line("package "+groupId+";\n");

line("/**");
line(" * Hello world!");
line(" *");
line("*/\n");

line("import javax.persistence.EntityManager;");
line("import javax.persistence.EntityManagerFactory;");
line("import javax.persistence.Persistence;\n");

line("import org.slf4j.Logger;");
line("import org.slf4j.LoggerFactory;");

line("import "+groupId+".models.*;\n");


line("public class App{\n");

line("    private static Logger log = LoggerFactory.getLogger(App.class);\n");

line("    public static void main( String[] args ){\n");

line("        System.out.println( \"Hello World!\" );\n");

line("        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(\""+artifactId+"PU\");");
line("        EntityManager entityManager = entityManagerFactory.createEntityManager();\n");

line("        User found = entityManager.find(User.class, 1L);");
line("        log.info(\"found=\" + found);");
line("        System.out.println( \"Paso!\" );\n");

line("    } // main\n");

line("} // App");

  } // Generar

} // Fin de clase




