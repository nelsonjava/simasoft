package co.simasoft.setup;

import co.simasoft.beans.*;
import co.simasoft.utils.*;

import co.simasoft.models.*;

import java.util.*;
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
@Named("fileUploadCsvR")
public class FileUploadCsvR {

    private String filePath = "";

    @PersistenceContext(unitName = "booksPU-JTA")
    private EntityManager em;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void data(Boolean isValidate) {

        if(file != null) {

           filePath = "\\docs\\"+file.getFileName();

           FileTxt f = new FileTxt();

           FacesMessage message = new FacesMessage("Succesful", filePath + " is uploaded.");
           FacesContext.getCurrentInstance().addMessage(null, message);

           if(file.getFileName().indexOf("R5") > 0){
              relationshipsR5(filePath,em,isValidate,f);
           }

           if(file.getFileName().indexOf("R7") > 0){
              relationshipsR7(filePath,em,isValidate,f);
           }

        } // if

    } // data()

    public void relationshipsR5(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        String line = "";
        String cvsSplitBy = null;
        String[] fields = new String[100];
        String[] data;

    try {

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
                    fields = data;
                    break;
               default:
                    relationshipsR5Data(fields,data,em,isValidate,f);
                    break;
           }

        }

        if (isValidate) {
            f.saveFile("\\docs", "R5.txt");

        }
        else{
            f.saveFile("\\docs", "VR5.txt");

        }

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

    } // relationshipsR5

    public void relationshipsR5Data(String[] fields,String[] data,EntityManager em,Boolean isValidate,FileTxt f) {

        String from = data[0];
        String fromProperty = data[1];
        String fromValue = data[2];
        String to = data[3];
        String toProperty = data[4];
        String toValue = data[5];
        String name = data[6];
        String cardinalities = data[7];

        FindBean findBean = new FindBean();

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
            } // books

            if (toProperty.equals("name")){
                booksTo = findBean.nameBooks(toValue,em);
                f.line("to:"+toValue+":"+booksTo.getName());
            } // books

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                booksTo.setBooksTypes(booksTypesFrom);
            }

            if (!isValidate) {
                em.merge(booksTo);
                em.flush();
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
            } // booksTypes

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                booksTypesTo.setObjPadre(booksTypesFrom);
            }

            if (!isValidate) {
                em.merge(booksTypesTo);
                em.flush();
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
            } // chapters

            if (toProperty.equals("name")){
                chaptersTo = findBean.nameChapters(toValue,em);
                f.line("to:"+toValue+":"+chaptersTo.getName());
            } // chapters

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chaptersTo.setBooks(booksFrom);
            }

            if (!isValidate) {
                em.merge(chaptersTo);
                em.flush();
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
            } // chapters

            if (toProperty.equals("name")){
                chaptersTo = findBean.nameChapters(toValue,em);
                f.line("to:"+toValue+":"+chaptersTo.getName());
            } // chapters

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                chaptersTo.setObjPadre(chaptersFrom);
            }

            if (!isValidate) {
                em.merge(chaptersTo);
                em.flush();
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
            } // films

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                filmsTo.setTypesFilms(typesFilmsFrom);
            }

            if (!isValidate) {
                em.merge(filmsTo);
                em.flush();
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
            } // videos

            if (toProperty.equals("time")){
                videosTo = findBean.timeVideos(toValue,em);
                f.line("to:"+toValue+":"+videosTo.getTime());
            } // videos

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                videosTo.setFilms(filmsFrom);
            }

            if (!isValidate) {
                em.merge(videosTo);
                em.flush();
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
            } // videoContents

            if (toProperty.equals("startTime")){
                videoContentsTo = findBean.startTimeVideoContents(toValue,em);
                f.line("to:"+toValue+":"+videoContentsTo.getStartTime());
            } // videoContents

            if (toProperty.equals("endTime")){
                videoContentsTo = findBean.endTimeVideoContents(toValue,em);
                f.line("to:"+toValue+":"+videoContentsTo.getEndTime());
            } // videoContents

            if (cardinalities.equals("Uno a Muchos Bidirecccional No.5")){
                videoContentsTo.setVideos(videosFrom);
            }

            if (!isValidate) {
                em.merge(videoContentsTo);
                em.flush();
            }

        } // from: Videos

    } // relationshipsR5Data

    public void relationshipsR7(String filePath,EntityManager em,Boolean isValidate,FileTxt f) {

        BufferedReader br = null;

        Integer i = 0;
        Integer j = 0;
        String line = "";
        String cvsSplitBy = null;
        String[] fields = new String[100];
        String[] data;

        String ant = "";
        String actual = "";
        String anterior = "";
        Boolean isCambio = false;

        String from = "";
        String fromProperty = "";
        String fromValue = "";
        String to = "";
        String toProperty = "";
        String toValue = "";
        String name = "";
        String cardinalities = "";

        FindBean findBean = new FindBean();

    try{

        anterior = "";

        Books books = new Books();
        Films films = new Films();
        Chapters chapters = new Chapters();
        VideoContents videoContents = new VideoContents();

        Set<Films> filmss = new HashSet<Films>();
        Set<VideoContents> videoContentss = new HashSet<VideoContents>();

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

           i++;
           if (i==1){
               data = line.split("");
               cvsSplitBy = data[data.length-1];
               continue;
           }

           data = line.split(cvsSplitBy);

           from = data[0];
           fromProperty = data[1];
           fromValue = data[2];
           to = data[3];
           toProperty = data[4];
           toValue = data[5];
           name = data[6];
           cardinalities = data[7];

           f.line(Integer.toString(i)+"=From:"+from+"\n"+
                                      " FromProperty:"+fromProperty+"\n"+
                                      " FromValue:"+fromValue+"\n"+
                                      " To:"+to+"\n"+
                                      " ToProperty:"+toProperty+"\n"+
                                      " ToValue:"+toValue+"\n"+
                                      " Name:"+name+"\n"+
                                      " Cardinalities:"+cardinalities);

           if(cardinalities.equals("Cardinalities")){
              continue; // Descarta el segundo registro
           }

           if(i==3){
              anterior = fromValue;
           }

           actual = fromValue;
           if (actual.equals(anterior)){
               isCambio = false;
           }
           else {
               isCambio = true;
               ant = anterior;
               anterior = actual;
           }

           if (from.equals("Books") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("Films") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (filmss.size() > 0){

                      if (fromProperty.equals("code")){
                          books = findBean.codeBooks(ant,em);
                          books.setFilms(filmss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(books.getId())+" code="+books.getCode());

                      } // books

                      if (fromProperty.equals("name")){
                          books = findBean.nameBooks(ant,em);
                          books.setFilms(filmss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(books.getId())+" name="+books.getName());

                      } // books

                      if (!isValidate) {

                          em.merge(books);
                          em.flush();

                      }

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(Films filmsx : filmss){
                              f.line("id="+String.valueOf(filmsx.getId())+" name="+filmsx.getName());
                          }

                          f.line("===========");
                      } // books

                  } // size()

                  filmss = new HashSet<Films>();
                  films = new Films();

               } // isCambio 

              if (toProperty.equals("name")){
                  films = findBean.nameFilms(toValue,em);
              } // films

              filmss.add(films);

           } // from: Books

           if (from.equals("Chapters") &&
               cardinalities.equals("Muchos a Muchos Bidirecccional No.7") &&
               to.equals("VideoContents") &&
               Utils.isEmpty(name)){

               if (isCambio){

                  f.line("cambio:"+ant);

                  if (videoContentss.size() > 0){

                      if (fromProperty.equals("code")){
                          chapters = findBean.codeChapters(ant,em);
                          chapters.setVideoContents(videoContentss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(chapters.getId())+" code="+chapters.getCode());

                      } // chapters

                      if (fromProperty.equals("name")){
                          chapters = findBean.nameChapters(ant,em);
                          chapters.setVideoContents(videoContentss);
                          f.line("No."+Integer.toString(i)+" id="+String.valueOf(chapters.getId())+" name="+chapters.getName());

                      } // chapters

                      if (!isValidate) {

                          em.merge(chapters);
                          em.flush();

                      }

                      if (fromProperty.equals("name")){
                          j = 0;
                          for(VideoContents videoContentsx : videoContentss){
                              f.line("id="+String.valueOf(videoContentsx.getId())+" name="+videoContentsx.getName());
                          }

                          f.line("===========");
                      } // chapters

                      if (fromProperty.equals("startTime")){
                          j = 0;
                          for(VideoContents videoContentsx : videoContentss){
                              f.line("id="+String.valueOf(videoContentsx.getId())+" startTime="+videoContentsx.getStartTime());
                          }

                          f.line("===========");
                      } // chapters

                      if (fromProperty.equals("endTime")){
                          j = 0;
                          for(VideoContents videoContentsx : videoContentss){
                              f.line("id="+String.valueOf(videoContentsx.getId())+" endTime="+videoContentsx.getEndTime());
                          }

                          f.line("===========");
                      } // chapters

                  } // size()

                  videoContentss = new HashSet<VideoContents>();
                  videoContents = new VideoContents();

               } // isCambio 

              if (toProperty.equals("name")){
                  videoContents = findBean.nameVideoContents(toValue,em);
              } // videoContents

              if (toProperty.equals("startTime")){
                  videoContents = findBean.startTimeVideoContents(toValue,em);
              } // videoContents

              if (toProperty.equals("endTime")){
                  videoContents = findBean.endTimeVideoContents(toValue,em);
              } // videoContents

              videoContentss.add(videoContents);

           } // from: Chapters

        } // while

        if (isValidate) {
            f.saveFile("\\docs", "VR7.txt");

        }
        else{
            f.saveFile("\\docs", "DR7.txt");

        }

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

    } // relationshipsR7
} // Class
