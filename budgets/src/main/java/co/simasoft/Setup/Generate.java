/*
  f1.line(Integer.toString(constructionActivities.size()));
  https://docs.oracle.com/javase/7/docs/api/java/util/Set.html para pasar el Set a Array
    1. Ordenarlo
    2. Agregar sin repetir
*/

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
@Named("Generate")
public class Generate extends FileTxt {

    private String texto = "";

    private static final Logger log = Logger.getLogger(Generate.class.getName());

    @PersistenceContext(unitName = "budgetsPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    FileTxt f1 = new FileTxt();
    FileTxt f2 = new FileTxt();
    FileTxt f3 = new FileTxt();
    FileTxt f4 = new FileTxt();
    FileTxt f5 = new FileTxt();

    public void budgets1(WorksConstruction worksConstruction) {
    try {

        TypesWorksConstruction typesWorksConstruction = worksConstruction.getTypesWorksConstruction();
        Set<ConstructionActivities> constructionActivities = typesWorksConstruction.getConstructionActivities();

        f1.clearFileTxt();
        f1.line("ITEM;DESCRIPCION;UND;CANTIDAD;V/UNITARIO;VALOR TOTAL");

        for (ConstructionActivities constructionActivity : constructionActivities){

             String item = constructionActivity.getCode();
             String descripcion = constructionActivity.getName();
             String unidad = "";
             double vlrUnitario = 0.0;

             Apus apus = constructionActivity.getApus();

             if (apus != null){

                unidad = apus.getMeasurementUnits().getName();

                double nMateriales = 0.0;
                for (ConstructionMaterials constructionMaterials : apus.getConstructionMaterials()){
                     nMateriales += constructionMaterials.getPrice();
                }
                vlrUnitario += nMateriales;

                double nWorkforce = 0.0;
                for (ConstructionWorkforce constructionWorkforce : apus.getConstructionWorkforce()){
                     nWorkforce += constructionWorkforce.getBasic();
                }
                vlrUnitario += nWorkforce;

                double nTransports = 0.0;
                for (ConstructionTransports constructionTransports : apus.getConstructionTransports()){
                     nTransports += constructionTransports.getRate();
                }
                vlrUnitario += nTransports;

                double nEquipments = 0.0;
                for (ConstructionEquipments constructionEquipments : apus.getConstructionEquipments()){
                     nEquipments += constructionEquipments.getRate();
                }
                vlrUnitario += nEquipments;

             }

             f1.line(item+";"+
                     descripcion+";"+
                     unidad+";0.0;"+
                     Double.toString(vlrUnitario)+";"+
                     "0.0");

        } // For constructionActivities

        f1.saveFile("\\docs.","presupuesto1.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // budgets1()

    public void budgets2(WorksConstruction worksConstruction) {
    try {

        TypesWorksConstruction typesWorksConstruction = worksConstruction.getTypesWorksConstruction();
        Set<ConstructionActivities> constructionActivities = typesWorksConstruction.getConstructionActivities();

        LinkedHashSet<ConstructionChapters> constructionChapters = new LinkedHashSet<ConstructionChapters>(0);

        ArrayList<Actividades> presupuesto = new ArrayList<Actividades>() ;

        f1.clearFileTxt();
        f1.line("ITEM;DESCRIPCION;UND;CANTIDAD;V/UNITARIO;VALOR TOTAL");

        for (ConstructionActivities constructionActivity : constructionActivities){

             String item = constructionActivity.getCode();
             String descripcion = constructionActivity.getName();
             String unidad = "";
             double vlrUnitario = 0.0;

             constructionChapters.add(constructionActivity.getConstructionChapters());

             Apus apus = constructionActivity.getApus();

             if (apus != null){

                unidad = apus.getMeasurementUnits().getName();

                double nMateriales = 0.0;
                for (ConstructionMaterials constructionMaterials : apus.getConstructionMaterials()){
                     nMateriales += constructionMaterials.getPrice();
                }
                vlrUnitario += nMateriales;

                double nWorkforce = 0.0;
                for (ConstructionWorkforce constructionWorkforce : apus.getConstructionWorkforce()){
                     nWorkforce += constructionWorkforce.getBasic();
                }
                vlrUnitario += nWorkforce;

                double nTransports = 0.0;
                for (ConstructionTransports constructionTransports : apus.getConstructionTransports()){
                     nTransports += constructionTransports.getRate();
                }
                vlrUnitario += nTransports;

                double nEquipments = 0.0;
                for (ConstructionEquipments constructionEquipments : apus.getConstructionEquipments()){
                     nEquipments += constructionEquipments.getRate();
                }
                vlrUnitario += nEquipments;

             }

             f1.line(item+";"+
                     descripcion+";"+
                     unidad+";0.0;"+
                     Double.toString(vlrUnitario)+";"+
                     "0.0");

             Actividades actividad1 = new Actividades();
             actividad1.setItem(item);
             actividad1.setDescripcion(descripcion);
             actividad1.setUnidad(unidad);
             actividad1.setVlrUnitario(vlrUnitario);

             presupuesto.add(actividad1);

        } // For constructionActivities

        for (ConstructionChapters constructionChapter : constructionChapters){

             f1.line(constructionChapter.getCode()+";"+
                     constructionChapter.getName()+";"+
                     ";;;;");

             Actividades actividad2 = new Actividades();
             actividad2.setItem(constructionChapter.getCode());
             actividad2.setDescripcion(constructionChapter.getName());
             actividad2.setUnidad("");
             actividad2.setVlrUnitario(0.0);
             presupuesto.add(actividad2);
        }

        f1.saveFile("\\docs.","presupuesto2.csv");

        f2.clearFileTxt();
        f2.line("ITEM;DESCRIPCION;UND;CANTIDAD;V/UNITARIO;VALOR TOTAL");

        Collections.sort(presupuesto);
        for (Actividades actividades : presupuesto){

             f2.line(actividades.getItem()+";"+
                     actividades.getDescripcion()+";"+
                     actividades.getUnidad()+";0.0;"+
                     Double.toString(actividades.getVlrUnitario())+";"+
                     "0.0");
        }
        f2.saveFile("\\docs.","presupuesto3.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // budgets2()



} // Generate