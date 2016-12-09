package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2Package extends FileTxt {

  public ReactH2Package(String artifactId) {

line("{");
line("  \"name\": \""+artifactId+"\",");
line("  \"description\": \"web app "+artifactId+"\",");
line("  \"version\": \"0.1.0\",");
line("  \"dependencies\": {");
line("    \"babelify\": \"^6.3.0\",");
line("    \"browserify\": \"^11.2.0\",");
line("    \"react\": \"^0.13.3\"");
line("  },");
line("  \"scripts\":{");
line("  	\"build\": \"browserify app.js > build.js -t babelify\"");
line("  }");
line("}");



  } // Constructor

} // H2AngularReadme