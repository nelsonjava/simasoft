package co.simasoft.gen.war.h2.react;

import java.io.*;
import java.util.*;

import co.simasoft.utils.*;

public class ReactH2Build extends FileTxt {

  public ReactH2Build(String artifactId) {

line("{");

line("<?xml version=\"1.0\"?>");
line("<project name=\""+artifactId+"\" default=\"bak\" basedir=\".\">\n");

line("  <tstamp/>");
line("  <property name=\"bak\"          value=\"/dev/backups/co/simasoft\"/>");
line("  <property name=\"project.name\" value=\""+artifactId+"\"/>\n");

line("  <target name=\"bak\">");
line("    <delete dir=\"target\" failonerror=\"no\"/>");
line("    <mkdir dir=\"${bak}/${project.name}\" />");
line("    <jar jarfile=\"${bak}/${project.name}/${DSTAMP}-${TSTAMP}-${project.name}.zip\" basedir=\".\"/>");
line("  </target>\n");

line("  <target name=\"ok\">");
line("    <mkdir dir=\"${bak}/${project.name}\" />");
line("    <delete dir=\"target\" failonerror=\"no\"/>");
line("    <jar jarfile=\"${bak}/${project.name}/ok-${DSTAMP}-${TSTAMP}-${project.name}.zip\" basedir=\".\"/>");
line("  </target>\n");

line("  <target name=\"node\" description=\"Initialize the build\">");
line("    <delete dir=\"node_modules\" failonerror=\"no\"/>");
line("  </target>\n");

line("  <target name=\"h2\" description=\"Initialize the build\">");
line("    <delete dir=\"h2\" failonerror=\"no\"/>");
line("  </target>\n");

line("</project>");

  } // Constructor

} // ReactH2Build