package co.simasoft.generator.jar.hsqldb;

import co.simasoft.utils.*;

public class HsqldbBuild extends FileTxt {

  public HsqldbBuild(String artifactId,String groupId) {

line("<?xml version=\"1.0\"?>");
line("<project name=\"naif\" default=\"deploy\" basedir=\".\">\n");

line("        <tstamp/>");
line("        <property name=\"bak\"        value=\"/dev/backups/"+Utils.Paths(groupId)+"\"/>\n");

line("        <property name=\"project.name\" value=\""+artifactId+"\"/>");
line("        <property name=\"jboss.home\" value=\"d:/javasrv/jboss-7.0.2.Final\"/>\n");

line("        <target name=\"bak\">");
line("           <mkdir dir=\"${bak}/${project.name}\" />\n");

line("           <jar jarfile=\"${bak}/${project.name}/${DSTAMP}-${TSTAMP}-${project.name}.zip\"");
line("                basedir=\".\"");
line("           />");
line("        </target>\n");

line("        <target name=\"ok\">");
line("           <mkdir dir=\"${bak}/${project.name}\" />");

line("           <jar jarfile=\"${bak}/${project.name}/OK-${DSTAMP}-${TSTAMP}-${project.name}.zip\"");
line("                basedir=\".\"");
line("           />");
line("        </target>\n");

line("        <target name=\"del1\" description=\"Initialize the build\">");
line("          <delete dir=\"${jboss.home}\" failonerror=\"no\"/>");
line("        </target>\n");

line("        <target name=\"del\" depends=\"del1\" description=\"Initialize the build\">");
line("          <mkdir dir=\"${jboss.home}\" />");
line("          <copy todir=\"${jboss.home}\">");
line("                <fileset dir=\"${jboss.home} - copia\" />");
line("          </copy>");
line("        </target>\n");

line("        <target name=\"clean\" description=\"Cleans up the staging directory\">");
line("          <delete dir=\"target\"/>");
line("        </target>\n");

line("</project>");

    } // Generar

} // Fin de clase