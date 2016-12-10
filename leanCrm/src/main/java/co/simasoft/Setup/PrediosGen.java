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

        line("Code;Predios;Spaces;PhysicalAreas;Width;High;Area");

        for(Predio predio : predios){

//            line(predio.getCode()+";"+predio.getNomenclatura());

            for(PhysicalSpaces physicalSpaces : predio.getPhysicalSpaces()){

/*
                line(predio.getCode()+"."+physicalSpaces.getPhysicalSpacesTypes().getCode()+";"+
                     predio.getNomenclatura()+";"+
                     physicalSpaces.getName());
*/                     

                for(PhysicalAreas physicalAreas : physicalSpaces.getPhysicalAreas()){

                   line(predio.getCode()+"."+physicalSpaces.getPhysicalSpacesTypes().getCode()+"."+physicalAreas.getPhysicalAreasTypes().getCode()+";"+
                        predio.getNomenclatura()+";"+
                        physicalSpaces.getName()+";"+
                        physicalAreas.getName()+";"+
                        physicalAreas.getWidth()+";"+
                        physicalAreas.getHigh()+";"+
                        physicalAreas.getHigh()+";"+
                        physicalAreas.getPhysicalAreasTypes().getName());

                } // physicalSpaces.getPhysicalAreas()

            } // predio.getPhysicalSpaces()

        } // predios

        saveFile("\\docs","prediosData.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // PhysicalAreasData()

    public void PhysicalSpacesData() {
    try {

        clearFileTxt();

        List<Predio> predios;

        predios = findBean.AllPredio(em);

        line("Code;Predios;PhysicalSpaces");

        for(Predio predio : predios){

            for(PhysicalSpaces physicalSpaces : predio.getPhysicalSpaces()){

                line(predio.getCode()+"."+physicalSpaces.getPhysicalSpacesTypes().getCode()+";"+
                     predio.getNomenclatura()+";"+physicalSpaces.getName());

                for(PhysicalSpaces hijo : physicalSpaces.getObjHijos() ){
                    line(predio.getCode()+"."+physicalSpaces.getPhysicalSpacesTypes().getCode()+"."+hijo.getPhysicalSpacesTypes().getCode()+";;"+
                         "  "+hijo.getName());
                }


            } // predio.getPhysicalSpaces()

        } // predios

        saveFile("\\docs","SpacesData.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // PhysicalSpacesData()

    public void PhysicalSpacesTypesData() {
    try {

        clearFileTxt();

        List<PhysicalSpacesTypes> physicalSpacesTypes;

        physicalSpacesTypes = findBean.AllPhysicalSpacesTypes(em);

        line("Code;Types;");

        for(PhysicalSpacesTypes type : physicalSpacesTypes){

            line(type.getCode()+";"+
                 type.getName());

            for(PhysicalSpacesTypes hijo : type.getObjHijos() ){
                line("  "+hijo.getCode()+";"+"  "+type.getName());
            }


        } // physicalSpacesTypes

        saveFile("\\docs","PhysicalSpacesTypesData.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // PhysicalSpacesTypesData()

    public void PhysicalAreasTypesData() {
    try {

        clearFileTxt();

        List<PhysicalAreasTypes> physicalAreasTypes;

        physicalAreasTypes = findBean.AllPhysicalAreasTypes(em);

        line("Code;Types;");

        for(PhysicalAreasTypes type : physicalAreasTypes){

            line(type.getCode()+";"+
                 type.getName());

        } // physicalAreasTypes

        saveFile("\\docs","PhysicalAreasTypesData.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // PhysicalSpacesTypesData()



} // PrediosGen