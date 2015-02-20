package co.simasoft.generator.jar.hsqldb;

import co.simasoft.utils.*;

public class HsqldbUser extends FileTxt {

  public HsqldbUser(String artifactId,String groupId) {

line("package "+groupId+".models"+";\n");

line("import java.io.Serializable;\n");

line("import javax.persistence.Column;");
line("import javax.persistence.Entity;");
line("import javax.persistence.GeneratedValue;");
line("import javax.persistence.GenerationType;");
line("import javax.persistence.Id;");
line("import javax.persistence.Table;\n");

line("@Table(name = \"users\")");
line("@Entity");
line("public class User implements Serializable {\n");

line("	private static final long serialVersionUID = 1L;\n");

line("	@Id");
line("	@GeneratedValue(strategy=GenerationType.AUTO)");
line("	private long id;\n");

line("	@Column(name = \"name\", nullable = false, unique=true, length=50)");
line("	private String name;\n");

line("	public long getId() {");
line("		return id;");
line("	}\n");

line("	public void setId(long id) {");
line("		this.id = id;");
line("	}\n");

line("	public String getName() {");
line("		return name;");
line("	}\n");

line("	public void setName(String name) {");
line("		this.name = name;");
line("	}\n");

line("	@Override");
line("	public String toString() {");
line("		return \"User [id=\" + id + \", name=\" + name + \"]\";");
line("	}");
line("}");

    } // Generar

} // Fin de clase