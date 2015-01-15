package co.simasoft.utils;

import java.io.*;
import java.lang.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class PowerDesigner {

    private static String fileOob;
    private static ArrayList<Entidad> entidades = new ArrayList<Entidad>();
    private static ArrayList<Relation> relationsPower = new ArrayList<Relation>();
    private static ArrayList<Relation> relations = new ArrayList<Relation>();

    public PowerDesigner(String fileOob) throws IOException {
        this.fileOob = fileOob;
        generar();
        relationsPower();
        relations();
    }

    public static void generar() throws IOException {

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

                ArrayList<Atributos> atr = new ArrayList<Atributos>();

                Node nNode = nList.item(i);
                NodeList etiquetas = nNode.getChildNodes();

                Entidad entidad = new Entidad();
                if (nNode.getNodeName().equals("o:Class")) {
                    Element e = (Element)nNode;
                    if (!e.getAttribute("Id").equals("")) {
                       entidad.setRef(e.getAttribute("Id"));
                    }
                }

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
                         relation.setMultiplicityA(rela.getTextContent());
                      }

                      if (rela.getNodeName().equals("a:RoleBMultiplicity")) {
                         relation.setMultiplicityB(rela.getTextContent());
                      }

                      if (rela.getNodeName().equals("a:RoleANavigability")) {
                         if(rela.getTextContent().equals("1")){
                           relation.setNavigabilityA(true);
                         }
                         else{
                           relation.setNavigabilityA(false);
                         }
                      }

                      if (rela.getNodeName().equals("a:RoleBNavigability")) {
                         if(rela.getTextContent().equals("1")){
                           relation.setNavigabilityB(true);
                         }
                         else{
                           relation.setNavigabilityB(false);
                         }
                      }

                      if (rela.getNodeName().equals("c:Object1")) {
                         NodeList aRefsTo = rela.getChildNodes();
                         for (int zz = 0; zz < aRefsTo.getLength(); zz++) {
                             Node aRefTo = aRefsTo.item(zz);
                             if (aRefTo.getNodeName().equals("o:Class")) {
                                relation.setRefTo(aRefTo.getAttributes().getNamedItem("Ref").getNodeValue());
                             }
                         }
                      }

                      if (rela.getNodeName().equals("c:Object2")) {
                         NodeList aRefsFrom = rela.getChildNodes();
                         for (int zz = 0; zz < aRefsFrom.getLength(); zz++) {
                             Node aRefFrom = aRefsFrom.item(zz);
                             if (aRefFrom.getNodeName().equals("o:Class")) {
                                relation.setRefFrom(aRefFrom.getAttributes().getNamedItem("Ref").getNodeValue());
                             }
                         }
                      }

                  }


                  if (!relation.getTo().equals("")) {

                      relation.setNavigabilityFrom();
                      relationsPower.add(relation);
                  }


              } // if o:Association


            } // for nAssocs


        } // try
        catch (Exception e) {
	  e.printStackTrace();
        }

    } // Generar

    public ArrayList<Entidad> getEntidades(){
        return entidades;
    }

    public ArrayList<Relation> getRelations(){
        return relations;
    }
    
    public ArrayList<Relation> getRelationsPower(){
        return relationsPower;
    }

    public String getEntityName(String ref){

       for (Entidad entidad : entidades) {
            if (entidad.getRef().equals(ref)) {
                return entidad.getName();
            }
       }
       return "";
    }

    public void relationsPower(){
        for (Relation relation : relationsPower) {
            relation.setTo(getEntityName(relation.getRefTo()));
            relation.setFrom(getEntityName(relation.getRefFrom()));
        }
    }

    public void relations(){

        for (Relation relationPower : relationsPower) {

            Relation relaTo = new Relation();
            Relation relaFrom = new Relation();

/*
            System.out.println("PASO1");
            System.out.println(relationPower.getTo());
            System.out.println(relationPower.getFrom());
*/

            relaTo.setTo(relationPower.getTo());
            relaTo.setFrom(relationPower.getFrom());

/*
            System.out.println("PASO2");
            System.out.println(relaTo.getTo());
            System.out.println(relaTo.getFrom());
*/            



            relations.add(relaTo);

            relaFrom.setTo(relationPower.getFrom());
            relaFrom.setFrom(relationPower.getTo());
            relations.add(relaFrom);

        }
    }




} // PowerDesigner