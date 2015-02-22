package co.simasoft.generator.jar.mongo;

import co.simasoft.utils.*;

public class MongoBuild extends FileTxt {

  public MongoBuild(String artifactId,String groupId) {

line("<?xml version=\"1.0\"?>");
line("<project name=\"naif\" default=\"bak\" basedir=\".\">\n");

line("  <tstamp/>");
line("  <property name=\"bak\"          value=\"/dev/backups/"+Utils.Paths(groupId)+"\"/>");
line("  <property name=\"project.name\" value=\""+artifactId+"\"/>");
line("  <!--");
line("  <property name=\"wildfly\"      value=\"d:/javasrv/wildfly-8.2.0.Final\"/>");
line("  -->\n");

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

line("  <target name=\"clean\" description=\"Cleans up the staging directory\">");
line("    <delete dir=\"target\"/>");
line("  </target>\n");

line("  <!--");
line("  <target name=\"del1\" description=\"Initialize the build\">");
line("    <delete dir=\"${wildfly}\" failonerror=\"no\"/>");
line("  </target>\n");

line("  <target name=\"del\" depends=\"del1\" description=\"Initialize the build\">");
line("    <mkdir dir=\"${wildfly}\" />");
line("    <copy todir=\"${wildfly}\">");
line("      <fileset dir=\"${wildfly} - copia\" />");
line("    </copy>");
line("  </target>");
line("  -->\n");

line("</project>");

    } // Generar

} // Fin de clase