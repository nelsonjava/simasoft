package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.util.*;
import java.text.*;
import java.util.Map.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Singleton
@LocalBean
@Named("fileUploadCsv")
public class FileUploadCsv {

    private String filePath = "";

    BufferedReader br = null;

    Integer i = 0;
    String entity = "";
    String line = "";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String cvsSplitBy = null;

    String[] types = new String[100];
    String[] fields = new String[100];
    String[] data;

    @PersistenceContext(unitName = "booksPU-JTA")
    private EntityManager em;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void data() {

    try {

        if(file != null) {

           i = 0;
           FileTxt f = new FileTxt();

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           br = new BufferedReader(new FileReader(filePath));
           while ((line = br.readLine()) != null) {

              i++;
              if (i==1){
                  data = line.split("");
                  cvsSplitBy = data[data.length-1];
              }
              else{
                  data = line.split(cvsSplitBy);
              }

              switch (i) {
                  case 1:
                       f.line("cvsSplitBy="+cvsSplitBy);
                       break;
                  case 2:
                       entity = data[data.length-1];
                       types = data;
                       f.line("Entidad:"+entity);
                       break;
                  case 3:
                       fields = data;
                       break;
                  default:
                       entitiesData(entity,fields,types,data,f,em);
                       break;
              }

           }
           f.saveFile("\\docs", entity+"Data.txt");

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    } finally {
        if (br != null) {
            try {
              br.close();
            }
            catch (IOException e) {
                  e.printStackTrace();
            }
        }
    }

    } // data()

    public void entitiesData(String entity,String[] fields,String[] types,String[] data,FileTxt f,EntityManager em) {

        switch (entity) {
            case "BooksTypes":
                 BooksTypes(entity,fields,types,data,f,em);
                 break;
            case "Books":
                 Books(entity,fields,types,data,f,em);
                 break;
            case "Chapters":
                 Chapters(entity,fields,types,data,f,em);
                 break;
            case "TypesFilms":
                 TypesFilms(entity,fields,types,data,f,em);
                 break;
            case "Films":
                 Films(entity,fields,types,data,f,em);
                 break;
            case "Videos":
                 Videos(entity,fields,types,data,f,em);
                 break;
            case "VideoContents":
                 VideoContents(entity,fields,types,data,f,em);
                 break;
        }

    } // Entities

    public void BooksTypes(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        BooksTypes booksTypes = new BooksTypes();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     booksTypes.setName(data[i]);
                     break;
            }

        } // for

        em.persist(booksTypes);
        em.flush();

    } // BooksTypes

    public void Books(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Books books = new Books();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     books.setCode(data[i]);
                     break;
                case "name":
                     books.setName(data[i]);
                     break;
            }

        } // for

        em.persist(books);
        em.flush();

    } // Books

    public void Chapters(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Chapters chapters = new Chapters();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "code":
                     chapters.setCode(data[i]);
                     break;
                case "name":
                     chapters.setName(data[i]);
                     break;
            }

        } // for

        em.persist(chapters);
        em.flush();

    } // Chapters

    public void TypesFilms(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        TypesFilms typesFilms = new TypesFilms();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     typesFilms.setName(data[i]);
                     break;
            }

        } // for

        em.persist(typesFilms);
        em.flush();

    } // TypesFilms

    public void Films(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Films films = new Films();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     films.setName(data[i]);
                     break;
            }

        } // for

        em.persist(films);
        em.flush();

    } // Films

    public void Videos(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        Videos videos = new Videos();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     videos.setName(data[i]);
                     break;
                case "time":
                     videos.setTime(data[i]);
                     break;
            }

        } // for

        em.persist(videos);
        em.flush();

    } // Videos

    public void VideoContents(String entity,String[] field,String[] types,String[] data,FileTxt f,EntityManager em) {

        VideoContents videoContents = new VideoContents();

        for(Integer i=0;i<=data.length-1;i+=1){

            f.line("("+types[i]+")"+field[i]+"="+data[i]);

            switch (field[i]) {
                case "name":
                     videoContents.setName(data[i]);
                     break;
                case "startTime":
                     videoContents.setStartTime(data[i]);
                     break;
                case "endTime":
                     videoContents.setEndTime(data[i]);
                     break;
            }

        } // for

        em.persist(videoContents);
        em.flush();

    } // VideoContents

}
