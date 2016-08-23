package co.simasoft;

import java.io.*;
import java.lang.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class App{

    public static void main( String[] args ) throws IOException {
        try{

            System.out.println( "Hello World!" );

            File fXmlFile = new File("\\docs\\itemsModels.oom");
            
            System.out.println( "Paso" );

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            System.out.println( "Paso" );

/*
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document xml = dBuilder.parse(fXmlFile);

            xml.getDocumentElement().normalize();

            NodeList nList = xml.getElementsByTagName("o:Class");

            NodeList nAssocs = xml.getElementsByTagName("o:Association");

            for(int i=0;i<nAssocs.getLength();i++) {

              Node nAssoc = nAssocs.item(i);

              NodeList aRelations = nAssoc.getChildNodes();

              if (nAssoc.getNodeName().equals("o:Association")) {

                  NodeList relas = nAssoc.getChildNodes();

                  for (int z = 0; z < relas.getLength(); z++) {

                      Node rela = relas.item(z);

                      if (rela.getNodeName().equals("a:Name")) {
                         System.out.println( rela.getTextContent() );
                      }


                  }



              }


            }
*/


        } // try

        catch (Exception e) {
	  e.printStackTrace();
        }



//        generar();

    } // main

    public static void generar() throws IOException {

        try{

            File fXmlFile = new File("\\docs\\itemsModels.oom");
            System.out.println( "Hola111!" );

        } // try

        catch (Exception e) {
	  e.printStackTrace();
        }

    } // Generar


} // App
