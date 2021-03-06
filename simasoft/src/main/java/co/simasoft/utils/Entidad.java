package co.simasoft.utils;

import co.simasoft.utils.*;

import java.io.*;
import java.util.*;

public class Entidad implements Comparable<Entidad> {

    private String groupIds = "";
    private String groupId = "";
    private String name = "";
    private String ref = "";
    private String fieldCreate = "";
    private String orden;

    private ArrayList<Atributos> atributos = new ArrayList<Atributos>() ;
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Entidad() {
    }

    public Entidad(String name) {
        this.name = name;
    }

    public String getGroupIds(){
        return groupIds;
    }
    public void setGroupIds(String groupIds){
        this.groupIds = groupIds;
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

    public String getFieldCreate(){
        return fieldCreate;
    }
    public void setFieldCreate(String fieldCreate){
        this.fieldCreate = fieldCreate;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getOrden() {
        return this.orden;
    }
    public void setOrden(String orden) {
        this.orden = orden;
    }

    public ArrayList<Atributos> getAtributos(){
        return atributos;
    }

    public String getViewRelation(){
        for (Atributos attribute : atributos) {
            if (attribute.getIsViewRelation()){
               return attribute.getField();
            }
        }
        return "";
    } // getViewRelation()

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

    @Override
    public int compareTo(Entidad o) {

        String a=new String(this.getGroupIds()+this.getOrden());
        String b=new String(o.getGroupIds()+o.getOrden());

        return a.compareTo(b);

    }

    public String attributeView(String attri,String type){

        String xhtml = "";
        String space = "                        ";


        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);


        switch (type) {

            case "Double":

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

                 xhtml = space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml +=space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"Pendiente\"/>\n";
                 xhtml +=space+"<h:outputText/>\n";
/*
                 xhtml +=space+"<h:outputText id=\""+entity+"Bean"+Entity+Attribute+"\" value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 xhtml +=space+"        <f:convertDateTime type=\"date\"/>\n";
                 xhtml +=space+"</h:outputText>\n";
                 xhtml +=space+"<h:outputText/>\n";
*/


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
        String atri = fieldCreate();

        String From = "";
        String from = "";

        String To = "";
        String to = "";

        String relationName = "";
        String RelationName = "";

        String atribute = "";


        From = relation.getFrom();
        from = Utils._1raMin(relation.getFrom());
        if (relation.getName() == null || relation.getName().isEmpty()){
           To = relation.getTo();
           to = Utils._1raMin(relation.getTo());
        }
        else {
           to = relation.getName();
           To = Utils._1raMay(to);
        }

        if (Utils.isEmpty(relation.getAttribute())){
            atribute = "";
        }
        else {
             atribute = "."+relation.getAttribute() ;
        }

/*
        xhtml = "\n";
        xhtml += space+"<!-- \n";
        xhtml += space+"===================\n";
        xhtml += space+relation.getNameCardinality()+"\n";
        xhtml += space+"relation.getName()="+relation.getName()+"\n";
        xhtml += space+relation.getCardinality()+"\n";
        xhtml += space+"name:"+name+"\n";
        xhtml += space+"From:"+From+"\n";
        xhtml += space+"from:"+from+"\n";
        xhtml += space+"To:"+To+"\n";
        xhtml += space+"to:"+to+"\n";
        xhtml += space+"RelationName:"+RelationName+"\n";
        xhtml += space+"relationName:"+relationName+"\n";
        xhtml += space+"atri:"+atri+"\n";
        xhtml += space+"atribute:"+atribute+"\n";
        xhtml += space+"===================\n";
        if (relation.getFrom().equals(relation.getTo())){  // Relaci�n Unitaria
            xhtml += space+"UNITARIA\n";
        }
        else {
            xhtml += space+"NO UNITARIA\n";
        }
        xhtml += space+" -->\n\n";
*/


        switch (relation.getNameCardinality()) {

            case "Uno a Uno Unidireccional No.1":

                 xhtml =  space+relation.getNameCardinality()+"\n";

                 break;

            case "Uno a Uno Bidirecccional No.2":

                 xhtml =  space+relation.getNameCardinality()+"\n";
                 break;

            case "Muchos a Uno Unidireccional No.3":

                 if (relation.getFrom().equals(relation.getTo())){  // Relaci�n Unitaria

                     xhtml  = space+"<h:outputLabel for=\""+to+"Bean"+To+"objPadre\" value=\""+To+":\"/>\n";
                     xhtml += space+"<h:link id=\""+to+"Bean"+To+"objPadre\" outcome=\"/admin/"+from+"/view\" rendered=\"#{!empty "+to+"Bean."+to+".objPadre}\" value=\"#{"+to+"Bean."+to+".objPadre"+atribute+"}\">\n";
                     xhtml += space+"         <f:param name=\"id\" value=\"#{"+to+"Bean."+to+".objPadre.id}\"/>\n";
                     xhtml += space+"</h:link>\n";
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{

                     xhtml  = space+"<h:outputLabel for=\""+from+"Bean"+From+To+"\" value=\""+To+":\"/>\n";
                     xhtml += space+"<h:link id=\""+from+"Bean"+From+To+"\" outcome=\"/admin/"+to+"/view\" rendered=\"#{!empty "+from+"Bean."+from+"."+to+"}\" value=\"#{"+from+"Bean."+from+"."+to+atribute+"}\">\n";
                     xhtml += space+"         <f:param name=\"id\" value=\"#{"+from+"Bean."+from+"."+to+".id}\"/>\n";
                     xhtml += space+"</h:link>\n";
                     xhtml += space+"<h:outputText/>\n";

                 }

                 break;

            case "Uno a Muchos Unidireccional No.4":

                 xhtml =  space+relation.getNameCardinality()+"\n";

                 break;

            case "Uno a Muchos Bidirecccional No.5":

                 if (relation.getFrom().equals(relation.getTo())){  // Relaci�n Unitaria

                     xhtml +=  space+"<h:outputLabel for=\""+From+"Bean"+From+To+"\" value=\""+To+":\"/>"+"\n";
                     xhtml += space+"<h:dataTable id=\""+from+"Bean"+From+to+
                                      "\" styleClass=\"data-table\" value=\"#{forgeview:asList("+from+"Bean."+from+".objHijos)}\" var=\"_item\">"+"\n\n";
                     xhtml += columnView(relation.getEntityTo().getName(),"orden","double");

                     for (Atributos atributos : relation.getEntityTo().getAtributos()) {
                          if (atributos.getIsViewColumn() == null || atributos.getIsViewColumn()){
                                   xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());
                          }
                     } // for: relation.getEntityTo().getAtributos()

                     xhtml += space+"</h:dataTable>"+"\n";
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else {

                     xhtml +=  space+"<h:outputLabel for=\""+From+"Bean"+From+To+"\" value=\""+To+":\"/>"+"\n";
                     xhtml += space+"<h:dataTable id=\""+from+"Bean"+From+to+
                                      "\" styleClass=\"data-table\" value=\"#{forgeview:asList("+from+"Bean."+from+"."+to+")}\" var=\"_item\">"+"\n\n";
                     xhtml += columnView(relation.getEntityTo().getName(),"orden","double");

                     for (Atributos atributos : relation.getEntityTo().getAtributos()) {
                          if (atributos.getIsViewColumn() == null || atributos.getIsViewColumn()){
                                   xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());
                          }
                     } // for: relation.getEntityTo().getAtributos()

                     xhtml += space+"</h:dataTable>"+"\n";
                     xhtml += space+"<h:outputText/>\n";

                 }
                 break;

            case "Muchos a Muchos Unidireccional No.6":

                 xhtml =  space+relation.getNameCardinality()+"\n";

                 break;

            case "Muchos a Muchos Bidirecccional No.7":

                 if (getName().equals(From)){

                     xhtml +=  space+"<h:outputLabel for=\""+from+"Bean"+From+To+"\" value=\""+To+":\"/>"+"\n";
                     xhtml += space+"<h:dataTable id=\""+from+"Bean"+From+to+
                                                  "\" styleClass=\"data-table\" value=\"#{forgeview:asList("+from+"Bean."+from+"."+to+")}\" var=\"_item\">"+"\n\n";

                     xhtml += columnView(relation.getEntityTo().getName(),"orden","double");

                     for (Atributos atributos : relation.getEntityTo().getAtributos()) {
                         if (atributos.getIsViewColumn() == null || atributos.getIsViewColumn()){
                             xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());
                         }
                     } // for: relation.getEntityTo().getAtributos()

                     xhtml += space+"</h:dataTable>"+"\n";
                     xhtml += space+"<h:outputText/>\n";

                 }
                 else{

                     xhtml +=  space+"<h:outputLabel for=\""+to+"Bean"+To+From+"\" value=\""+From+":\"/>"+"\n";

                     xhtml += space+"<h:dataTable id=\""+to+"Bean"+To+From+
                                                  "\" styleClass=\"data-table\" value=\"#{forgeview:asList("+to+"Bean."+to+"."+from+")}\" var=\"_item\">"+"\n\n";

                     xhtml += columnView(relation.getEntityFrom().getName(),"orden","double");

                     for (Atributos atributos : relation.getEntityFrom().getAtributos()) {
                         if (atributos.getIsViewColumn() == null || atributos.getIsViewColumn()){
                             xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());
                         }
                     } // for: relation.getEntityTo().getAtributos()

                     xhtml += space+"</h:dataTable>"+"\n";
                     xhtml += space+"<h:outputText/>\n";

                 }

                 break;


            default:
                 break;

        } // switch


        return xhtml;

    } // relationView

