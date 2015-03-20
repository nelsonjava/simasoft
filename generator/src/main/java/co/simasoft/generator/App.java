package co.simasoft.generator;

import co.simasoft.utils.*;
import co.simasoft.generator.utils.*;

import java.io.*;

public class App{

    public static void main( String[] args ) throws IOException {

        System.out.println("host name..........:" + Utils.hostName());
        System.out.println("Current IP address.:" + Utils.hostIp());
	System.out.println("Current MAC address:" + Utils.hostMac());
	
        Ui.typeApp();

    } // main

} // App
