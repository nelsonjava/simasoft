package co.simasoft.utils;

import java.io.*;
import java.lang.*;

public class Atributos implements Comparable<Atributos>{

     private double orden;
     private String field = "";
     private String description = "";
     private String type = "";
     private Integer length = 0;
     private Integer precision = 0;
     private boolean nulo = true;
     private boolean unique = false;
     private String annotations = "";

     private Boolean isSimplified = false;
     private Boolean isCreate = true;
     private Boolean isSearch = false;
     private Boolean isView = false;
     private Boolean isViewColumn = false;
     private Boolean isViewRelation = false;

     public Atributos() {
     }

     public Atributos(String field, String type) {
         this.field = field;
         this.type = type;
    }

     public Atributos(String field, String type,boolean nulo) {
         this.field = field;
         this.type = type;
         this.nulo = nulo;
    }

     public Atributos(String field,String description,String type,Integer length,boolean nulo,boolean unique ) {
         this.field = field;
         this.description = description;
         this.type = type;
         this.length = length;
         this.nulo = nulo;
         this.unique = unique;
    }

    public double getOrden(){
        return orden;
    }
    public void setOrden(double orden){
        this.orden = orden;
    }

    public String getField(){
        return field;
    }
    public void setField(String field){
        this.field = field;
    }


    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getType(){
        return typeField(type);
    }

    public String getTypeDjango(){
        return typeFieldDjango(type);
    }

    public void setType(String type){
        this.type = type;
    }

    public Integer getLength(){
        return length ;
    }
    public void setLength(Integer length){
        this.length = length;
    }

    public boolean getNulo(){
        return nulo;
    }
    public void setNulo(boolean nulo ){
        this.nulo = nulo;
    }

    public boolean getUnique(){
        return unique;
    }
    public void setUnique(boolean unique ){
        this.unique = unique;
    }

    public String getAnnotations() {
        return annotations;
    }
    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public Integer getPrecision() {
        return precision;
    }
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Boolean getIsSimplified() {
        return isSimplified;
    }
    public void setIsSimplified(Boolean isSimplified) {
        this.isSimplified = isSimplified;
    }

    public Boolean getIsCreate() {
        return isCreate;
    }
    public void setIsCreate(Boolean isCreate) {
        this.isCreate = isCreate;
    }

    public Boolean getIsSearch() {
        return isSearch;
    }
    public void setIsSearch(Boolean isSearch) {
        this.isSearch = isSearch;
    }

    public Boolean getIsView() {
        return isView;
    }
    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    public Boolean getIsViewColumn() {
        return isViewColumn;
    }
    public void setIsViewColumn(Boolean isViewColumn) {
        this.isViewColumn = isViewColumn;
    }

    public Boolean getIsViewRelation() {
        return isViewRelation;
    }
    public void setIsViewRelation(Boolean isViewRelation) {
        this.isViewRelation = isViewRelation;
    }

    @Override
    public int compareTo(Atributos a) {
           if (orden < a.orden) {
              return -1;
           }
           if (orden > a.orden) {
              return 1;
           }
           return 0;
    }

    public String typeField(String type){

        String typeField = "";

        switch (type) {

            case "long":
                 typeField = "Long";
                 break;

            case "date":
                 typeField = "Date";
                 break;

            case "Datetime":
                 typeField = "Date";
                 break;

            case "number":
                 typeField = "Float";
                 break;

            case "float":
                 typeField = "Float";
                 break;

            case "boolean":
                 typeField = "Boolean";
                 break;

            case "Text":
                 typeField = "String";
//                 typeField = "Text";
                 break;

            case "Blog":
                 typeField = "String";
//                 typeField = "Blog";
                 break;

            default:
                 typeField = type;
                 break;

        } // switch

        return typeField;

    } // typeField

    public String typeFieldDjango(String type){

        String typeField = "pendiente0";

        switch (type) {

            case "long":
                 typeField = "Pendiente1";
                 break;

            case "date":
                 typeField = "DateField()";
                 break;

            case "Date":
                 typeField = "DateField()";
                 break;

            case "Datetime":
                 typeField = "DateTimeField";
                 break;

            case "Integer":
                 typeField = "IntegerField()";
                 break;

            case "number":
                 typeField = "Pendiente4";
                 break;

            case "float":
                 typeField = "DecimalField(max_digits="+String.valueOf(length)+", decimal_places="+String.valueOf(precision)+")";

            case "boolean":
                 typeField = "BooleanField()";
                 break;

            case "Boolean":
                 typeField = "BooleanField()";
                 break;

            case "String":
                 typeField = "CharField(max_length=255)";

                 break;

            case "Blog":
                 typeField = "Pendiente6";
                 break;

            default:
                 typeField = type;
                 break;

        } // switch


        return typeField;

    } // typeField

} // Atributos