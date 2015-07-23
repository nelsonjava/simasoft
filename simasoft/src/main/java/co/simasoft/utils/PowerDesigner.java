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
    private static Set<Relation> relationsPower = new HashSet<Relation>(0);
    private static Set<Relation> relations = new HashSet<Relation>(0);

    String ref = "";
    String multiplicity = "";

    public PowerDesigner(String fileOob) throws IOException {
        this.fileOob = fileOob;
        generar();
        relationsPower();
        relations();
        relationsEntities();
    }

    public static void generar() throws IOException {

        try{

            File fXmlFile = new File(fileOob);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document xml = dBuilder.parse(fXmlFile);

            xml.getDocumentElement().normalize();
            NodeList nList = xml.getElementsByTagName("o:Class");

            entidades = new ArrayList<Entidad>();
            relationsPower = new HashSet<Relation>(0);
            relations = new HashSet<Relation>(0);

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
                                      atri.setNulo(!Utils.isFieldNull(field));

                                   } // if (campo.getNodeName().equals("a:Name"))

                                   type = "";
                                   if (campo.getNodeName().equals("a:DataType")) {
                                      type = campo.getTextContent();
                                      if (atri.getField().equals(null)) {}
                                      else {
                                           atri.setType(Utils.typeField(type));
                                           atri.setLength(Utils.lenField(type));
                                           atri.setUnique(Utils.isFieldNull(type));
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
                      
                      if (rela.getNodeName().equals("a:RoleAName")) {
                         relation.setRolA(rela.getTextContent());
                      }
                      
                      if (rela.getNodeName().equals("a:RoleBName")) {
                         relation.setRolB(rela.getTextContent());
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
    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidades = entidades;
    }


    public ArrayList<Entidad> setEntidades(){
        return entidades;
    }


    public Set<Relation> getRelations(){
        return relations;
    }

    public Set<Relation> getRelationsPower(){
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

            if (relation.getMultiplicityA().substring(3,4).equals(relation.getMultiplicityB().substring(3,4))){  // 1 == 1 or * == *

/*             A  B
               1  1
               *  *
*/

               switch (relation.getMultiplicityA().substring(3,4)) {

                   case "1":
                            if (relation.getNavigabilityA()){
                            }
                            else{
                            }
                            break;

                   case "*":
                            if (relation.getNavigabilityA()){
                            }
                            else{
                            }
                            break;

                   default: relation.setFrom("Error.MultiplicityA=");
                            break;

               } // switch


            } // if

            if (!relation.getMultiplicityA().substring(3,4).equals(relation.getMultiplicityB().substring(3,4))){  // Diferente

/*             A  B
               1  *
               *  1
*/

               switch (relation.getMultiplicityA().substring(3,4)) {
                   case "1":
                            if (relation.getNavigabilityA()){
                            }
                            break;

                   case "*":

                            if (relation.getNavigabilityA()){

                                ref = relation.getRefFrom();
                                relation.setRefFrom(relation.getRefTo());
                                relation.setRefTo(ref);

                                multiplicity = relation.getMultiplicityA();
                                relation.setMultiplicityA(relation.getMultiplicityB());
                                relation.setMultiplicityB(multiplicity);

                                relation.setFrom(getEntityName(relation.getRefFrom()));
                                relation.setTo(getEntityName(relation.getRefTo()));

                            }
                            break;

                   default: relation.setFrom("Error.MultiplicityA");
                     break;
               } // switch
            } // if

            else{

/*             B  A
               1  *
               *  1
*/

               switch (relation.getMultiplicityB().substring(3,4)) {
                   case "1":
                            if (relation.getNavigabilityB()){
                            }
                            break;

                   case "*":
                            if (relation.getNavigabilityA()){
                            }
                            break;

                   default: relation.setFrom("Error.MultiplicityB");
                     break;
               } // switch

            } // else

            relation.setFrom(getEntityName(relation.getRefFrom()));
            relation.setTo(getEntityName(relation.getRefTo()));
            relation.setName(relation.getFrom()+"("+relation.getMultiplicityA()+")"+" TO "+relation.getTo()+"("+relation.getMultiplicityB()+")");
            relation.cardinality();
            relation.optionality();

        } // for

    } // relationsPower

    public void relations(){

        for (Relation relationPower : relationsPower) {

            Relation relaTo = new Relation();
            Relation relaFrom = new Relation();

            relaFrom.setFrom(relationPower.getFrom());
            relaFrom.setTo(relationPower.getTo());

            relaFrom.setMultiplicityA(relationPower.getMultiplicityA());
            relaFrom.setMultiplicityB(relationPower.getMultiplicityB());

            relaFrom.setCardinalityA(relationPower.getCardinalityA());
            relaFrom.setCardinalityB(relationPower.getCardinalityB());
            relaFrom.setCardinality(relationPower.getCardinalityA());

            relaFrom.setOptionalityA(relationPower.getOptionalityA());
            relaFrom.setOptionalityB(relationPower.getOptionalityB());
            relaFrom.setOptionality(relationPower.getOptionalityA());

            relaFrom.setNavigabilityA(relationPower.getNavigabilityA());
            relaFrom.setNavigabilityB(relationPower.getNavigabilityB());
            relaFrom.setNavigability(relationPower.getNavigabilityA());

            relations.add(relaFrom);

            relaTo.setFrom(relationPower.getTo());
            relaTo.setTo(relationPower.getFrom());

            relaTo.setMultiplicityA(relationPower.getMultiplicityB());
            relaTo.setMultiplicityB(relationPower.getMultiplicityA());

            relaTo.setCardinalityA(relationPower.getCardinalityB());
            relaTo.setCardinalityB(relationPower.getCardinalityA());
            relaTo.setCardinality(relationPower.getCardinalityB());

            relaTo.setOptionalityA(relationPower.getOptionalityB());
            relaTo.setOptionalityB(relationPower.getOptionalityA());
            relaTo.setOptionality(relationPower.getOptionalityB());

            relaTo.setNavigabilityA(relationPower.getNavigabilityB());
            relaTo.setNavigabilityB(relationPower.getNavigabilityA());
            relaTo.setNavigability(relationPower.getNavigabilityB());

            relations.add(relaTo);

        } // for relationPower

    } // relations

    public Entidad getEntity(String entityName){

       Entidad entity = new Entidad();
       for (Entidad entidad : entidades) {

            if (entidad.getName().equals(entityName)) {
                entity = entidad;
                break;
            }

       }
       return entity;
    }

    public void relationsEntities(){

        for (Relation relation : relations) {

             Entidad entity = getEntity(relation.getFrom());
             if (!entity.getName().isEmpty()) {
                entity.addRelations(relation);
             }

        }

    } // relationsEntities


} // PowerDesigner