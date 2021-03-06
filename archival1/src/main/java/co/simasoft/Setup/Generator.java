/*
line(Integer.toString(developments.getModels().size()));
*/

package co.simasoft.setup;

import co.simasoft.utils.*;
import co.simasoft.beans.*;

import co.simasoft.models.*;

import java.io.*;
import java.util.*;

import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

/*
  Pruebas a archivo texto
  FileTxt fileTxt = new FileTxt();
  fileTxt.line("Prueba");
  Utils.fileMake("\\docs","leame.txt",fileTxt );
*/


@Singleton
@LocalBean
@Named("Generator")
public class Generator extends FileTxt {

    private static final Logger log = Logger.getLogger(Generator.class.getName());

    @PersistenceContext(unitName = "archivalPU-JTA")
    private EntityManager em;

    public void DocumentalsUnits(List<DocumentalsUnits> documentalsUnits) throws IOException {
    try {

        clearFileTxt();

        line("PROCESO,CODIGO,NOMBRE,GESTION,CENTRAL");
        for (DocumentalsUnits documentalUnit : documentalsUnits){
            line(documentalUnit.getSeries().getSections().getName()+","+
                 documentalUnit.getCode()+","+
                 documentalUnit.getName()+","+
                 documentalUnit.getSeries().getGestion().getName()+","+
                 documentalUnit.getSeries().getCentral().getName()
                 );
        } // documentalsUnits

        saveFile("\\docs", "archival.csv");


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // DocumentalsUnits()

} // Generator