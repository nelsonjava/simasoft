package co.simasoft.utils;

import java.io.*;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;
import java.util.Random;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.ObjectStreamClass;


// Dic 13/2014 Hora:09:45 Sabado

public class Utils {

    public static Boolean isEmpty(String text) {
        if (text == null || text.isEmpty()){
           return true;
        }
        else{
           return false;
        }
    } // isEmpty

    public static Boolean isEmpty(Boolean text) {
        if (text == null){
           return true;
        }
        else{
           return false;
        }
    } // isEmpty

    public static String nameRandom() {
        Random rnd = new Random();
        Double d = rnd.nextDouble();
        String t = Double.toString(d);
        String t2 = t.substring(2,t.length());
        return t2;
    }

    public static String hostIp() {

        InetAddress ip;
        try {

           ip = InetAddress.getLocalHost();
           return ip.getHostAddress();

	}
        catch (UnknownHostException e) {

		e.printStackTrace();

	}

	return "";

    }

    public static String serialID(String entity) throws Exception {

        Class cl = Class.forName(entity);

        ObjectStreamClass osc = ObjectStreamClass.lookup(cl);
        String serial = "";
        if (osc != null) {
           long serialID = osc.getSerialVersionUID();
           serial = Long.toString(serialID);
        }
        return serial ;

    }


    public static String hostMac() {

	InetAddress ip;
	try{
	    ip = InetAddress.getLocalHost();
	    NetworkInterface network = NetworkInterface.getByInetAddress(ip);
	    byte[] mac = network.getHardwareAddress();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < mac.length; i++) {
	        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
	    }
	    return sb.toString();

	} catch (UnknownHostException e) {

		e.printStackTrace();

	} catch (SocketException e){

		e.printStackTrace();
	}
	return "";
    }

    public static String hostName() {

        InetAddress ip;
        try {
           ip = InetAddress.getLocalHost();
           return ip.getHostName();
	}
        catch (UnknownHostException e) {
           e.printStackTrace();
	}

	return "";
    }


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
        return paquete.replace(".", "/");

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

    /**
     * This method will copy a file from inside a jar to an specified
     * directory(Tested only in Windows).
     *
     * @param sourcePath Path combined with the desired file to be found
     *                   inside the jar. Use '/' as path separator. If it
     *                   is null, it will be omitted.
     * @param desiredFile File required to copy from jar. Without extra
     *                    folders, in that case use sourcePath parameter.
     * @param outputFolder Directory where file(s) will be located. Use
     *                     '\\' for path separator.
     * @param jarFile Jar file name from which the desired file will be copied.
     */
    public static void fileJar(String sourcePath,String desiredFile,String outputFolder,String jarFile) throws IOException {

        // -------------- Validation PHASE -------------- //
        if (sourcePath == null) {
            sourcePath = "";
        }
        if (desiredFile == null || desiredFile.isEmpty()) {
            System.out.println("\nERROR: The desired file String is null/empty.");
            return;
        }
        if (desiredFile.split("/").length > 1) {
            System.out.println("\nERROR: Better to use the file path, with the sourcePath parameter, leave only the filename.");
            return;
        }
        if (outputFolder == null || outputFolder.isEmpty()) {
            System.out.println("\nERROR: The output folder String is null/empty.");
            return;
        }
        if (jarFile == null || jarFile.isEmpty()) {
            System.out.println("\nERROR: The jar file String is null/empty.");
            return;
        }

        File      copiedFile              = null;
        boolean   foundFlag               = false;
        JarEntry  jarEntryForOutputFolder = null;

        JarFile jar             = new JarFile(jarFile);
        Enumeration jarEntries  = jar.entries();

        while (jarEntries.hasMoreElements()) {

            // For files related to jar entries
            JarEntry jarEntryFileName = (JarEntry) jarEntries.nextElement();

            // Res = A resource that can be a File/Folder
            File path_AvailableRes = new File(outputFolder + jarEntryFileName.getName());
            File path_DesiredRes = new File(outputFolder + desiredFile);

            if (jarEntryFileName.toString().equals(sourcePath +"/"+ desiredFile)) {

                jarEntryForOutputFolder = jarEntryFileName;
                copiedFile = path_DesiredRes;

                System.out.println(outputFolder +desiredFile);

                foundFlag = true;
                break;
            } // end : if

        } // end : while

        if (!foundFlag) {
            System.out.println("ERROR: Not possible to find " + sourcePath + desiredFile + " inside the jar.\n");
            return;
        }

        // If case they don't exist, create new folders.                   //
        new File(outputFolder).mkdirs();

        // Proceed to copy the file //
        InputStream is = jar.getInputStream(jarEntryForOutputFolder);
        FileOutputStream fos = new FileOutputStream(copiedFile);

        while (is.available() > 0) {
            fos.write(is.read());
        }

        fos.flush();
        fos.close();
        is.close();
    } // end : copyFileFromJar Method


} // Utils