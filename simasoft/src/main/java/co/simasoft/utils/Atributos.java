package co.simasoft.utils;

public class Atributos{

     private String field = "";
     private String description = "";
     private String type = "";
     private String length = "";
     private boolean nulo = true;
     private boolean unique = false;
     private String annotations = "";

     public Atributos() {
     }

     public Atributos(String field, String type) {
         this.field = field;
         this.type = type;
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
        return typeField(type);
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

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
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

} // Atributos