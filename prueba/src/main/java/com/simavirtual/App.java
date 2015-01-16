package com.simavirtual;

import co.simasoft.utils.*;
import co.simasoft.utils.PowerDesigner;

import java.io.*;
import java.util.*;


public class App{

    public static void main( String[] args )   throws IOException {

        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        ArrayList<Atributos> atributos = new ArrayList<Atributos>();

//        ArrayList<Relation> relations = new ArrayList<Relation>();
        Set<Relation> relations = new HashSet<Relation>(0);

        PowerDesigner powerDesigner = new PowerDesigner("/dev/njava/modelos/uml/contab/contab.oob");
        entidades = powerDesigner.getEntidades();
        relations = powerDesigner.getRelations();

System.out.println("*RELATIONS:*"+relations.size());
System.out.println("[options=\"header\"]");
System.out.println("|===");
System.out.println("|From      |Cardinality               |To       |Optionality  |Navigability ");

          for(Relation relation : relations) {
System.out.println("|"+relation.getFrom()+"|"+relation.getCardinality()+"|"+relation.getTo()+"|"+relation.getOptionality()+"|"+relation.getNavigability());
          } // for Relation
System.out.println("|===");



        for(Relation relation : relations) {
           System.out.println("-------------");
           System.out.println("Relation     :"+relation.getFrom()+":"+relation.getCardinality()+":"+relation.getTo());

//           System.out.println("           to:"+relation.getTo());
//           System.out.println("         from:"+relation.getFrom());
//           System.out.println("            A:"+relation.getMultiplicityA());
//           System.out.println("            B:"+relation.getMultiplicityB());
//           System.out.println("cardinality1 :"+relation.getCardinalityA());
//           System.out.println("cardinality2 :"+relation.getCardinalityB());
//           System.out.println("cardinality  :"+relation.getCardinality());
//           System.out.println("OptionalityA :"+relation.getOptionalityA());
//           System.out.println("OptionalityB :"+relation.getOptionalityB());

//           System.out.println("Optionality  :"+relation.getOptionality());

//           System.out.println("NavigabilityA:"+relation.getNavigabilityA());
//           System.out.println("NavigabilityB:"+relation.getNavigabilityB());

//           System.out.println("Navigability:"+relation.getNavigability());

        } // for atributos





    } // main

} // App

