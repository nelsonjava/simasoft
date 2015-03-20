package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class SystemsModels
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private String codigo;

   private String release;

   private Date fecha;

   private String description;

   @OneToMany(mappedBy = "systemsModels")
   private Set<FilesModels> filesModels = new HashSet<FilesModels>();

   @OneToMany(mappedBy = "systemsModels")
   private Set<DomainModels> domainModels = new HashSet<DomainModels>();

   public SystemsModels()
   {
   }

   public SystemsModels(String name, String codigo, String release, Date fecha, String description)
   {
      this.name = name;
      this.codigo = codigo;
      this.release = release;
      this.fecha = fecha;
      this.description = description;
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

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getRelease()
   {
      return release;
   }

   public void setRelease(String release)
   {
      this.release = release;
   }

   public Date getFecha()
   {
      return fecha;
   }

   public void setFecha(Date fecha)
   {
      this.fecha = fecha;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Set<FilesModels> getFilesModels()
   {
      return filesModels;
   }

   public void setFilesModels(Set<FilesModels> filesModels)
   {
      this.filesModels = filesModels;
   }

   public Set<DomainModels> getDomainModels()
   {
      return domainModels;
   }

   public void setDomainModels(Set<DomainModels> domainModels)
   {
      this.domainModels = domainModels;
   }

} // entity

