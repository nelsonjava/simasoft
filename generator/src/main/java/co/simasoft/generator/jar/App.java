package co.simasoft.generator.jar;

import co.simasoft.utils.*;

public class App extends FileTxt {

  public void Generar(String groupId) {

line("package "+groupId+";\n");

line("/**");
line(" * Hello world!");
line(" *");
line("*/\n");

line("public class App{\n");

line("    public static void main( String[] args ){");
line("        System.out.println( \"Hello World!\" );");
line("    } // main\n");

line("} // App");

  } // Generar

} // Fin de clase
