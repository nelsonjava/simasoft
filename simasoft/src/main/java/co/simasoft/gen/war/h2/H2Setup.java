package co.simasoft.gen.war.h2;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class H2Setup extends FileTxt {

  public H2Setup(String artifactId,String groupId) {

line("package co.simasoft.setup;\n");

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import java.util.*;");
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
line("@Named(\"Setup\")");
line("public class Setup {\n");

line("    @PersistenceContext(unitName = \""+artifactId+"PU-JTA\")");
line("    private EntityManager em;\n");

line("    private static final Logger log = Logger.getLogger(Setup.class.getName());\n");

line("    public void data() {\n");

line("    } // data\n");

line("} // Setup");


  } // Contructor

} // Class