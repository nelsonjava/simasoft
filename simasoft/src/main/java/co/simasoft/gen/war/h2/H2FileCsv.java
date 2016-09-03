package co.simasoft.gen.war.h2;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class H2FileCsv extends FileTxt {

    private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;

    public void data(ArrayList<Entidad> entidades) {
    try {

      Collections.sort(entidades);
      for(Entidad entidad : entidades) {
          atributos = entidad.getAtributos();
          clearFileTxt();
          Collections.sort(atributos);
          for(Atributos atributo : atributos) {
            line(atributo.getField());
          }
          saveFile("\\docs", entidad.getName()+".txt");
      }

    }
    catch(Exception ioe) {
      ioe.printStackTrace();
    }

    } // data()

} // DevelopmentsGen