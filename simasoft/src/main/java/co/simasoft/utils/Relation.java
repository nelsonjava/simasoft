package co.simasoft.utils;

public class Relation{

    private String name = "";

    private String refTo = "";
    private String refFrom = "";

    private String to = "";                 // Movimientos
    private String from = "";               // Pucs

    private String multiplicityA = "";      // 0..1
    private String multiplicityB = "";      // 0..*

    private String cardinality = "";
    private String cardinalityA = "";       // 1..*
    private String cardinalityB = "";       // *..1

    private boolean optionality = true;
    private boolean optionalityA = true;    // 0=true
    private boolean optionalityB = true;    // 0=true

    private boolean navigability = false;
    private boolean navigabilityA = false;
    private boolean navigabilityB = false;

    private boolean unidireccional;

    public Relation() {
    }

    public Relation(String from,String to,String cardinality,String name) {
       this.from = from;
       this.to = to;
       this.cardinality = cardinality;
       this.name = name;
    }

    public Relation(String from,String to,String cardinality,String name,boolean unidireccional) {
       this.from = from;
       this.to = to;
       this.cardinality = cardinality;
       this.name = name;
       this.unidireccional = unidireccional;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    public String getCardinalityA(){
        return cardinalityA;
    }

    public void setCardinalityA(String cardinality){
        this.cardinalityA = cardinality;
    }

    public String getCardinalityB(){
        return cardinalityB;
    }

    public void setCardinalityB(String cardinality){
        this.cardinalityB = cardinality;
    }

    public boolean getOptionality(){
        return optionality ;
    }

    public void setOptionality(boolean optionality){
        this.optionality = optionality;
    }

    public boolean getOptionalityA(){
        return optionalityA ;
    }

    public void setOptionalityA(boolean optionality){
        this.optionalityA = optionality;
    }

    public boolean getOptionalityB(){
        return optionalityB ;
    }

    public void setOptionalityB(boolean optionality){
        this.optionalityB = optionality;
    }

    public boolean getNavigability(){
        return navigability;
    }

    public void setNavigability(boolean navigability ){
        this.navigability = navigability;
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

    public boolean getUnidireccional() {
        return unidireccional;
    }
    public void setUnidireccional(boolean unidireccional) {
        this.unidireccional = unidireccional;
    }

    public void setNavigabilityFrom(){
        if (!getNavigabilityA()){
           if(!getNavigabilityB()){
             setNavigabilityA(true);
             setNavigabilityB(true);
           }
        }
    }

    public void cardinality(){
        String cardinalityA = getMultiplicityA();
        String cardinalityB = getMultiplicityB();
        setCardinalityA(cardinalityA.substring(3,4)+".."+cardinalityB.substring(3,4));
        setCardinalityB(cardinalityB.substring(3,4)+".."+cardinalityA.substring(3,4));
    }

    public void optionality(){
        String cardinalityA = getMultiplicityA();
        String cardinalityB = getMultiplicityB();

        if (cardinalityA.substring(0,1).equals("0")){
           setOptionalityA(true);
        }
        else{
           setOptionalityA(false);
        }

        if (cardinalityB.substring(0,1).equals("0")){
           setOptionalityB(true);
        }
        else{
           setOptionalityB(false);
        }

    }

}