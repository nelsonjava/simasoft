package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class DomainModels
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private String paquete;

   private String release;

   private String codigo;

   private Date date;

   private String description;

   private String observaciones;

   @OneToMany(mappedBy = "domainModels")
   private Set<LinksModels> linksModels = new HashSet<LinksModels>();

   @OneToMany(mappedBy = "domainModels")
   private Set<Entities> entities = new HashSet<Entities>();

   @OneToMany(mappedBy = "domainModels")
   private Set<FilesModels> filesModels = new HashSet<FilesModels>();

   @ManyToOne
   private SystemsModels systemsModels;

   public DomainModels()
   {
   }

   public DomainModels(String name, String paquete, String release, String codigo, Date date, String description, String observaciones)
   {
      this.name = name;
      this.paquete = paquete;
      this.release = release;
      this.codigo = codigo;
      this.date = date;
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

   public String getPaquete()
   {
      return paquete;
   }

   public void setPaquete(String paquete)
   {
      this.paquete = paquete;
   }

   public String getRelease()
   {
      return release;
   }

   public void setRelease(String release)
   {
      this.release = release;
   }

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
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

   public Set<LinksModels> getLinksModels()
   {
      return linksModels;
   }

   public void setLinksModels(Set<LinksModels> linksModels)
   {
      this.linksModels = linksModels;
   }

   public Set<Entities> getEntities()
   {
      return entities;
   }

   public void setEntities(Set<Entities> entities)
   {
      this.entities = entities;
   }

   public Set<FilesModels> getFilesModels()
   {
      return filesModels;
   }

   public void setFilesModels(Set<FilesModels> filesModels)
   {
      this.filesModels = filesModels;
   }

   public SystemsModels getSystemsModels()
   {
      return systemsModels;
   }

   public void setSystemsModels(SystemsModels systemsModels)
   {
      this.systemsModels = systemsModels;
   }

} // entity

