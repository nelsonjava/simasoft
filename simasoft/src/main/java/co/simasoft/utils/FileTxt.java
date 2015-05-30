package co.simasoft.utils;

import java.io.*;
import co.simasoft.utils.*;

public class FileTxt {

    protected String source = "";
    private StringBuilder stringBuilder;

    public FileTxt() {
        this.stringBuilder = new StringBuilder();
    }

    public void clearFileTxt() {
           stringBuilder.setLength(0);
    }

    public String getSource() {
        this.source = stringBuilder.toString();
        return this.source;
    }

    public void line(String linea) {
        stringBuilder.append(linea);
        stringBuilder.append("\n");
    }

    public void line(String linea, int spaces) {

        String error = "";

        if(spaces < 0) {
            error = "sys.error : line : Parametro negativo " + spaces;
            System.out.println(error);
        }
        else {
            line(Utils.spaces(spaces) + linea);
        }

    }

    public StringBuilder getStringBuilder() {
        return this.stringBuilder;
    }

    public void saveFile(String path, String fileName)  throws Exception  {

        String source = "";
        String dir = "";
        File file;
        File archivo;
        BufferedWriter bw;

        dir = Utils.mkDirs(path);

        file = new File(dir);
        source = getSource();
        archivo = new File(file, fileName);

        try { // Escribir la info del source al archivo

            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(source);
            bw.close();

        } catch (IOException e) {}

    } // fileMake

} // Fin de la Clase
