package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import java.util.*;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.http.Part;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

@Singleton
@LocalBean
@Named("fileUploadR")
public class FileUploadR {

    private String filePath = "";

    @PersistenceContext(unitName = "booksPU-JTA")
    private EntityManager em;

    FindBean findBean = new FindBean();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void relationshipsData(Boolean isValidate) {
    try {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           FileTxt f = new FileTxt();

           // read the json file
           FileReader reader = new FileReader(filePath);

           JSONParser jsonParser = new JSONParser();
           JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

           // get an array from the JSON object
           JSONArray arrayRelationships = (JSONArray) jsonObject.get("RelationshipsData");
           Iterator iteRelation = arrayRelationships.iterator();
           while (iteRelation.hasNext()) {

                 JSONObject relationObj = (JSONObject) iteRelation.next();

                 String from = (String)relationObj.get("From");
                 String fromProperty = (String)relationObj.get("FromProperty");
                 String fromValue = (String)relationObj.get("FromValue");
                 String to = (String)relationObj.get("To");
                 String toProperty = (String)relationObj.get("ToProperty");
                 String toValue = (String)relationObj.get("ToValue");
                 String name = (String)relationObj.get("Name");
                 String cardinalities = (String)relationObj.get("Cardinalities");

/*
BooksTypes::BooksTypes Uno a Muchos Bidirecccional No.5 Books 
BooksTypes::BooksTypes Uno a Muchos Bidirecccional No.5 BooksTypes 
Books::Books Uno a Muchos Bidirecccional No.5 Chapters 
Chapters::Chapters Uno a Muchos Bidirecccional No.5 Chapters 
TypesFilms::TypesFilms Uno a Muchos Bidirecccional No.5 Films 
Films::Films Uno a Muchos Bidirecccional No.5 Videos 
Videos::Videos Uno a Muchos Bidirecccional No.5 VideoContents 
*/

                 if (from.equals("BooksTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Books") &&
                     name.equals("")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     Books booksTo = new Books();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+booksTypesFrom.getName());
                     } // booksTypes

                     if (toProperty.equals("code")){
                         booksTo = findBean.codeBooks(toValue,em);
                         f.line("to:"+toValue+":"+booksTo.getCode());
                     } // Books.code

                     if (toProperty.equals("name")){
                         booksTo = findBean.nameBooks(toValue,em);
                         f.line("to:"+toValue+":"+booksTo.getName());
                     } // Books.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         booksTo.setBooksTypes(booksTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(booksTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "booksTypes.txt");

                     }

                 } // from: BooksTypes

                 if (from.equals("BooksTypes") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("BooksTypes") &&
                     name.equals("")){

                     BooksTypes booksTypesFrom = new BooksTypes();

                     BooksTypes booksTypesTo = new BooksTypes();

                     if (fromProperty.equals("name")){
                         booksTypesFrom = findBean.nameBooksTypes(fromValue,em);
                         f.line("from:"+fromValue+":"+booksTypesFrom.getName());
                     } // booksTypes

                     if (toProperty.equals("name")){
                         booksTypesTo = findBean.nameBooksTypes(toValue,em);
                         f.line("to:"+toValue+":"+booksTypesTo.getName());
                     } // BooksTypes.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         booksTypesTo.setObjPadre(booksTypesFrom);
                     }

