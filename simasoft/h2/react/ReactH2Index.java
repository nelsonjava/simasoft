package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2Index extends FileTxt {

  public ReactH2Index(String artifactId) {

line("<!DOCTYPE html>");
line("<html>");
line("  <head>");
line("    <title>"+artifactId+"</title>");
line("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
line("    <meta charset=\"UTF-8\" />");
line("  </head>");
line("  <body>");
line("    <section id=\"container\"></section>");
line("    <script src=\"build.js\"></script>");
line("  </body>");
line("</html>");

  } // Constructor

} // ReactH2Build