package co.simasoft.generator.utils;

import co.simasoft.utils.*;

import java.io.*;

public class TypeApp{

    public static void Jar(String artifactId,String groupId){

      Utils.mkDirs(artifactId+".src.main.java."+groupId);

    } // typeApp

} // TypeApp