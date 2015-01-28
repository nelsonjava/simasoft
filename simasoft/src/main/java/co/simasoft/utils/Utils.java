package co.simasoft.utils;

import java.io.*;

// Dic 13/2014 Hora:09:45 Sabado

public class Utils {

    public static String spaces(int length) {

        String error = "";
        byte[] bytes = new byte[0];
        String espacios = "";

        if(length < 0) {
            error = "sys.error : spaces : Parametro negativo " + length;
            System.out.println(error);
            return error;
        }

        bytes = new byte[length];
        espacios = new String(bytes);

        return espacios;

    } // spaces

    public static String _1raMin(String cadena) {
        return cadena.substring(0,1).toLowerCase() + cadena.substring(1, cadena.length());
    } // _1raMin

    public static String _1raMay(String cadena) {
        return cadena.substring(0,1).toUpperCase() + cadena.substring(1, cadena.length());
    } // _1raMay

    public static String Paths(String paquete) {

        String[] carpetas = paquete.split("\\.");

        // Si el nombre del paquete no tiene puntos
        if(carpetas.length == 1) {
            return carpetas[0];
        }

        String carpetasPaquetes = carpetas[0];

        // Se crean las carpetas de los paquetes
        for(String carpeta : carpetas) {
            carpetasPaquetes += "//" + carpeta;
        }

        return carpetasPaquetes;

    } // Path

    public static String mkDirs(String paquete) {

System.out.println("mkDirs="+paquete);

        File myDir;
        String[] carpetas = paquete.split("\\.");

        // Si el nombre del paquete no tiene puntos
        if(carpetas.length == 1) {
            myDir = new File(carpetas[0]);
            myDir.mkdir();
            return carpetas[0];
        }

        String carpetasPaquetes = carpetas[0];

        int i = 1;
        // Se crean las carpetas de los paquetes
        for(String carpeta : carpetas) {

            if(i == 1) {
                myDir = new File(carpeta);
                myDir.mkdir();
                i = 0; continue;
            }

            carpetasPaquetes += "/" + carpeta;
            myDir = new File(carpetasPaquetes);
            myDir.mkdir();
        }

        return carpetasPaquetes;

    } // mkDirs

    public static void fileMake(String path, String fileName, FileTxt fileTxt) {

        String source = "";
        String dir = "";
        File file;
        File archivo;
        BufferedWriter bw;

        dir = mkDirs(path);

        file = new File(dir);
        source = fileTxt.getSource();
        archivo = new File(file, fileName);

        try { // Escribir la info del source al archivo

            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(source);
            bw.close();

        } catch (IOException e) {}

    } // fileMake

    /** Copia una imagen de un directorio fuente a un directorio destino. */
    public static boolean copyFile(String fileSource, String fileDest) {

        File inputFile = new File(fileSource);
        File outputFile = new File(fileDest);

        try {

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile), 4096);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile), 4096);

            int c; // Numero que representa el valor leido

            while ((c = bis.read()) != -1) bos.write(c);

            bos.close();
            bis.close();

        } // try

        catch(IOException ioe) {

            return false;

        } // catch

        return true;
    } // copyFile

    /** Copia archivos(imagenes preferiblemente) de una carpeta origen, a otra carpeta destino. */
    public static boolean copyFiles(String dirSource, String dirDest) {

        mkDirs(dirDest.replace('/','.'));

        File dir = new File(dirSource);

        String[] files = dir.list();

System.out.println("dirSource="+dirSource);
System.out.println("dirDest="+dirDest);


        for(String f : files) { // Pasar un archivo de la carpeta a -> b
            copyFile(dirSource + "/" + f , dirDest + "/" + f);
        }

        System.out.println("-> Copia de imagenes, !!EXITOSA!!");

        return true;
    }  // copyFile

    public static String paqueteToPath(String paquete) {
        return paquete.replace('.','/');
    }

    public static String lenField(String type) {
        String[] fieldAndLength = type.split("\\(");

        if (fieldAndLength.length != 2) {
            return null;
        }

        return fieldAndLength[1].substring( 0 , (fieldAndLength[1].length() - 1) );
    }

    public static boolean isFieldNull(String type) {
        if (type.substring(0,1).equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    public static String typeField(String type) {

        // In case of type field WITHOUT length
        if (!type.contains("(")) {
            if (isFieldNull(type)) {
                return type.substring( 1 , (type.length()) );
            } else {
                return type;
            }
        }

        // For a type field WITH length
        String[] fieldAndLength = type.split("\\(");

        if (fieldAndLength.length != 2) {
            return null;
        }

        String field;
        if (isFieldNull(fieldAndLength[0])) {
            field = fieldAndLength[0].substring( 1 , (fieldAndLength[0].length()) );
        } else {
            field = fieldAndLength[0];
        }

        return field;
    }


    public static void fileJar( String farchivo, String directory, String fileJar ) throws IOException {

       java.util.jar.JarFile jar = new java.util.jar.JarFile(fileJar);
       java.util.Enumeration otra = jar.entries();

       java.io.File f = new java.io.File(directory+farchivo);
       java.util.jar.JarEntry file = new java.util.jar.JarEntry(directory);

       while (otra.hasMoreElements()) {

         java.util.jar.JarEntry sfile = (java.util.jar.JarEntry) otra.nextElement();
         java.io.File ff  = new java.io.File(directory + sfile.getName());
         java.io.File fff = new java.io.File(directory + farchivo );

         if (ff.getName().equals(farchivo)){
            file = sfile;
            f = fff;
            System.out.println(directory+f.getName());
            break;
         }
       } // while

       java.io.InputStream is = jar.getInputStream(file); // get the input stream
       java.io.FileOutputStream fos = new java.io.FileOutputStream(f);

       while (is.available() > 0) {  // write contents of 'is' to 'fos'
          fos.write(is.read());
       }

       fos.close();
       is.close();

    }

} // Utils