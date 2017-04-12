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
@Named("FundsGen")
public class FundsGen extends FileTxt {

    private String texto = "";

    private String year = "";
    private String initialYear = "";
    private String finalYear = "";
    private String debugYear = "";
    private String debug = "";

    private Integer iniYear = 0;
    private Integer finYear = 0;

    private Integer gestionYear = 0;
    private Integer centralYear = 0;

    private String gestion = "";
    private String central = "";
    private Map<String, String> trd = new HashMap<String, String>();

    private static final Logger log = Logger.getLogger(FundsGen.class.getName());

    @PersistenceContext(unitName = "archivalPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    FileTxt f1 = new FileTxt();
    FileTxt f2 = new FileTxt();
    FileTxt f3 = new FileTxt();
    FileTxt f4 = new FileTxt();

    public Map<String, String> trd(Set<TrdSeries> trdSeries,String year) {

        trd = new HashMap<String, String>();

        for (TrdSeries trdSerie : trdSeries){

             gestion = trdSerie.getTrd().getGestion().getName();
             trd.put("gestion", gestion);

             central = trdSerie.getTrd().getCentral().getName();
             trd.put("central", central);

             debug = trdSerie.getTrd().getFinalDisposition().getName();
             trd.put("debug", debug);

             gestionYear = trdSerie.getTrd().getGestion().getYear();
             if (gestionYear == null){
                 gestionYear = 0;
             }
             iniYear = Integer.parseInt(year) - gestionYear + 1;
             initialYear = String.valueOf(iniYear);
             trd.put("iniYear", initialYear);

             centralYear = trdSerie.getTrd().getCentral().getYear();
             if (centralYear == null){
                 centralYear = 0;
             }
             finYear = Integer.valueOf(year);
             finalYear = String.valueOf(finYear);
             trd.put("finYear", finalYear);
             trd.put("trdYear", finalYear);


             debugYear = String.valueOf(finYear+centralYear);
             trd.put("debugYear", debugYear);


        } // trdSeries
        return trd;
    } // trd


/*
    public String central(Set<TrdSeries> trdSeries) {
        for (TrdSeries trdSerie : trdSeries){
             central = trdSerie.getTrd().getCentral().getName();
        } // trdSeries
        return central;
    } // central

    public String debug(Set<TrdSeries> trdSeries) {
        for (TrdSeries trdSerie : trdSeries){
             debug = trdSerie.getTrd().getFinalDisposition().getName();
        } // trdSeries
        return debug;
    } // debug
*/

    public void lmr(Funds funds) {
    try {

        year = funds.getCode();

        f1.clearFileTxt();
        f1.line("{");
        f1.line("  \"OriginalOrders\": [");

        f2.clearFileTxt();
        f2.line("{");
        f2.line("  \"RelationshipsData\": [");

        for (Sections sections : funds.getSections()){

            clearFileTxt();
            f3.clearFileTxt();

            f4.clearFileTxt();
            f2.line("subject;code;entryDate;startDate;finalDate;folios;quantity;located;mail;notes;fileName;fileType;filedir");

            line("Orden;YEAR;AREA;NOMBRE DEL DOCUMENTO;FIS;MAG;ESTADO;FOLIOS;TRD;PROCESO;F.INGRESO;ACCESO;F.INICIAL;F.FINAL;ALMACENAMIENTO;NOMBRE;FIRMA");

            for (Series series : sections.getSeries()){

                texto = "";
                for (DocumentalsUnits documentalsUnits : series.getDocumentalsUnits()){


                     for (TrdSeries trdSeries : documentalsUnits.getSeries().getTrdSeries()){

                          gestion = trdSeries.getTrd().getGestion().getName();
                          central = trdSeries.getTrd().getCentral().getName();
                          debug = trdSeries.getTrd().getFinalDisposition().getName();

                          gestionYear = trdSeries.getTrd().getGestion().getYear();
                          if (gestionYear == null){
                             gestionYear = 0;
                          }
                          if (gestionYear == 0){
                              iniYear = Integer.parseInt(year);
                          }
                          else{
                              iniYear = Integer.parseInt(year) - gestionYear + 1;
                          }
                          initialYear = String.valueOf(iniYear);

                          centralYear = trdSeries.getTrd().getCentral().getYear();
                          if (centralYear == null){
                             centralYear = 0;
                          }
                          finYear = Integer.valueOf(year);
                          finalYear = String.valueOf(finYear);
                          debugYear = String.valueOf(finYear+centralYear);

                     } // TrdSeries

/*
                     if (central.equals("N.A")){
                         continue;
                     }
*/


                     texto += Double.toString(documentalsUnits.getOrden())+";"+funds.getCode()+";"+
                              gestion+";"+
                              documentalsUnits.getCode()+" "+documentalsUnits.getName()+";"+
                              documentalsUnits.getObservations()+";;VIGENTE;\"\";"+
                              central+";"+
                              sections.getCode()+";"+
                              "\"\";"+documentalsUnits.getAccess().getName()+";"+
                              "DD/MM/"+iniYear+";"+
                              "DD/MM/"+iniYear+";"+
                              "CARPETAS(X);\"\";\"\"";

                     if (!central.equals("N.A")){
                         f3.line(funds.getCompanies().getName());
                         f3.line(documentalsUnits.getCode());
                         f3.line(documentalsUnits.getName());
                         f3.line("DD/MM/"+iniYear+" - DD/MM/"+iniYear);
                         f3.line("Carpetas: 1 de XX  folios: XX al XX");
                         f3.line("TRD("+year+"): "+central);
                         f3.line("Disposicion final: "+debug+" "+debugYear);
                         f3.line("");
                     }

                     f1.line("  {");
                     f1.line("    \"subject\": \""+year+"-"+documentalsUnits.getName()+"\",");
                     f1.line("    \"code\": \""+year+"\"");
                     f1.line("  },");

                     f4.line(Double.toString(documentalsUnits.getOrden())+";"+
                             sections.getCode()+";"+year+"-"+documentalsUnits.getCode()+"-"+documentalsUnits.getName()+";"+
                             year+";"+
                             central+";"+
                             "entryDate;startDate;finalDate;folios;quantity;located;mail;notes;fileName;fileType;filedir");

                     f2.line("  {");
                     f2.line("    \"From\": \"DocumentalsUnits\",");
                     f2.line("    \"FromProperty\": \"name\",");
                     f2.line("    \"FromValue\": \""+documentalsUnits.getName()+"\",");
                     f2.line("    \"To\": \"OriginalOrders\",");
                     f2.line("    \"ToProperty\": \"subject\",");
                     f2.line("    \"ToValue\": \""+year+"-"+documentalsUnits.getName()+"\",");
                     f2.line("    \"Name\": \"\",");
                     f2.line("    \"Cardinalities\": \"Uno a Muchos Bidirecccional No.5\"");
                     f2.line("  },");

                     log.info(texto);
                     line(texto);

                } // DocumentalsUnits

            } // Series

            saveFile("\\docs", year+"-"+sections.getCode()+"-LMR"+".csv");
            f3.saveFile("\\docs", year+"-"+sections.getCode()+"-rotulos"+".txt");
            f4.saveFile("\\docs", year+"-"+sections.getCode()+"-OriginalOrders"+".csv");


        } // Sections

        f1.line("  ]");
        f1.line("}");

        f2.line("  ]");
        f2.line("}");

        f1.saveFile("\\docs", "OriginalOrders-"+year+".json");
        f2.saveFile("\\docs", "DocumentalsUnitsR5OriginalOrders-"+year+".json");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // lmr()

    public void ConservationUnitsData() {
    try {

        clearFileTxt();

        List<ConservationUnits> conservationUnits;
        Set<OriginalOrders> originalOrders = new HashSet<OriginalOrders>();

        conservationUnits = findBean.AllConservationUnits(em);

        for (ConservationUnits conservationUnit : conservationUnits){

            originalOrders = conservationUnit.getOriginalOrders();
            originalOrders.size();
            if (originalOrders.size() > 0){

               line(conservationUnit.getName()+" - ARCHIVO INACTIVO");
               line("year;codigo;nombre;trd;debug");
//               line(originalOrders.getDocumentalsUnits().getCode)+originalOrders.getDocumentalsUnits().getSeries().getSections().getFunds().getCompanies())

               for (OriginalOrders originalOrder : originalOrders){

                   trd = trd(originalOrder.getDocumentalsUnits().getSeries().getTrdSeries(),originalOrder.getCode());

                   line(trd.get("trdYear")+";"+
                        originalOrder.getDocumentalsUnits().getCode()+";"+
                        originalOrder.getDocumentalsUnits().getName()+";"+
                        trd.get("central")+";"+
                        trd.get("debugYear"));
               }
               line("-----------------------------------------------------------------------------------------------------------------------------");
               line("");

            }

        } // funds

        saveFile("\\docs","conservationUnit.csv");

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // ConservationUnitsData()


} // FundsGen