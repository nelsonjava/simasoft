package co.simasoft.utils;

import java.io.*;
import java.util.*;

public class Entidad {

    private String groupId = "";
    private String name = "";
    private String ref = "";

    private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Entidad() {
    }

    public Entidad(String name) {
        this.name = name;
    }

    public String getRef(){
        return ref;
    }

    public void setRef(String ref){
        this.ref = ref;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ArrayList<Atributos> getAtributos(){
        return atributos;
    }

    public String getParameters(){

        String parameters = "";
        int j = 0;

        for(int i=0;i<atributos.size();i++) {

            Atributos  atributo = atributos.get(i);
            parameters = parameters+atributo.getType()+" "+atributo.getField();

            if (++j<atributos.size()){
               parameters = parameters+",";
            }
        }
        return parameters;
    }

    public void setAtributos(ArrayList<Atributos> atributos){
        this.atributos = atributos;
    }

    public void addAtributo(Atributos atributos){
        this.atributos.add(atributos);
    }

    public ArrayList<Relation> getRelations(){
        return relations;
    }

    public void setRelations(ArrayList<Relation> relations){
        this.relations = relations;
    }

    public void addRelations(Relation relations){
        this.relations.add(relations);
    }

    public boolean isEntity() {

      if (atributos == null) {
          return false;
      }

      for (Atributos attribute : atributos) {
          if (attribute.getField().toLowerCase().equals("entity")) {
             return false;
          }
      }

      if (atributos.isEmpty()) {
          return false;
      }

      return true;
    }

    public String attributeView(String attri,String type){

        String xhtml = "";
        String space = "                        ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);


        switch (type) {

            case "double":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n"+
                         space+"<h:outputText/>\n";
                 break;

            case "String":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n"+
                         space+"<h:outputText/>\n";
                 break;

            case "Text":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\" escape=\"false\" />\n"+
                         space+"<h:outputText/>\n";
                 break;

            case "Integer":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n"+
                         space+"<h:outputText/>\n";
                 break;


            case "Date":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n"+
                         space+"  <f:convertDateTime type=\"date\"/>"+
                         space+"<h:outputText/>\n";
                 break;


            case "Boolean":

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n"+
                         space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n"+
                         space+"<h:outputText/>\n";

                 break;

            default:
                 break;

        } // switch

        return xhtml;

    }  // attributeView


    public String relationView(Relation relation ){

        String xhtml = "";
        String space = "                        ";

        String From = relation.getFrom();
        String from = Utils._1raMin(relation.getFrom());

        String To = relation.getTo();
        String to = Utils._1raMin(relation.getTo());


/*
        xhtml += space+relation.getEntityTo().getName()+":"+atributos.getField()+"\n";
        xhtml += relation.getFrom()+" "+relation.getCardinality()+" "+relation.getTo()+"\n";
        xhtml += relation.getEntityTo().getName()+"\n";
*/



        xhtml =  space+"<h:outputLabel for=\"entitiesBeanEntities"+To+"\" value=\""+To+":\"/>"+"\n";
        xhtml += space+"<h:dataTable id=\"entitiesBeanEntities"+to+
                                 "\" styleClass=\"data-table\" value=\"#{forgeview:asList(entitiesBean.entities."+to+")}\" var=\"_item\">"+"\n\n";

        xhtml += columnView(relation.getEntityTo().getName(),"orden","double");

        for (Atributos atributos : relation.getEntityTo().getAtributos()) {

            xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());

        } // for: relation.getEntityTo().getAtributos()

        xhtml += space+"</hh:dataTable>"+"\n";
        xhtml += space+"<h:outputText/>\n";

        return xhtml;

    } // relationView

    public String columnView(String to,String attri,String type){

        String xhtml = "";
        String space = "                                ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);

        switch (type) {

            case "double":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";
                 break;

            case "String":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";
                 break;

            case "Text":

                 break;

            case "Integer":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";
                 break;


            case "Date":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"                        <f:convertDateTime type=\"date\"/>\n";
                 xhtml +=space+"               <h:outputText/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";

                 break;


            case "Boolean":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";
                 break;

            default:
                 break;

        } // switch


        return xhtml;

    }  // attributeView

    public String attributeEdit(String attri,String type, boolean isNullable){

        String xhtml = "";
        String space = "                                ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);


        switch (type) {

            case "double":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" required=\"true\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"        <h:message for=\""+entity+"Bean"+Entity+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;

            case "String":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" required=\"true\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"        <h:message for=\""+entity+"Bean"+Entity+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;

            case "Text":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"        <p:editor id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"        <p:editor id=\""+entity+"Bean"+Entity+Attribute+"\" required=\"true\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"        <h:message for=\""+entity+"Bean"+Entity+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;

            case "Integer":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"        <h:inputText id=\""+entity+"Bean"+Entity+Attribute+"\" required=\"true\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"        <h:message for=\""+entity+"Bean"+Entity+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;

            case "Date":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"<p:calendar id=\"developmentsBeanDevelopmentsDate\"\n";
                 xhtml += space+"            showButtonPanel=\"true\"\n";
                 xhtml += space+"            pattern=\"dd/MM/yyyy HH:mm a\"\n";
                 xhtml += space+"            value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"<p:calendar id=\"developmentsBeanDevelopmentsDate\"\n";
                 xhtml += space+"            required=\"true\" showButtonPanel=\"true\"\n";
                 xhtml += space+"            pattern=\"dd/MM/yyyy HH:mm a\"\n";
                 xhtml += space+"            value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;


            case "Boolean":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"        <h:selectOneMenu id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\">\n";
                 xhtml += space+"                <f:selectItem/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"Yes\" itemValue=\"true\"/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"No\" itemValue=\"false\"/>\n";
                 xhtml += space+"        </h:selectOneMenu>\n";
                 }
                 else{
                 xhtml += space+"        <h:selectOneMenu id=\""+entity+"Bean"+Entity+Attribute+"\" required=\"true\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\">\n";
                 xhtml += space+"                <f:selectItem/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"Yes\" itemValue=\"true\"/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"No\" itemValue=\"false\"/>\n";
                 xhtml += space+"        </h:selectOneMenu>\n";
                 }
                 xhtml += space+"        <h:message for=\"entitiesBeanEntitiesIsSimplified\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>";
                 }
                 break;

            default:
                 break;

        } // switch

        return xhtml;

    }  // attributeView



} // Entidad