package co.simasoft.generator.utils;

import co.simasoft.generator.utils.*;

import java.io.*;

public class Ui{

    public static void typeApp() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String type = "";
        int typeApp = 0;

        System.out.println();
        System.out.println("Tipo de aplicacion: ");
        System.out.println("1:jar");
        System.out.println("2:war");
        System.out.println("3:ear");
        System.out.println("4:Modelo Contabilidad Basica");
        System.out.println();

        System.out.print("Seleccione el tipo de aplicacion: ");

        type = lectura.readLine();
        try{
            typeApp = Integer.parseInt(type);
        }
        catch (NumberFormatException nfe) {
            System.out.println("!!Error!! No se ingreso un numero");
        }

        String artifactId = artifactId();
        String groupId = groupId();

        switch (typeApp) {
            case 1:  System.out.println("jar " + typeApp);
                     TypeApp.Jar(artifactId,groupId);
                     break;

            case 2:  System.out.println("War " + typeApp);
                     TypeApp.War(artifactId,groupId);
                     break;

            case 3:  System.out.println("typeApp " + typeApp);
                     break;

            case 4:  System.out.println("modelo " + typeApp);
                     TypeApp.ModeloAsciidoc(artifactId,groupId);
                     break;


            default: System.out.println("!!Error!! Numero incorrecto: " + typeApp);
                     break;
        }


    } // typeApp

    public static String artifactId() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String artifactId = "";

        System.out.println();
        System.out.print("artifactId: ");
        artifactId = lectura.readLine();
        return artifactId;

    } // artifactId

    public static String groupId() throws IOException {

        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        String groupId = "";

        System.out.println();
        System.out.print("groupId: ");
        groupId = lectura.readLine();
        return groupId;

    } // groupId

} // Ui