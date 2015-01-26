package co.simasoft.generator.jpa;

import co.simasoft.utils.*;

import java.io.*;
import java.lang.*;
import java.util.*;

import java.util.HashSet;
import java.util.Set;

public class Entity1 extends FileTxt {

    private Entidad entity = new Entidad();
    private ArrayList<Atributos> atributos = new ArrayList<Atributos>();
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Entity1(String artifactId,String groupId,Entidad entity) throws IOException {

        this.entity = entity;
        this.atributos = entity.getAtributos();
        this.relations = entity.getRelations();

line("import java.util.ArrayList;");
line("import java.util.List;");

line("import javax.persistence.ElementCollection;");
line("import javax.persistence.Entity;");
line("import javax.persistence.GeneratedValue;");
line("import javax.persistence.GenerationType;");
line("import javax.persistence.Id;");
line("import javax.persistence.ManyToOne;");
line("import javax.persistence.OrderColumn;");
line("import javax.validation.constraints.NotNull;");

line("@Entity");
line("public class "+entity.getName()+" {");

line("	@Id");
line("	@GeneratedValue(strategy=GenerationType.TABLE)");
line("	public long id;");

        for(Atributos atributo : atributos) {

           if (atributo.getNulo()) {
line("	@NotNull");
           }
line("	public "+atributo.getType()+" "+atributo.getField()+";");

        } // for atributos

        for(Relation relation : relations) {

           if(relation.getCardinality().equals("*..1")) {
line("	@ManyToOne");
line("	public "+relation.getTo()+" "+relation.getTo().toLowerCase()+";");
           }

           if(relation.getCardinality().equals("1..*")) {
line("	@OneToMany");
line("	public Set<"+relation.getTo()+"> "+relation.getTo().toLowerCase()+" = new HashSet<>();");
           }

        } // for relations

line("	"+entity.getName()+"() {");
line("	}");

    } // Entity1

} // class


