package co.simasoft.generator.utils;

import java.io.*;

/*
  <groupId>co.simasoft.generator</groupId>
  <artifactId>generator</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>generator</name>
*/


public class Ui{

    public static int typeApp() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String tipoIngresado = "";
        int tipo = 0;

        System.out.println();
        System.out.println("Tipo de aplicacion: ");
        System.out.println("1:jar");
        System.out.println("2:war");
        System.out.println("3:ear");
        System.out.println();

        System.out.print("Seleccione el tipo de aplicacion: ");

        tipoIngresado = lectura.readLine();
        try{
            tipo = Integer.parseInt(tipoIngresado);
        }
        catch (NumberFormatException nfe) {
            System.out.println("!!Error!! No se ingreso un numero");
        }

        return tipo;

    } // typeApp

    public static String artifactId() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String artifactId = "";

        System.out.println();
        System.out.println("artifactId: ");
        artifactId = lectura.readLine();
        return artifactId;

    } // artifactId

    public static String groupId() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String groupId = "";

        System.out.println();
        System.out.println("groupId: ");
        groupId = lectura.readLine();
        return groupId;

    } // groupId

} // Ui