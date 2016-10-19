package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.*;
import co.simasoft.view.*;

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
@Named("PrediosGen")
public class PrediosGen extends FileTxt {

    private String texto = "";

    private static final Logger log = Logger.getLogger(PrediosGen.class.getName());

    @PersistenceContext(unitName = "leanCrmPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    FileTxt f1 = new FileTxt();
    FileTxt f2 = new FileTxt();
    FileTxt f3 = new FileTxt();

    public void PhysicalAreasData() {
    try {

        clearFileTxt();

        List<Predio> predios;

        predios = findBean.AllPredio(em);

        line("code;predio;physicalSpaces;physicalAreas;width;high;area");

        for(Predio predio : predios){

            for(PhysicalSpaces physicalSpaces : predio.getPhysicalSpaces()){

                for(PhysicalAreas physicalAreas : physicalSpaces.getPhysicalAreas()){

                   line(predio.getCode()+"."+physicalSpaces.getPhysicalSpacesTypes().getCode()+"."+physicalAreas.getPhysicalAreasTypes().getCode()+";"+
                        predio.getNomenclatura()+";"+
                        physicalSpaces.getName()+";"+
                        physicalAreas.getName()+";"+
                        physicalAreas.getWidth()+";"+
                        physicalAreas.getHigh()+";"+
                        physicalAreas.getWidth()*physicalAreas.getHigh());

                } // physicalSpaces.getPhysicalAreas()

            } // predio.getPhysicalSpaces()

        } // predios

        saveFile("\\docs","prediosData.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // PhysicalAreasData()


} // PrediosGen