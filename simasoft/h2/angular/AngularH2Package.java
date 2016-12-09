package co.simasoft.gen.war.h2.angular;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class AngularH2Package extends FileTxt {

  public AngularH2Package(String artifactId) {

line("{");
line("  \"name\": \""+artifactId+"\",");
line("  \"description\": \"web app "+artifactId+"\",");
line("  \"version\": \"0.1.0\",");
line("  \"scripts\": {");
line("    \"public\": \"mkdir -p public\",");
line("    \"build-js\": \"NODE_PATH=. browserify -t [ babelify --presets [ es2015 ] ] src/index.js > public/app.js\",");
line("    \"copy-files\": \"cp src/index.css public/app.css && cp src/index.html public/index.html\",");
line("    \"build\": \"npm run public && npm run build-js && npm run copy-files\",");
line("    \"serve\": \"serve public\"");
line("  }");
line("}");



  } // Constructor

} // H2AngularReadme