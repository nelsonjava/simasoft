package com.simavirtual;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class App{

    public static ArrayList<Entidad> Prueba(String fileOob) throws IOException {

        ArrayList<Entidad> entidades = new ArrayList<Entidad>();

        try{

            File fXmlFile = new File(fileOob);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document xml = dBuilder.parse(fXmlFile);

            xml.getDocumentElement().normalize();
            NodeList nList = xml.getElementsByTagName("o:Class");

            String field = "";
            String type = "";
            String tipo = "";
            String len = "";
            boolean nulo = true;

	    for (int i = 0; i < nList.getLength(); i++) {

                Entidad entidad = new Entidad();
                ArrayList<Atributos> atr = new ArrayList<Atributos>();

                Node nNode = nList.item(i);
                NodeList etiquetas = nNode.getChildNodes();

                for(int j=0; j<etiquetas.getLength(); j++) {

                    Node clases = etiquetas.item(j);

                    if (clases.getNodeName().equals("a:Name")) {
                       entidad.setName(clases.getTextContent());
                    } // if clases.getNodeName()

                    if (clases.getNodeName().equals("c:Attributes")) {

                       NodeList atributos = clases.getChildNodes();

                       for (int x = 0; x < atributos.getLength(); x++) {

                            Node atributo = atributos.item(x);
                            if (atributo.getNodeName().equals("o:Attribute")) {

                               Atributos atri = new Atributos();
                               NodeList campos = atributo.getChildNodes();
                               for (int y = 0; y < campos.getLength(); y++) {

                                   Node campo = campos.item(y);
                                   field = "";
                                   if (campo.getNodeName().equals("a:Name")) {

                                      field = campo.getTextContent();
                                      atri.setField(Utils.typeField(field));
                                      atri.setDescription("Pendiente");
                                      atri.setUnique(Utils.isFieldNull(field));

                                   } // if (campo.getNodeName().equals("a:Name"))

                                   type = "";
                                   if (campo.getNodeName().equals("a:DataType")) {
                                      type = campo.getTextContent();
                                      if (atri.getField().equals(null)) {}
                                      else {
                                           atri.setType(Utils.typeField(type));
                                           atri.setLength(Utils.lenField(type));
                                           atri.setNulo(Utils.isFieldNull(type));

                                           atr.add(atri);
                                      } // else
                                   } // if (campo.getNodeName().equals("a:DataType"))



                               } // for (int y = 0; y < campos.getLength(); y++)

                               entidad.setAtributos(atr);


                            } // if (atributo.getNodeName().equals("o:Attribute"))


                       } // for atributos

                    } // if (clases.getNodeName().equals("c:Attributes"))

                } // for etiquetas

                if (entidad.getName().equals("")) {}
                else {
                      entidades.add(entidad);
                } // if (entidad.getName().equals(""))

            } // for nList

            NodeList nAssocs = xml.getElementsByTagName("o:Association");

            for(int i=0;i<nAssocs.getLength();i++) {

              Node nAssoc = nAssocs.item(i);

              NodeList aRelations = nAssoc.getChildNodes();

              Relation relation = new Relation();

              if (nAssoc.getNodeName().equals("o:Association")) {

                  NodeList relas = nAssoc.getChildNodes();

                  for (int z = 0; z < relas.getLength(); z++) {
                      Node rela = relas.item(z);


                      if (rela.getNodeName().equals("a:Name")) {
                         relation.setFrom(rela.getTextContent());
                      }

                      if (rela.getNodeName().equals("a:Code")) {
                         relation.setTo(rela.getTextContent());
                      }

                      if (rela.getNodeName().equals("a:RoleAMultiplicity")) {
                      }

                      if (rela.getNodeName().equals("a:RoleBMultiplicity")) {
                      }


                  }

                  if (!relation.getTo().equals("")) {
                      System.out.println("Relations:");
                      System.out.println("    to:"+relation.getTo());
                      System.out.println("  from:"+relation.getFrom());
                  }

              } // if



              for(int j=0;j<aRelations.getLength();j++) {

                  Node nAs = aRelations.item(i);

//                  System.out.println(nAs.getNodeName());
//                  System.out.println(nAs.getTextContent());

                  if (nAs.getNodeName().equals("a:Code")) {
//                     System.out.println(nAs.getTextContent());
                  } // if


              }


            }







        } // try
        catch (Exception e) {
	  e.printStackTrace();
        }

        return entidades;

    } // Entidades

    public static void main( String[] args )   throws IOException {

        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        ArrayList<Atributos> atributos = new ArrayList<Atributos>();

        Prueba("/dev/njava/simasoft/prueba/src/resources/contab1.oob");



        for(int i=0;i<entidades.size();i++) {

          Entidad entidad = entidades.get(i);
          System.out.println(entidad.getName());

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






    } // main

} // App

