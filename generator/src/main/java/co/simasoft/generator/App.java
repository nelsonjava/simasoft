package co.simasoft.generator;

import java.io.*;

public class App{
  
    private static void war(String dirName) {

        File theDir = new File(dirName);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + dirName);
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch(SecurityException se){
                //handle it
            }
            if(result) {
                System.out.println("... DIR was created");
            }
        }

    }

    public static void main( String[] args ) throws IOException {
      
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
        
        try {
            tipo = Integer.parseInt(tipoIngresado);
        }
        catch (NumberFormatException nfe) {
            System.out.println("!!Error!! No se ingreso un numero");
        }
        
        switch (tipo) {
            case 1:  System.out.println("Tipo " + tipo);
                     break;
            case 2:  System.out.println("War " + tipo);
                     war("targets");
                     break;
            case 3:  System.out.println("Tipo " + tipo);
                     break;
            default: System.out.println("!!Error!! Numero incorrecto: " + tipo);
                     break;
        }



    }
}