                     if (!isValidate) {
                         em.merge(booksTypesTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "booksTypes.txt");

                     }

                 } // from: BooksTypes

                 if (from.equals("Books") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Chapters") &&
                     name.equals("")){

                     Books booksFrom = new Books();

                     Chapters chaptersTo = new Chapters();

                     if (fromProperty.equals("code")){
                         booksFrom = findBean.codeBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getCode());
                     } // books

                     if (fromProperty.equals("name")){
                         booksFrom = findBean.nameBooks(fromValue,em);
                         f.line("from:"+fromValue+":"+booksFrom.getName());
                     } // books

                     if (toProperty.equals("code")){
                         chaptersTo = findBean.codeChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getCode());
                     } // Chapters.code

                     if (toProperty.equals("name")){
                         chaptersTo = findBean.nameChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getName());
                     } // Chapters.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chaptersTo.setBooks(booksFrom);
                     }

                     if (!isValidate) {
                         em.merge(chaptersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "books.txt");

                     }

                 } // from: Books

                 if (from.equals("Chapters") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Chapters") &&
                     name.equals("")){

                     Chapters chaptersFrom = new Chapters();

                     Chapters chaptersTo = new Chapters();

                     if (fromProperty.equals("code")){
                         chaptersFrom = findBean.codeChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getCode());
                     } // chapters

                     if (fromProperty.equals("name")){
                         chaptersFrom = findBean.nameChapters(fromValue,em);
                         f.line("from:"+fromValue+":"+chaptersFrom.getName());
                     } // chapters

                     if (toProperty.equals("code")){
                         chaptersTo = findBean.codeChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getCode());
                     } // Chapters.code

                     if (toProperty.equals("name")){
                         chaptersTo = findBean.nameChapters(toValue,em);
                         f.line("to:"+toValue+":"+chaptersTo.getName());
                     } // Chapters.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         chaptersTo.setObjPadre(chaptersFrom);
                     }

                     if (!isValidate) {
                         em.merge(chaptersTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "chapters.txt");

                     }

                 } // from: Chapters

                 if (from.equals("TypesFilms") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Films") &&
                     name.equals("")){

                     TypesFilms typesFilmsFrom = new TypesFilms();

                     Films filmsTo = new Films();

                     if (fromProperty.equals("name")){
                         typesFilmsFrom = findBean.nameTypesFilms(fromValue,em);
                         f.line("from:"+fromValue+":"+typesFilmsFrom.getName());
                     } // typesFilms

                     if (toProperty.equals("name")){
                         filmsTo = findBean.nameFilms(toValue,em);
                         f.line("to:"+toValue+":"+filmsTo.getName());
                     } // Films.name

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         filmsTo.setTypesFilms(typesFilmsFrom);
                     }

                     if (!isValidate) {
                         em.merge(filmsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "typesFilms.txt");

                     }

                 } // from: TypesFilms

                 if (from.equals("Films") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("Videos") &&
                     name.equals("")){

                     Films filmsFrom = new Films();

                     Videos videosTo = new Videos();

                     if (fromProperty.equals("name")){
                         filmsFrom = findBean.nameFilms(fromValue,em);
                         f.line("from:"+fromValue+":"+filmsFrom.getName());
                     } // films

                     if (toProperty.equals("name")){
                         videosTo = findBean.nameVideos(toValue,em);
                         f.line("to:"+toValue+":"+videosTo.getName());
                     } // Videos.name

                     if (toProperty.equals("time")){
                         videosTo = findBean.timeVideos(toValue,em);
                         f.line("to:"+toValue+":"+videosTo.getTime());
                     } // Videos.time

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         videosTo.setFilms(filmsFrom);
                     }

                     if (!isValidate) {
                         em.merge(videosTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "films.txt");

                     }

                 } // from: Films

                 if (from.equals("Videos") &&
                     cardinalities.equals("Uno a Muchos Bidirecccional No.5") &&
                     to.equals("VideoContents") &&
                     name.equals("")){

                     Videos videosFrom = new Videos();

                     VideoContents videoContentsTo = new VideoContents();

                     if (fromProperty.equals("name")){
                         videosFrom = findBean.nameVideos(fromValue,em);
                         f.line("from:"+fromValue+":"+videosFrom.getName());
                     } // videos

                     if (fromProperty.equals("time")){
                         videosFrom = findBean.timeVideos(fromValue,em);
                         f.line("from:"+fromValue+":"+videosFrom.getTime());
                     } // videos

                     if (toProperty.equals("name")){
                         videoContentsTo = findBean.nameVideoContents(toValue,em);
                         f.line("to:"+toValue+":"+videoContentsTo.getName());
                     } // VideoContents.name

                     if (toProperty.equals("startTime")){
                         videoContentsTo = findBean.startTimeVideoContents(toValue,em);
                         f.line("to:"+toValue+":"+videoContentsTo.getStartTime());
                     } // VideoContents.startTime

                     if (toProperty.equals("endTime")){
                         videoContentsTo = findBean.endTimeVideoContents(toValue,em);
                         f.line("to:"+toValue+":"+videoContentsTo.getEndTime());
                     } // VideoContents.endTime

                     if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                         videoContentsTo.setVideos(videosFrom);
                     }

                     if (!isValidate) {
                         em.merge(videoContentsTo);
                         em.flush();
                     }

                     if (isValidate) {
                         f.saveFile("\\docs", "videos.txt");

                     }

                 } // from: Videos

           } // while

        } // if

    } catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (ParseException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    }

    } // relationshipsData()

}

