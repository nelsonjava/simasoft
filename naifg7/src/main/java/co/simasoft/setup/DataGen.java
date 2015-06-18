package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.naif.domainmodels.*;

import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Singleton
@LocalBean
@Named("DataGen")
public class DataGen extends FileTxt {

    @PersistenceContext(unitName = "naifg7PU-JTA")
    private EntityManager em;

    int i=0;
    int j=0;

    public void data() {
    try {

        clearFileTxt();

        FindBean findBean = new FindBean();

line("import co.simasoft.models.naif.domainmodels.*;\n");

line("import co.simasoft.utils.*;\n");

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
line("@Named(\"DomainModelsSetup\")");
line("public class Db {\n");

line("    @PersistenceContext(unitName = \"naifg8PU-JTA\")");
line("    private EntityManager em;\n");

line("    FindBean findBean = new FindBean();\n");

line("    private static final Logger log = Logger.getLogger(Db.class.getName());\n");

line("//      ---------------------- SystemsModels ------------------------\n");

        i=0;
        List<SystemsModels> systemsModels = findBean.AllSystemsModels(em);
        for (SystemsModels systemModel : systemsModels) {

line("    SystemsModels systemsModels"+String.valueOf(++i)+" = new SystemsModels();");
line("    systemsModels"+String.valueOf(i)+".setName(\""+systemModel.getName()+"\");");
line("    em.persist(systemsModels"+String.valueOf(i)+");");
line("    em.flush();\n");

        }

line("//      ---------------------- DomainModels ------------------------\n");

        i=0;
        j=0;
        List<DomainModels> domainModels = findBean.AllDomainModels(em);
        for (DomainModels domainModel : domainModels) {

line("    DomainModels domainModels"+String.valueOf(++i)+" = new DomainModels();");
line("    domainModels"+String.valueOf(i)+".setGroupId(\""+domainModel.getGroupId()+"\");");
line("    domainModels"+String.valueOf(i)+".setArtifactId(\""+domainModel.getArtifactId()+"\");");
line("    domainModels"+String.valueOf(i)+".setVersion(\""+domainModel.getVersion()+"\");");
line("//      ...................... "+domainModel.getSystemsModels().getName()+"........................");
line("    SystemsModels systemModel"+String.valueOf(++j)+" = new SystemsModels();");
line("    systemModel"+String.valueOf(j)+" = findBean.nameSystemsModels(\""+domainModel.getSystemsModels().getName()+"\",em);");
line("    domainModels"+String.valueOf(i)+".setSystemsModels(systemModel"+String.valueOf(j)+");");
line("    em.persist(domainModels"+String.valueOf(i)+");");
line("    em.flush();\n");

        }

line("//      ---------------------- GroupIds ------------------------\n");

        i=0;
        List<GroupIds> groupIds = findBean.AllGroupIds(em);
        for (GroupIds groupId : groupIds) {

line("  GroupIds groupIds"+String.valueOf(++i)+" = new GroupIds();");
line("  groupIds"+String.valueOf(i)+".setGroupId(\""+groupId.getGroupId()+"\");");
line("  groupIds"+String.valueOf(i)+".setDomainModels(domainModels);");
line("//      ...................... "+groupId.getDomainModels().getArtifactId()+" ........................");
line("  DomainModels domainModel"+String.valueOf(++j)+" = new DomainModels();");
line("  domainModel"+String.valueOf(j)+" = findBean.artifactIdDomainModels(\""+groupId.getDomainModels().getArtifactId()+"\",em);");
line("  groupIds"+String.valueOf(i)+".setDomainModels(domainModel"+String.valueOf(j)+");");
line("  em.persist(groupIds"+String.valueOf(i)+");");
line("  em.flush();\n");

        }





line("} // DomainModelsSetup");



        saveFile("\\docs", "Db.java");

    } // try
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data

} // Setup
