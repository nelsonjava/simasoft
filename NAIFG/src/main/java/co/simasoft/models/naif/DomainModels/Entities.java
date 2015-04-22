package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Entities
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private String tabla;

   private String tablaSecuencia;

   private String modifier;

   private String extend;

   private String imports;

   private String annotations;

   private String source;

   private String description;

   private String observaciones;

   @OneToMany(mappedBy = "entities")
   private Set<NameQueries> nameQueries = new HashSet<NameQueries>();

   @OneToMany(mappedBy = "from")
   private Set<Relationships> from = new HashSet<Relationships>();

   @OneToMany(mappedBy = "to")
   private Set<Relationships> to = new HashSet<Relationships>();

   @OneToMany(mappedBy = "entities")
   private Set<FilesModels> filesModels = new HashSet<FilesModels>();

   @ManyToOne
   private DomainModels domainModels;

   @OneToMany(mappedBy = "entities")
   private Set<Attributes> attributes = new HashSet<Attributes>();

   public Entities()
   {
   }

   public Entities(String name, String tabla, String tablaSecuencia, String modifier, String extend, String imports, String annotations, String source, String description, String observaciones)
   {
      this.name = name;
      this.tabla = tabla;
      this.tablaSecuencia = tablaSecuencia;
      this.modifier = modifier;
      this.extend = extend;
      this.imports = imports;
      this.annotations = annotations;
      this.source = source;
      this.description = description;
      this.observaciones = observaciones;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getTabla()
   {
      return tabla;
   }

   public void setTabla(String tabla)
   {
      this.tabla = tabla;
   }

   public String getTablaSecuencia()
   {
      return tablaSecuencia;
   }

   public void setTablaSecuencia(String tablaSecuencia)
   {
      this.tablaSecuencia = tablaSecuencia;
   }

   public String getModifier()
   {
      return modifier;
   }

   public void setModifier(String modifier)
   {
      this.modifier = modifier;
   }

   public String getExtend()
   {
      return extend;
   }

   public void setExtend(String extend)
   {
      this.extend = extend;
   }

   public String getImports()
   {
      return imports;
   }

   public void setImports(String imports)
   {
      this.imports = imports;
   }

   public String getAnnotations()
   {
      return annotations;
   }

   public void setAnnotations(String annotations)
   {
      this.annotations = annotations;
   }

   public String getSource()
   {
      return source;
   }

   public void setSource(String source)
   {
      this.source = source;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public Set<NameQueries> getNameQueries()
   {
      return nameQueries;
   }

   public void setNameQueries(Set<NameQueries> nameQueries)
   {
      this.nameQueries = nameQueries;
   }

   public Set<Relationships> getFrom(){
      return from;
   }
   public void setFrom(Set<Relationships> from) {
      this.from = from;
   }

   public Set<Relationships> getTo(){
      return to;
   }
   public void setTo(Set<Relationships> to){
      this.to = to;
   }

   public Set<FilesModels> getFilesModels()
   {
      return filesModels;
   }

   public void setFilesModels(Set<FilesModels> filesModels)
   {
      this.filesModels = filesModels;
   }

   public DomainModels getDomainModels()
   {
      return domainModels;
   }

   public void setDomainModels(DomainModels domainModels)
   {
      this.domainModels = domainModels;
   }

   public Set<Attributes> getAttributes()
   {
      return attributes;
   }

   public void setAttributes(Set<Attributes> attributes)
   {
      this.attributes = attributes;
   }

} // entity

