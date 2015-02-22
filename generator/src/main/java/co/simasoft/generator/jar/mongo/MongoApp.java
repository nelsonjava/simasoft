package co.simasoft.generator.jar.mongo;

import co.simasoft.utils.*;

public class MongoApp extends FileTxt {

  public MongoApp(String artifactId,String groupId) {

line("package "+groupId+";\n");

line("/**");
line(" * Hello world!");
line(" *");
line("*/\n");

line("import javax.persistence.EntityManager;");
line("import javax.persistence.EntityManagerFactory;");
line("import javax.persistence.Persistence;\n");

line("// import org.slf4j.Logger;");
line("// import org.slf4j.LoggerFactory;");

line("import "+groupId+".models.*;\n");

line("public class App{\n");

line("    // private static Logger log = LoggerFactory.getLogger(App.class);\n");

line("    public static void main( String[] args ){\n");

line("        System.out.println( \"Hello World!\" );\n");

line("        EntityManagerFactory emf = Persistence.createEntityManagerFactory(\""+artifactId+"PU\");\n");

line("        try {\n");

line("            EntityManager em = emf.createEntityManager();");
line("            em.getTransaction().begin();\n");

line("            Person p = new Person(\"Pedro\",\"Perez\");\n");

line("            em.persist(p);\n");
line("            em.getTransaction().commit();\n");
line("            em.close();\n");

line("            emf.close();\n");

line("        } catch ( Exception e ) {");
line("            e.printStackTrace();");
line("        }\n");

line("    } // main\n");

line("} // App");

  } // Generar

} // Fin de clase




