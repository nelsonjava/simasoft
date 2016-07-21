package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.*;

import java.io.*;
import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

import org.jboss.logging.Logger;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
@Named("DevelopmentsGen")
public class DevelopmentsGen extends FileTxt {

    private String texto = "";
    private static final Logger log = Logger.getLogger(DevelopmentsGen.class.getName());
    private static final String QUERYA = "SELECT c FROM AttributesProperties c WHERE c.name LIKE :custName";

    @PersistenceContext(unitName = "naifg24PU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    public void data(Developments developments) {
    try {

        clearFileTxt();

        texto = "developments:"+developments.getArtifactId();
        log.info(texto);
        line(texto);

        ArrayList<Relationships> relationships = new ArrayList<Relationships>(0);

        LinkedHashSet<String> imports = new LinkedHashSet<String>();

        Set<String> entitiesNames = new HashSet<String>();
        ArrayList<Entidad> entidades = new ArrayList<Entidad>(0);

        imports = imports(developments.getModels());
        entitiesNames = entitiesNames(developments);

        line("");
        texto = "==== Imports ====";
        log.info(texto);
        line(texto);

        for (String txt : imports){

            texto = txt;
            log.info(texto);
            line(texto);

        }


        line("");
        texto = "==== ENTIDADES ====";
        log.info(texto);
        line(texto);

        for (String nameEntity : entitiesNames){

            Entities entity = findBean.nameEntities(nameEntity,em);

            Entidad entidad = new Entidad(entity.getName());

            texto = entidad.getName();
            log.info(texto);
            line(texto);




        }

        saveFile("\\docs", "logs.txt");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()


    public Set<String> entitiesNames(Developments developments){

	Set<String> entitiesNames = new HashSet<String>();

        for (Models models : developments.getModels()){

            texto = "models:"+models.getArtifactId();
            log.info(texto);
            line(texto);

            for (ModelsGroupIds modelsGroupIds : models.getModelsGroupIds()){

/*
                texto = "modelsGroupIds:"+modelsGroupIds.getModels().getArtifactId()+modelsGroupIds.getGroupIds().getArtifactId();
                log.info(texto);
                line(texto);
*/

                line("");
                texto = "==== RELACIONES:"+modelsGroupIds.getGroupIds().getArtifactId()+" ====";
                log.info(texto);
                line(texto);

                for (GroupIdsEntities groupIdsEntities : modelsGroupIds.getGroupIds().getGroupIdsEntities()){

                    texto = groupIdsEntities.getRelationships().getFrom().getName()+" "+
                            groupIdsEntities.getRelationships().getCardinalities().getCardinality()+" "+
                            groupIdsEntities.getRelationships().getTo().getName();
                    log.info(texto);
                    line(texto);

                    entitiesNames.add(groupIdsEntities.getRelationships().getFrom().getName());
                    entitiesNames.add(groupIdsEntities.getRelationships().getTo().getName());

                } // for: modelsGroupIds.getGroupIds().getGroupIdsEntities()


            } // for: models.getModelsGroupIds()

        } // for: developments.getModels()

        return entitiesNames;
    } // EntitiesNames


    public LinkedHashSet<String> imports(Set<Models> models){

        LinkedHashSet<String> imports = new LinkedHashSet<String>();

        for(Models model : models){
           imports.add("import "+model.getGroupId()+".*;");
        }
        return imports;
    }




} // DevelopmentsGen