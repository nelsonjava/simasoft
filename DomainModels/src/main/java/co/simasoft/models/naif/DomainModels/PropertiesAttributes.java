package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class PropertiesAttributes
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private String value;

   private String observaciones;

   @ManyToOne
   private Relationships relationships;

   @ManyToOne
   private Attributes attributes;

   public PropertiesAttributes()
   {
   }

   public PropertiesAttributes(String name, String value, String observaciones)
   {
      this.name = name;
      this.value = value;
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

   public String getValue()
   {
      return value;
   }

   public void setValue(String value)
   {
      this.value = value;
   }

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public Relationships getRelationships()
   {
      return relationships;
   }

   public void setRelationships(Relationships relationships)
   {
      this.relationships = relationships;
   }

   public Attributes getAttributes()
   {
      return attributes;
   }

   public void setAttributes(Attributes attributes)
   {
      this.attributes = attributes;
   }

} // entity

