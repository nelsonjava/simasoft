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
@Named("GroupIdsGen")
public class GroupIdsGen extends FileTxt {

    @PersistenceContext(unitName = "naifg29PU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(GroupIdsGen.class.getName());

    private String texto = "";

    private ModelsGroups modelsGroups = new ModelsGroups();
    private Set<Models> models = new HashSet<Models>();

    private FindBean findBean = new FindBean();


    public void data(GroupIds groupIds) {
    try {

        clearFileTxt();

        texto = "groupIds:"+groupIds.getArtifactId();
        log.info(texto);
        line(texto);

        modelsGroups = findBean.nameModelsGroups(groupIds.getArtifactId(),em);

        if (modelsGroups  == null){
            modelsGroups = new ModelsGroups();
            modelsGroups.setName(groupIds.getArtifactId());
        }

        for (Models model : groupIds.getModels()){

             texto = "models:"+model.getName();
             log.info(texto);
             line(texto);

             models.add(model);

        }
        modelsGroups.setModels(models);

        em.persist(modelsGroups);
        em.flush();

        saveFile("\\docs", "logs.txt");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()


} // GroupIdsGen