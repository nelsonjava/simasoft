package co.simasoft.utils;

public class Relation{

    private String refTo = "";
    private String refFrom = "";
    private String to = "";
    private String from = "";
    private String multiplicityA = "";
    private String multiplicityB = "";
    private String cardinality = "";
    private boolean optionality = true;
    private boolean navigabilityA = false;
    private boolean navigabilityB = false;

    public Relation() {
    }

    public String getRefTo(){
        return refTo;
    }

    public void setRefTo(String refTo){
        this.refTo = refTo;
    }

    public String getRefFrom(){
        return refFrom;
    }

    public void setRefFrom(String refFrom){
        this.refFrom = refFrom;
    }


    public String getTo(){
        return to;
    }

    public void setTo(String to){
        this.to = to;
    }

    public String getFrom(){
        return from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public String getMultiplicityA(){
        return multiplicityA;
    }

    public void setMultiplicityA(String multiplicity){
        this.multiplicityA = multiplicity;
    }

    public String getMultiplicityB(){
        return multiplicityB;
    }

    public void setMultiplicityB(String multiplicity){
        this.multiplicityB = multiplicity;
    }

    public String getCardinality(){
        return cardinality;
    }

    public void setCardinality(String cardinality){
        this.cardinality = cardinality;
    }


    public boolean getOptionality(){
        return optionality ;
    }

    public void setOptionality(boolean optionality){
        this.optionality = optionality;
    }

    public boolean getNavigabilityA(){
        return navigabilityA;
    }

    public void setNavigabilityA(boolean navigability ){
        this.navigabilityA = navigability;
    }

    public boolean getNavigabilityB(){
        return navigabilityB;
    }

    public void setNavigabilityB(boolean navigability ){
        this.navigabilityB = navigability;
    }

    public void setNavigabilityFrom(){
        if (!getNavigabilityA()){
           if(!getNavigabilityB()){
             setNavigabilityA(true);
             setNavigabilityB(true);
           }
        }
    }

}