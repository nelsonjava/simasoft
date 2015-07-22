import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.beans.*;

import co.simasoft.utils.*;

import java.io.*;
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
@Named("SetupTest")
public class SetupTest extends FileTxt {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {
    try {

//      ---------------------- DomainModels ------------------------

/*
        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasoft");
        domainModels.setArtifactId("sgdea");
        domainModels.setVersion("1.0-SNAPSHOT");
        em.persist(domainModels);
        em.flush();
*/

//      ---------------------- GroupIds ------------------------

/*
        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.sgdea");

        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("SGDEA",em);
        groupIds1.setDomainModels(domainModel1);

        em.persist(groupIds1);
        em.flush();
*/


//      ---------------------- Entities ------------------------

/*
        Entities entities2 = new Entities();
        entities2.setName("UnidadesConservacion");

        GroupIds groupId2 = new GroupIds();
        groupId2 = findBean.groupIdGroupIds("co.simasoft.models.naif.sgdea",em);
        entities2.setGroupIds(groupId2);
        em.persist(entities2);
        em.flush();
*/

line("paso1");
//DomainModels domainModel1 = new DomainModels();
//domainModel1 = findBean.artifactIdDomainModels("sgdea",em);
line("paso2");
//line(domainModel1.getArtifactId());
line("paso3");




//      ---------------------- Relationships ------------------------



        saveFile("\\docs", "SetupTest.txt");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }


    } // data()

} // SGDEA
