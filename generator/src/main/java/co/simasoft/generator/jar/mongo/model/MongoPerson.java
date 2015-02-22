package co.simasoft.generator.jar.mongo;

import co.simasoft.utils.*;

public class MongoPerson extends FileTxt {

  public MongoPerson(String artifactId,String groupId) {

line("package "+groupId+".models"+";\n");

line("import java.util.HashSet;");
line("import java.util.Set;\n");

line("import javax.persistence.CascadeType;");
line("import javax.persistence.Entity;");
line("import javax.persistence.GeneratedValue;");
line("import javax.persistence.Id;");
line("import javax.persistence.OneToMany;\n");

line("import org.hibernate.annotations.GenericGenerator;\n");

line("import org.hibernate.search.annotations.Analyze;");
line("import org.hibernate.search.annotations.Field;");
line("import org.hibernate.search.annotations.Indexed;\n");

line("@Entity");
line("@Indexed");
line("public class Person {\n");

line("    @Id");
line("    @GeneratedValue(generator = \"uuid\")");
line("    @GenericGenerator(name = \"uuid\", strategy = \"uuid2\")");
line("    private String id;\n");

line("    @Field( analyze = Analyze.NO )");
line("    private String firstName;\n");

line("    @Field( analyze = Analyze.NO )");
line("    private String lastName;\n");

line("    Person() {");
line("    }\n");

line("    public Person(String firstName, String lastName) {");
line("        this.firstName = firstName;");
line("        this.lastName = lastName;");
line("    }\n");

line("    public String getId() {");
line("      return id;");
line("    }\n");

line("    public void setId(String id) {");
line("      this.id = id;");
line("    }\n");

line("    public String getFirstName() {");
line("       return firstName;");
line("    }\n");

line("    public void setFirstName(String firstName) {");
line("        this.firstName = firstName;");
line("    }\n");

line("    public String getLastName() {");
line("        return lastName;");
line("    }\n");

line("    public void setLastName(String lastName) {");
line("       this.lastName = lastName;");
line("    }\n");

line("} // Person");

    } // Generar

} // Fin de clase