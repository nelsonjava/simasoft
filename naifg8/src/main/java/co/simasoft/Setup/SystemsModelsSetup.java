import co.simasoft.models.naif.domainmodels.*;

import co.simasoft.beans.*;

import co.simasoft.utils.*;

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
@Named("SystemsModelsSetup")
public class SystemsModelsSetup {

    @PersistenceContext(unitName = "naifg8PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private static final Logger log = Logger.getLogger(DataDb.class.getName());

    public void data() {

        DomainModels domainModels = new DomainModels();
        domainModels.setGroupId("co.simasof");
        domainModels.setArtifactId("SystemsModels");
        domainModels.setVersion("1.0.0-SNAPSHOT");        
        em.persist(domainModels);
        em.flush();

        GroupIds groupIds1 = new GroupIds();
        groupIds1.setGroupId("co.simasoft.models.naif.domainmodels.dependencies");
//      ...................... SystemsModels ........................
        DomainModels domainModel1 = new DomainModels();
        domainModel1 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds1.setDomainModels(domainModel1);
        em.persist(groupIds1);
        em.flush();

        GroupIds groupIds2 = new GroupIds();
        groupIds2.setGroupId("co.simasoft.models.naif.domainmodels.modelsFiles");
//      ...................... SystemsModels ........................
        DomainModels domainModel2 = new DomainModels();
        domainModel2 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds2.setDomainModels(domainModel2);
        em.persist(groupIds2);
        em.flush();

        GroupIds groupIds3 = new GroupIds();
        groupIds3.setGroupId("co.simasoft.models.naif.domainmodels.systemsModels");
//      ...................... SystemsModels ........................
        DomainModels domainModel3 = new DomainModels();
        domainModel3 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds3.setDomainModels(domainModel3);
        em.persist(groupIds3);
        em.flush();

        GroupIds groupIds4 = new GroupIds();
        groupIds4.setGroupId("co.simasoft.models.naif.domainmodels.entities");
//      ...................... SystemsModels ........................
        DomainModels domainModel4 = new DomainModels();
        domainModel4 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds4.setDomainModels(domainModel4);
        em.persist(groupIds4);
        em.flush();

        GroupIds groupIds5 = new GroupIds();
        groupIds5.setGroupId("co.simasoft.models.naif.domainmodels.links");
//      ...................... SystemsModels ........................
        DomainModels domainModel5 = new DomainModels();
        domainModel5 = findBean.artifactIdDomainModels("SystemsModels",em);
        groupIds5.setDomainModels(domainModel5);
        em.persist(groupIds5);
        em.flush();

    }
    
}    