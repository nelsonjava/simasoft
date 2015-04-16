package co.simasoft;

import co.simasoft.utils.*;

/**
 * Hello world!
 *
*/

public class App{

    public static void main( String[] args )  throws Exception {
        System.out.println("Current IP address.:" + Utils.hostIp());
        System.out.println("  is: " + Utils.serialID("co.simasoft.Example"));
    } // main

} // App
