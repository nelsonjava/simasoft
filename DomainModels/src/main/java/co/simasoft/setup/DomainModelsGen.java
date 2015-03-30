package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.models.naif.DomainModels.*;

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
@Named("DomainModelsGen")
public class DomainModelsGen {

    ArrayList<String> imports = new ArrayList<String>();

    public void data(DomainModels domainModels) {
      
        imports.add(domainModels.getName()+".models");

        Models models = new Models(domainModels.getName(),domainModels.getName(),domainModels.getName());
        models.setImports(imports);
        models.setEntities(entidades);
        models.WarH2();



    } // data()


} // DomainModelsSetup