    public String columnView(String to,String attri,String type){

        String xhtml = "";
        String space = "                                      ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);

        switch (type) {

            case "Double":

                 xhtml = space+"     <h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"     </h:column>\n\n";
                 break;

            case "String":

                 xhtml = space+"     <h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"     </h:column>\n\n";
                 break;

            case "Text":

                 break;

            case "Integer":

                 xhtml = space+"     <h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"     </h:column>\n\n";
                 break;


            case "Date":

                 xhtml = space+"     <h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"                        <f:convertDateTime type=\"date\"/>\n";
                 xhtml +=space+"               <h:outputText/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"     </h:column>\n\n";

                 break;


            case "Boolean":

                 xhtml = space+"     <h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(to)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText styleClass=\"#{_item."+attribute+" ? 'boolean-true' : 'boolean-false'}\" value=\"\"/>";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"     </h:column>\n\n";
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

            case "Double":

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
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
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
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
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
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
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
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
                 }
                 break;

            case "Date":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 if (isNullable){
                 xhtml += space+"<p:calendar id=\"developmentsBeanDevelopments"+Attribute+"\"\n";
                 xhtml += space+"            showButtonPanel=\"true\"\n";
                 xhtml += space+"            pattern=\"dd/MM/yyyy HH:mm a\"\n";
                 xhtml += space+"            value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 else{
                 xhtml += space+"<p:calendar id=\"developmentsBeanDevelopments"+Attribute+"\"\n";
                 xhtml += space+"            required=\"true\" showButtonPanel=\"true\"\n";
                 xhtml += space+"            pattern=\"dd/MM/yyyy HH:mm a\"\n";
                 xhtml += space+"            value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 }
                 xhtml += space+"</h:panelGroup>\n";
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
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
                 if (isNullable){
                     xhtml += space+"<h:outputText/>\n";
                 }
                 else{
                     xhtml += space+"<h:outputText value=\"*\"/>\n";
                 }
                 break;

            default:
                 break;

        } // switch

        return xhtml;

    }  // attributeEdit

