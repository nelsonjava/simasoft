package com.simavirtual;

import co.simasoft.utils.*;
import co.simasoft.utils.PowerDesigner;

import java.io.*;
import java.util.*;


public class App{

    public static void main( String[] args )   throws IOException {

        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        ArrayList<Atributos> atributos = new ArrayList<Atributos>();
        ArrayList<Relation> relations = new ArrayList<Relation>();

//        PowerDesigner powerDesigner = new PowerDesigner("/dev/njava/simasoft/prueba/src/resources/contab1.oob");
        PowerDesigner powerDesigner = new PowerDesigner("/dev/njava/simasoft/prueba/src/resources/contab.oob");

        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();
//        relations = powerDesigner.getRelationsPower();

//        entidades = Prueba("/dev/njava/simasoft/prueba/src/resources/contab1.oob");

/*
        for(int i=0;i<entidades.size();i++) {

          Entidad entidad = entidades.get(i);
          System.out.println(entidad.getName()+":"+entidad.getRef());
          System.out.println(powerDesigner.getEntityName(entidad.getRef()));

          atributos = entidad.getAtributos();

          for(Atributos atributo : atributos) {
              System.out.println("------");
              System.out.println("    campo:"+atributo.getField());
              System.out.println("    unico:"+atributo.getUnique());
              System.out.println("    tipo:"+atributo.getType());
              System.out.println("    nulo:"+atributo.getLength());
              System.out.println("    len:"+atributo.getNulo());

          } // for atributos

        } // for entidades

*/


        for(Relation relation : relations) {
           System.out.println("-------------");
           System.out.println("Relation     :"+relation.getTo()+":"+relation.getCardinality()+":"+relation.getFrom());

//           System.out.println("           to:"+relation.getTo());
//           System.out.println("         from:"+relation.getFrom());
//           System.out.println("            A:"+relation.getMultiplicityA());
//           System.out.println("            B:"+relation.getMultiplicityB());
           System.out.println("cardinality1 :"+relation.getCardinalityA());
           System.out.println("cardinality2 :"+relation.getCardinalityB());
//           System.out.println("cardinality  :"+relation.getCardinality());
//           System.out.println("OptionalityA :"+relation.getOptionalityA());
//           System.out.println("OptionalityB :"+relation.getOptionalityB());

           System.out.println("Optionality  :"+relation.getOptionality());

//           System.out.println("NavigabilityA:"+relation.getNavigabilityA());
//           System.out.println("NavigabilityB:"+relation.getNavigabilityB());

           System.out.println("Navigability:"+relation.getNavigability());

        } // for atributos





    } // main

} // App

