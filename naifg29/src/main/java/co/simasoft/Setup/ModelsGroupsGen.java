package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.*;

import java.io.*;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

import org.jboss.logging.Logger;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@LocalBean
@Named("ModelsGroupsGen")
public class ModelsGroupsGen extends FileTxt {

    @PersistenceContext(unitName = "naifg29PU-JTA")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(ModelsGroupsGen.class.getName());

    private String texto = "";

    private Developments developments = new Developments();
    private Set<ModelsGroups> modelsGroups = new HashSet<ModelsGroups>();

    private FindBean findBean = new FindBean();


    public void data(ModelsGroups modelsGroups) {
    try {


        if (modelsGroups.getCode() == null  || modelsGroups.getCode().equals("") ) {

           FacesMessage message = new FacesMessage("modelsGroups.getCode()", " is null.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           texto = "modelsGroups.getCode() is null.";
           log.info(texto);
           line(texto);

           saveFile("\\docs", "logs.txt");

        }
        else{

           clearFileTxt();

           texto = "developments:"+modelsGroups.getCode();
           log.info(texto);
           line(texto);

           developments = findBean.artifactIdDevelopments(modelsGroups.getCode(),em);

           clearFileTxt();

           texto = "developments:"+modelsGroups.getCode();
           log.info(texto);
           line(texto);

           developments = findBean.artifactIdDevelopments(modelsGroups.getCode(),em);


           if (!(developments  == null)){

              developments = new Developments();

              developments.setArtifactId(modelsGroups.getCode());
              developments.setGroupId("co.simasoft");

              line("artifactId"+developments.getArtifactId());
              line("groupId"+developments.getGroupId());

              this.modelsGroups.add(modelsGroups);

              developments.setModelsGroups(this.modelsGroups);

              em.persist(developments);
              em.flush();

           }
           else {
             for (ModelsGroups modelsGroup : developments.getModelsGroups()){
                this.modelsGroups.add(modelsGroup);
             }
             this.modelsGroups.add(modelsGroups);
             developments.setModelsGroups(this.modelsGroups);

             em.persist(developments);
             em.flush();

           } // if

           saveFile("\\docs", "logs.txt");

        } // if

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()


} // GroupIdsGen