    public String relationEdit(Relation relation){

        String xhtml = "";
        String space = "                                ";
        String atributeFrom = fieldCreate();
        String atributeTo = relation.getEntityTo().getFieldCreate();

        String From = relation.getFrom();
        String from = Utils._1raMin(relation.getFrom());

        String To = relation.getTo();
        String to = Utils._1raMin(relation.getTo());

/*
        xhtml += "\n";
        xhtml += space+"<!-- \n";
        xhtml += space+"===================\n";
        xhtml += space+relation.getCardinality()+"\n";
        xhtml += space+"From:"+From+"\n";
        xhtml += space+"from:"+from+"\n";
        xhtml += space+"To:"+To+"\n";
        xhtml += space+"to:"+to+"\n";
        xhtml += space+"atributeFrom:"+atributeFrom+"\n";
        xhtml += space+"atributeTo:"+atributeTo+"\n";
        xhtml += space+"===================\n";
        if (relation.getFrom().equals(relation.getTo())){  // Relaci�n Unitaria
           xhtml += space+"UNITARIA\n";
        }
        else {
           xhtml += space+"NO UNITARIA\n";
        }
        xhtml += space+" -->\n";
*/


        switch (relation.getCardinality()) {

            case "1..1":

//                 xhtml =  space+"<!-- "+From+" "+relation.getCardinality()+"  "+To+" -->\n";
                 break;

            case "1..*":

//                 xhtml =  space+"<!-- "+From+" "+relation.getCardinality()+"  "+To+" -->\n";
                 break;

            case "*..*":

                 if (getName().equals(From)){

                     xhtml =  space+"<h:outputLabel for=\""+from+"Bean"+from+To+"\" value=\""+To+":\"/>"+"\n";
                     xhtml += space+"<h:panelGroup>\n";
                     xhtml += space+"        <ui:param name=\"_collection\" value=\"#{"+from+"Bean."+from+"."+to+"}\"/>\n";
                     xhtml += space+"        <h:dataTable id=\""+from+"Bean"+From+To+"\" styleClass=\"data-table\" value=\"#{forgeview:asList(_collection)}\" var=\"_item\">\n";

                     for (Atributos atributos : relation.getEntityTo().getAtributos()) {
                         if (atributos.getIsViewColumn() == null || atributos.getIsViewColumn()){
                            xhtml += columnView(relation.getEntityTo().getName(),atributos.getField(),atributos.getType());
                         }
                     } // for: relation.getEntityTo().getAtributos()

                     xhtml += space+"     <h:column footerClass=\"remove-column\" headerClass=\"remove-column\">\n";
                     xhtml += space+"        <h:commandLink action=\"#{_collection.remove(_item)}\" styleClass=\"remove-button\"/>\n";
                     xhtml += space+"     </h:column>\n";

                     xhtml += space+"        </h:dataTable>\n\n";

                     xhtml += space+"        <h:panelGrid columnClasses=\",remove-column\" columns=\"2\" styleClass=\"data-table-footer\">\n";
                     xhtml += space+"           <h:selectOneMenu converter=\"#{"+to+"Bean.converter}\" id=\""+from+"Bean"+From+To+"Select\" value=\"#{requestScope['"+from+"Bean"+From+To+"Select']}\">\n";
                     xhtml += space+"             <f:selectItem/>\n";
                     if (atributeTo.isEmpty()){
                     xhtml += space+"             <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                     }
                     else{
                     xhtml += space+"             <f:selectItems itemLabel=\"#{forgeview:display(_item."+atributeTo+")}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                     }
                     xhtml += space+"           </h:selectOneMenu>\n";
                     xhtml += space+"           <h:commandLink action=\"#{_collection.add(requestScope['"+from+"Bean"+From+To+"Select'])}\" id=\""+from+"Bean"+From+To+"Add\" onclick=\"if (document.getElementById(document.forms[0].id+':"+from+"Bean"+From+To+"Select').selectedIndex &lt; 1) { alert('Must select a "+To+"'); return false; }\" styleClass=\"add-button\"/>\n";
                     xhtml += space+"        </h:panelGrid>\n";

                     xhtml += space+"</h:panelGroup>\n";
                     xhtml += space+"<h:outputText/>\n";

                 }
                 else {
//                      xhtml =  space+"<!-- "+From+" "+relation.getCardinality()+"  "+To+" -->\n";
                 }
                 break;

            case "*..1":

                 if (getName().equals(To)){ // relaci�n Unitaria

                     xhtml =  space+"<h:outputLabel for=\""+from+"Bean"+from+"objPadre\" value=\""+To+":\"/>"+"\n";
                     xhtml += space+"<h:panelGroup>\n";
                     xhtml += space+"         <h:selectOneMenu converter=\"#{"+to+"Bean.converter}\" id=\""+from+"Bean"+From+"objPadre\" value=\"#{"+from+"Bean."+from+".objPadre}\">\n";
                     xhtml += space+"                <f:selectItem/>\n";
                     if (atributeFrom.isEmpty()){
                     xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                     }
                     else{
                     xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item."+atributeFrom+")}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                     }
                     xhtml += space+"        </h:selectOneMenu>\n";
                     xhtml += space+"        <h:message for=\"entitiesBeanEntitiesIsSimplified\" styleClass=\"error\"/>\n";
                     xhtml += space+"</h:panelGroup>\n";
                     xhtml += space+"<h:outputText/>\n";

                 }
                 else{ // relaci�n inversa.



                      if (relation.getName() == null || relation.getName().isEmpty()){
                          xhtml =  space+"<h:outputLabel for=\""+from+"Bean"+From+To+"\" value=\""+To+":\"/>"+"\n";
                          xhtml += space+"<h:panelGroup>\n";
                          xhtml += space+"         <h:selectOneMenu converter=\"#{"+to+"Bean.converter}\" id=\""+from+"Bean"+From+To+"\" value=\"#{"+from+"Bean."+from+"."+to+"}\">\n";
                          xhtml += space+"                <f:selectItem/>\n";
                          if (atributeTo.isEmpty()){
                          xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                          }
                          else{
                          xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item."+atributeTo+")}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                          }
                          xhtml += space+"        </h:selectOneMenu>\n";
                          xhtml += space+"        <h:message for=\""+from+"Bean"+From+"\" styleClass=\"error\"/>\n";
                          xhtml += space+"</h:panelGroup>\n";
                          xhtml += space+"<h:outputText/>\n";
                      }
                      else{
                          xhtml =  space+"<h:outputLabel for=\""+from+"Bean"+From+Utils._1raMay(relation.getName())+"\" value=\""+Utils._1raMay(relation.getName())+":\"/>"+"\n";
                          xhtml += space+"<h:panelGroup>\n";
                          xhtml += space+"         <h:selectOneMenu converter=\"#{"+to+"Bean.converter}\" id=\""+from+"Bean"+from+Utils._1raMay(relation.getName())+"\" value=\"#{"+from+"Bean."+from+"."+relation.getName()+"}\">\n";
                          xhtml += space+"                <f:selectItem/>\n";
                          if (atributeFrom.isEmpty()){
                          xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item)}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                          }
                          else{
                          xhtml += space+"                <f:selectItems itemLabel=\"#{forgeview:display(_item."+atributeFrom+")}\" itemValue=\"#{_item}\" value=\"#{"+to+"Bean.all}\" var=\"_item\"/>\n";
                          }
                          xhtml += space+"        </h:selectOneMenu>\n";
                          xhtml += space+"        <h:message for=\"entitiesBeanEntitiesIsSimplified\" styleClass=\"error\"/>\n";
                          xhtml += space+"</h:panelGroup>\n";
                          xhtml += space+"<h:outputText/>\n";
                      }

                 }

                 break;


