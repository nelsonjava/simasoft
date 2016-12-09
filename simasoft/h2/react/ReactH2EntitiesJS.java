package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2EntitiesJS extends FileTxt {

  public ReactH2EntitiesJS(String artifactId,ArrayList<Entidad> entities) {

      line("export default [");

      int i=1;
      for(Entidad entidad : entities) {

         if (i == entities.size() ){
            line("  {");
            line("    id: \""+Utils._1raMin(entidad.getName())+"\",");
            line("    name: \""+entidad.getName()+"\"");
            line("  }");
         }
         else{
            line("  {");
            line("    id: \""+Utils._1raMin(entidad.getName())+"\",");
            line("    name: \""+entidad.getName()+"\"");
            line("  },");
         }
         i++;
      } // for package.getEntities()
      line("];");

  } // Constructor

} // ReactH2Build