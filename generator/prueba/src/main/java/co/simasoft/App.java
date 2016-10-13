package co.simasoft;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

public class App{

    public static void main( String[] args ) throws IOException {

        Integer i = 0;
        Integer j = 0;

        String filePath = "/docs/PhysicalAreas.csv";
        BufferedReader br = null;
        String line = "";
        String texto = "";
        String cvsSplitBy = ";";

        String entity = "";
        String fieldType = "";
        String fieldName = "";
        String fieldValue = "";

        String[] fieldTypes = new String[100];
        String[] fieldsEntity = new String[100];

        Map<Integer, String> types = new HashMap<Integer, String>();
        Map<Integer, String> fields = new HashMap<Integer, String>();
        Map<Integer, String> registro = new HashMap<Integer, String>();

    try{

        FileTxt f = new FileTxt();

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

            String[] data = line.split(cvsSplitBy);

            i++;
            switch (i) {
                case 1: // types

                     entity = data[data.length-1];
                     fieldTypes = data;
                     j = 0;
                     fieldType = "";
                     for (String type : data) {
                          j++;
                          if (j < data.length-1 ){
                              fieldType += type+";";
                              types.put(j,type);
                          }
                     }
//                     f.line("Tipos:"+fieldType);
                     break;

                case 2: // fields

                     j = 0;
                     fieldName = "";
                     fieldsEntity = data;
                     for (String field : data) {
                          j++;
                          if (j < data.length ){
                              fieldName += field+"("+fieldTypes[j-1]+");";
                              fields.put(j,field);
                          }
                     }
//                     f.line("campos:");
//                     f.line(fieldName);
                     break;

                default:

              Integer len = data.length;
              System.out.println(len);

              f.line("Entidad:"+entity+" ="+Integer.toString(len)+" fields");
              f.line(fieldTypes[0]+":"+fieldTypes[1]+":"+fieldTypes[2]+":"+fieldTypes[3]+":"+fieldTypes[4]+":"+fieldTypes[5]+":"+fieldTypes[6]);
              for(Integer x=0;x<=data.length-1;x+=1){
                  f.line(fieldsEntity[0]+":"+fieldsEntity[1]+":"+fieldsEntity[2]+":"+fieldsEntity[3]+":"+fieldsEntity[4]+":"+fieldsEntity[5]+":"+fieldsEntity[6]);
                  f.line(data[0]+":"+data[1]+":"+data[2]+":"+data[3]+":"+data[4]+":"+data[5]+":"+data[6]);
              }


              for(Integer x=0;x<=data.length-1;x+=1){
                  System.out.println("paso");
              }

//              System.out.println("paso");




/*
                     j = 1;
                     fieldValue = "";
                     for (String value : data) {
                          fieldValue += value+";";
                          f.line(fieldsEntity[j]+":"+fieldValue);
//                          j++;
                     }
                     f.line(fieldValue);
*/
                     break;
            } // switch

        } // while

        f.saveFile("\\docs", "logcvs.txt");

    }  catch (FileNotFoundException ex) {
             ex.printStackTrace();
    } catch (IOException ex) {
             ex.printStackTrace();
    } catch (NullPointerException ex) {
             ex.printStackTrace();
    } catch(Exception ioe) {
            ioe.printStackTrace();
    } finally {
        if (br != null) {
            try {
              br.close();
            }
            catch (IOException e) {
                  e.printStackTrace();
            }
        }
    }

    } // Main

} // App
