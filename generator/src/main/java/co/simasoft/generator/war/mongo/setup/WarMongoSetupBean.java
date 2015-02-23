package co.simasoft.generator.war.mongo;

import co.simasoft.utils.*;

public class WarMongoSetupBean extends FileTxt {

  public WarMongoSetupBean(String artifactId,String groupId) {

line("package com.simavirtual.setup;\n");

line("import com.simavirtual.model.*;\n");

line("import java.util.Calendar;");
line("import java.util.Random;");
line("import javax.ejb.LocalBean;");
line("import javax.ejb.Singleton;");
line("import javax.inject.Named;");
line("import javax.persistence.EntityManager;");
line("import javax.persistence.PersistenceContext;");
line("import org.jboss.logging.Logger;\n");

line("@Singleton");
line("@LocalBean");
line("@Named(\"setupbean\")");
line("public class SetupBean {\n");

line("    @PersistenceContext(unitName = \""+artifactId+"PU-JTA\")");
line("    private EntityManager em;");
line("    private static final Logger log = Logger.getLogger(SetupBean.class.getName());\n");

line("    public void populateTest() {\n");

line("        log.info(\"Please wait while preparing database data ... \");\n");

line("        Person p = new Person(\"James\",\"Rodriguez\");\n");
line("        em.persist(p);");
line("        em.flush();\n");

line("        log.info(\"Database successfully populated ... \");\n");

line("    } // end : populateTest Method\n");

line("}");

  } // WarMongoPersistence

} // Fin de clase