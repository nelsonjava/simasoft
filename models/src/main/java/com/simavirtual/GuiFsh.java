package com.simavirtual;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;
import co.simasoft.gen.jpa.*;

public class GuiFsh extends FileTxt {

  public GuiFsh(String artifactId,String groupId,LinkedHashSet<String> imports) {

line("clear;");
line("echo \"Generating the scaffold.\";");
        for(String paquete : imports) {
line("scaffold-generate --webRoot /admin --targets "+paquete+".*;");
        }

    } // Generar

} // Fin de clase