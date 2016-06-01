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
@Named("DevelopmentsGen")
public class DevelopmentsGen extends FileTxt {

    private static final Logger log = Logger.getLogger(DevelopmentsGen.class.getName());

    @PersistenceContext(unitName = "archivalPU-JTA")
    private EntityManager em;

    public void data(SectionsTypes sectionsTypes) throws IOException {
    try {

        clearFileTxt();

/*
        for (Sections section : sectionsTypes.getSections()){

            line(section.getName());

        } // sections
*/

        line("Prueba de Gestion documental:"+sectionsTypes.getName());
        saveFile("\\docs", "archival.txt");


    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()

} // DevelopmentsGen