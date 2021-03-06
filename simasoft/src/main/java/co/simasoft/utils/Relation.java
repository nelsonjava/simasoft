package co.simasoft.utils;

import java.io.*;
import java.lang.*;

public class Relation implements Comparable<Relation>{

    private String model = "";

    private String orden;

    private String name = "";

    private String refTo = "";
    private String refFrom = "";

    private String to = "";                 // Movimientos
    private String from = "";               // Pucs

    private String rolA = "";               // RolA = from o to
    private String rolB = "";               // RolB = from o to

    private String multiplicityA = "";      // 0..1
    private String multiplicityB = "";      // 0..*

    private String nameCardinality = "";
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

    private Entidad entityFrom = new Entidad();
    private Entidad entityTo = new Entidad();
    private String attribute = "";            // isViewRelation

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

    public Relation(String from,String to,String cardinality,String nameCardinality,String name,boolean unidireccional) {
       this.from = from;
       this.to = to;
       this.cardinality = cardinality;
       this.nameCardinality = nameCardinality;
       this.name = name;
       this.unidireccional = unidireccional;
    }
    
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }

    public String getOrden() {
        return this.orden;
    }
    public void setOrden(String orden) {
        this.orden = orden;
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

    public String getRolA(){
        return rolA;
    }
    public void setRolA(String rolA){
        this.rolA = rolA;
    }

    public String getRolB(){
        return rolB;
    }
    public void setRolB(String rolB){
        this.rolB = rolB;
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

    public String getNameCardinality(){
        return nameCardinality;
    }
    public void setNameCardinality(String nameCardinality){
        this.nameCardinality = nameCardinality;
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
    
    public Entidad getEntityFrom() {
        return entityFrom;
    }
    public void setEntityFrom(Entidad entityFrom) {
        this.entityFrom = entityFrom;
    }

    public Entidad getEntityTo() {
        return entityTo;
    }
    public void setEntityTo(Entidad entityTo) {
        this.entityTo = entityTo;
    }

    public String getAttribute(){
        return attribute;
    }
    public void setAttribute(String attribute){
        this.attribute = attribute;
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

    @Override
    public int compareTo(Relation a) {
           if (Integer.parseInt(orden) < Integer.parseInt(a.orden)) {
              return -1;
           }
           if (Integer.parseInt(orden) > Integer.parseInt(a.orden)) {
              return 1;
           }
           return 0;
    }


}