package co.simasoft.utils;

public class Atributos{

     private String field = "";
     private String description = "";
     private String type = "";
     private String length = "";
     private boolean nulo = true;
     private boolean unique = false;

     public Atributos() {
     }

     public Atributos(String field,String description,String type,String length,boolean nulo,boolean unique ) {
         this.field = field;
         this.description = description;
         this.type = type;
         this.length = length;
         this.nulo = nulo;
         this.unique = unique;
    }

    public String getField(){
        return field;
    }

    public String getDescription(){
        return description;
    }

    public String getType(){
        return type;
    }

    public String getLength(){
        return length ;
    }

    public boolean getNulo(){
        return nulo;
    }

    public boolean getUnique(){
        return unique;
    }

    public void setField(String field){
        this.field = field;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setLength(String length){
        this.length = length;
    }

    public void setNulo(boolean nulo ){
        this.nulo = nulo;
    }

    public void setUnique(boolean unique ){
        this.unique = unique;
    }

}