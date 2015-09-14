package co.simasoft.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ramki
 */

@Singleton
@LocalBean
@Named("FileUpload")
public class FileUpload {

    private Part file1;

    public Part getFile1() {
        return file1;
    }
    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String upload() throws IOException {
        file1.write("D:\\docs\\"+getFilename(file1));
        return "success";
    }
    
    public String save(Part part) throws IOException {
        file1.write("D:\\docs\\"+getFilename(file1));
        return "success";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
