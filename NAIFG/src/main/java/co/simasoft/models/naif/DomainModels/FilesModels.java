package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class FilesModels
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String codigo;

   private String archivo;

   private String extension;

   private byte data;

   private String type;

   private String observacion;

   @ManyToOne
   private Entities entities;

   @ManyToOne
   private SystemsModels systemsModels;

   @ManyToOne
   private DomainModels domainModels;

   public FilesModels()
   {
   }

   public FilesModels(String codigo, String archivo, String extension, byte data, String type, String observacion)
   {
      this.codigo = codigo;
      this.archivo = archivo;
      this.extension = extension;
      this.data = data;
      this.type = type;
      this.observacion = observacion;
   }

   public long getId()
   {
      return this.id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getArchivo()
   {
      return archivo;
   }

   public void setArchivo(String archivo)
   {
      this.archivo = archivo;
   }

   public String getExtension()
   {
      return extension;
   }

   public void setExtension(String extension)
   {
      this.extension = extension;
   }

   public byte getData()
   {
      return data;
   }

   public void setData(byte data)
   {
      this.data = data;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String getObservacion()
   {
      return observacion;
   }

   public void setObservacion(String observacion)
   {
      this.observacion = observacion;
   }

   public Entities getEntities()
   {
      return entities;
   }

   public void setEntities(Entities entities)
   {
      this.entities = entities;
   }

   public SystemsModels getSystemsModels()
   {
      return systemsModels;
   }

   public void setSystemsModels(SystemsModels systemsModels)
   {
      this.systemsModels = systemsModels;
   }

   public DomainModels getDomainModels()
   {
      return domainModels;
   }

   public void setDomainModels(DomainModels domainModels)
   {
      this.domainModels = domainModels;
   }

} // entity

