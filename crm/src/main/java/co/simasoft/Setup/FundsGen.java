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

    private static final Logger log = Logger.getLogger(FundsGen.class.getName());

    @PersistenceContext(unitName = "crmPU-JTA")
    private EntityManager em;

    FileTxt f1 = new FileTxt();
    FileTxt f2 = new FileTxt();
    FileTxt f3 = new FileTxt();

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
                          iniYear = Integer.parseInt(year) - gestionYear + 1;
                          initialYear = String.valueOf(iniYear);

                          centralYear = trdSeries.getTrd().getCentral().getYear();
                          if (centralYear == null){
                             centralYear = 0;
                          }
                          finYear = Integer.valueOf(year);
                          finalYear = String.valueOf(finYear);
                          debugYear = String.valueOf(finYear+centralYear);

                     } // TrdSeries

                     if (central.equals("N.A")){
                         continue;
                     }

                     texto += "Orden;"+funds.getCode()+";"+
                              gestion+";"+
                              documentalsUnits.getCode()+" "+documentalsUnits.getName()+";"+
                              "FIS;MAG;ESTADO;\"\";"+
                              central+";"+
                              sections.getCode()+";"+
                              "\"\";ACCESO;"+
                              "DD/MM/"+iniYear+";"+
                              "DD/MM/"+iniYear+";"+
                              "CARPETAS(X);\"\";\"\"";

                     f3.line(funds.getCompanies().getName());
                     f3.line(documentalsUnits.getCode());
                     f3.line(documentalsUnits.getName());
                     f3.line("DD/MM/"+iniYear+" - DD/MM/"+iniYear);
                     f3.line("Carpetas: 1 de XX  folios: XX al XX");
                     f3.line("TRD("+year+"): "+central);
                     f3.line("Disposicion final: "+debug+" "+debugYear);
                     f3.line("");

                     f1.line("  {");
                     f1.line("    \"subject\": \""+year+"-"+documentalsUnits.getName()+"\",");
                     f1.line("    \"code\": \""+year+"\"");
                     f1.line("  },");

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

            saveFile("\\docs", sections.getCode()+"-"+year+"-F-GI-04"+".csv");
            f3.saveFile("\\docs", sections.getCode()+"-"+year+"-rotulos"+".txt");

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

    } // data()


} // FundsGen