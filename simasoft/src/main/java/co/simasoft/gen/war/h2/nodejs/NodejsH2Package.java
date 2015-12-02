package co.simasoft.gen.war.h2.nodejs;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class NodejsH2Package extends FileTxt {

  public NodejsH2Package(String artifactId) {

line("{");
line("  \"name\": \""+artifactId+"\",");
line("  \"version\": \"1.0.0\",");
line("  \"description\": \"web app node.js "+artifactId+"\",");
line("  \"main\": \"index.js\",");
line("  \"directories\": {");
line("    \"test\": \"test\"");
line("  },");
line("  \"dependencies\": {");
line("    \"tape\": \"^4.2.2\",");
line("    \"tap-spec\": \"^4.1.1\"");
line("  },");
line("  \"devDependencies\": {");
line("    \"tap-spec\": \"^4.1.1\",");
line("    \"tape\": \"^4.2.2\"");
line("  },");
line("  \"scripts\": {");
line("    \"test\": \"tape test/*-test.js\"");
line("  },");
line("  \"author\": \"\",");
line("  \"license\": \"MIT\"");
line("}");

  } // Constructor

} // H2AngularReadme



