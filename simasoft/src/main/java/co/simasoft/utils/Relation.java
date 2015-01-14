package co.simasoft.utils;

public class Relation{

     private String to = "";
     private String from = "";
     private String multiplicity = "";
     private String cardinality = "";
     private boolean optionality = true;
     private boolean navigability = true;

     public Relation() {
     }

     public Relation(String to,String from,String multiplicity,boolean optionality,boolean navigability ) {
         this.to = to;
         this.from = from;
         this.multiplicity = multiplicity;
         this.optionality = optionality;
         this.navigability = navigability;
    }

    public String getTo(){
        return to;
    }

    public String getFrom(){
        return from;
    }

    public String getMultiplicity(){
        return multiplicity;
    }

    public String getCardinality(){
        return cardinality;
    }

    public boolean getOptionality(){
        return optionality ;
    }

    public boolean getNavigability(){
        return navigability;
    }

    public void setTo(String to){
        this.to = to;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setMultiplicity(String multiplicity){
        this.multiplicity = multiplicity;
    }

    public void setCardinality(String cardinality){
        this.cardinality = cardinality;
    }

    public void setOptionality(boolean optionality){
        this.optionality = optionality;
    }

    public void setNavigability(boolean navigability ){
        this.navigability = navigability;
    }

}