package co.simasoft.utils;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

public class Download{

    public static void files(String dir,String fileName) throws IOException {

        BufferedInputStream  input  = null;
        BufferedOutputStream output = null;

        PZip.zipDir(dir, fileName);

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType("application/zip");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try {
            input  = new BufferedInputStream(new FileInputStream(fileName));
            output = new BufferedOutputStream(ec.getResponseOutputStream());

            byte[] buffer = new byte[10240];
            for (int length; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
            output.close();
        }

        fc.responseComplete();


    } // files

    public static void filesProtected(String dir,String fileName,String password) throws IOException {

        BufferedInputStream  input  = null;
        BufferedOutputStream output = null;

        PZip.zipDirWithPassword(dir,fileName,password);

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        ec.responseReset();
        ec.setResponseContentType("application/zip");
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try {
            input  = new BufferedInputStream(new FileInputStream(fileName));
            output = new BufferedOutputStream(ec.getResponseOutputStream());

            byte[] buffer = new byte[10240];
            for (int length; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
            output.close();
        }

        fc.responseComplete();

    } // files

}