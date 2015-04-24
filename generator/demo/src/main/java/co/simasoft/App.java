package co.simasoft;

/**
 * Hello world!
 *
*/

import java.util.Random;

public class App{

    public static void main( String[] args ){
        Random rnd = new Random();
        System.out.println( "Hello World!" );


        Double d = rnd.nextDouble();
        //System.out.println(d);

        String t = Double.toString(d);
        String t2 = t.substring(2,t.length());

        System.out.println("REs: " + t2);
        
        System.out.println("simasoft: " + Utils.nameRandom());        

    } // main

} // App