/*
                 xhtml += "*..1\n";
                 xhtml += getName()+"\n";
                 xhtml += From+"\n";
                 xhtml += to+"\n";
*/

            default:
                 break;

        } // switch

        return xhtml;

    } // relationEdit

    public String attributeSearch(String attri,String type, boolean isNullable){

        String xhtml = "";
        String space = "                                                ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);


        switch (type) {

            case "Double":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"BeanExample"+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"        <h:inputText id=\""+entity+"BeanExample"+Attribute+"\" value=\"#{"+entity+"Bean.example."+attribute+"}\"/>\n";
                 xhtml += space+"        <h:message for=\""+entity+"BeanExample"+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 break;

            case "String":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"BeanExample"+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"        <h:inputText id=\""+entity+"BeanExample"+Attribute+"\" value=\"#{"+entity+"Bean.example."+attribute+"}\"/>\n";
                 xhtml += space+"        <h:message for=\""+entity+"BeanExample"+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 break;

            case "Text":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"BeanExample"+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"        <p:editor id=\""+entity+"BeanExample"+Attribute+"\" value=\"#{"+entity+"Bean.example."+attribute+"}\"/>\n";
                 xhtml += space+"        <h:message for=\""+entity+"BeanExample"+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 break;

            case "Integer":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"BeanExample"+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"        <h:inputText id=\""+entity+"BeanExample"+Attribute+"\" value=\"#{"+entity+"Bean.example."+attribute+"}\"/>\n";
                 xhtml += space+"        <h:message for=\""+entity+"BeanExample"+Attribute+"\" styleClass=\"error\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 break;

            case "Date":

                 xhtml =  "";
/*
                 xhtml =  space+"<h:outputLabel for=\""+entity+"Bean"+Entity+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"<p:calendar id=\"developmentsBeanDevelopmentsDate\"\n";
                 xhtml += space+"            showButtonPanel=\"true\"\n";
                 xhtml += space+"            pattern=\"dd/MM/yyyy HH:mm a\"\n";
                 xhtml += space+"            value=\"#{"+entity+"Bean."+entity+"."+attribute+"}\"/>\n";
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
*/
                 break;


            case "Boolean":

                 xhtml =  space+"<h:outputLabel for=\""+entity+"BeanExample"+Attribute+"\" value=\""+Attribute+":\"/>"+"\n";
                 xhtml += space+"<h:panelGroup>\n";
                 xhtml += space+"        <h:selectOneMenu id=\""+entity+"BeanExample"+Attribute+"\" value=\"#{"+entity+"Bean.example."+attribute+"}\">\n";
                 xhtml += space+"                <f:selectItem/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"Yes\" itemValue=\"true\"/>\n";
                 xhtml += space+"                <f:selectItem itemLabel=\"No\" itemValue=\"false\"/>\n";
                 xhtml += space+"        </h:selectOneMenu>\n";
                 xhtml += space+"        <h:message for=\"entitiesBeanExampleIsSimplified\" styleClass=\"error\"/>\n";
                                                          // ojo hay constante revisar
                 xhtml += space+"</h:panelGroup>\n";
                 xhtml += space+"<h:outputText/>\n";
                 break;


            default:
                 break;

        } // switch

        return xhtml;

    }  // attributeSearch

    public String columnSearch(String attri,String type){

        String xhtml = "";
        String space = "                                ";

        String attribute = attri;
        String Attribute = Utils._1raMay(attri);


        String Entity = name;
        String entity = Utils._1raMin(name);

        switch (type) {

            case "Double":

                 xhtml = space+"<h:column>\n";
                 xhtml +=space+"        <f:facet name=\"header\">\n";
                 xhtml +=space+"                <h:outputText value=\""+Attribute+"\"/>\n";
                 xhtml +=space+"        </f:facet>\n";
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(entity)+"/view\">\n";
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
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(entity)+"/view\">\n";
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
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(entity)+"/view\">\n";
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
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(entity)+"/view\">\n";
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
                 xhtml +=space+"        <h:link outcome=\"/admin/"+Utils._1raMin(entity)+"/view\">\n";
                 xhtml +=space+"                <f:param name=\"id\" value=\"#{_item.id}\"/>\n";
                 xhtml +=space+"                <h:outputText id=\"item"+Attribute+"\" value=\"#{_item."+attribute+"}\"/>\n";
                 xhtml +=space+"        </h:link>\n";
                 xhtml +=space+"</h:column>\n\n";
                 break;

            default:
                 break;

        } // switch


        return xhtml;

    }  // columnSearch

    public String fieldCreate(){

        String field = "";
        for (Atributos atributo :atributos) {
            if (atributo.getIsCreate()){
               field = atributo.getField();
               return field;
            }
        }
        return field;

    } // fieldCreate()

    public String fieldViewRelation(){

        String field = "";
        for (Atributos atributo :atributos) {
            if (atributo.getIsViewRelation()){
               field = atributo.getField();
               return field;
            }
        }
        return field;

    } // fieldViewRelation()



} // Entidad