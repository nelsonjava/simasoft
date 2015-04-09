package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Relationships{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String entity;

   private boolean optionality;

   private String name;

   private String mappedby;

   private String annotationsMethod;

   private String annotationsField;

   private String tabla;

   private String idTabla1;

   private String idTabla2;

   private String description;

   private String observaciones;

   @OneToMany(mappedBy = "relationships")
   private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

   @ManyToOne
   private Entities from;

   @ManyToOne
   private Entities to;

   @ManyToOne
   private Cardinalities cardinalities;

   public Relationships()
   {
   }

   public Relationships(String entity, boolean optionality, String name, String mappedby, String annotationsMethod, String annotationsField, String tabla, String idTabla1, String idTabla2, String description, String observaciones)
   {
      this.entity = entity;
      this.optionality = optionality;
      this.name = name;
      this.mappedby = mappedby;
      this.annotationsMethod = annotationsMethod;
      this.annotationsField = annotationsField;
      this.tabla = tabla;
      this.idTabla1 = idTabla1;
      this.idTabla2 = idTabla2;
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

   public String getEntity()
   {
      return entity;
   }

   public void setEntity(String entity)
   {
      this.entity = entity;
   }

   public boolean getOptionality()
   {
      return optionality;
   }

   public void setOptionality(boolean optionality)
   {
      this.optionality = optionality;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getMappedby()
   {
      return mappedby;
   }

   public void setMappedby(String mappedby)
   {
      this.mappedby = mappedby;
   }

   public String getAnnotationsMethod()
   {
      return annotationsMethod;
   }

   public void setAnnotationsMethod(String annotationsMethod)
   {
      this.annotationsMethod = annotationsMethod;
   }

   public String getAnnotationsField()
   {
      return annotationsField;
   }

   public void setAnnotationsField(String annotationsField)
   {
      this.annotationsField = annotationsField;
   }

   public String getTabla()
   {
      return tabla;
   }

   public void setTabla(String tabla)
   {
      this.tabla = tabla;
   }

   public String getIdTabla1()
   {
      return idTabla1;
   }

   public void setIdTabla1(String idTabla1)
   {
      this.idTabla1 = idTabla1;
   }

   public String getIdTabla2()
   {
      return idTabla2;
   }

   public void setIdTabla2(String idTabla2)
   {
      this.idTabla2 = idTabla2;
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

   public Set<PropertiesAttributes> getPropertiesAttributes()
   {
      return propertiesAttributes;
   }

   public void setPropertiesAttributes(Set<PropertiesAttributes> propertiesAttributes)
   {
      this.propertiesAttributes = propertiesAttributes;
   }

   public Entities getFrom()
   {
      return from;
   }

   public void setFrom(Entities from)
   {
      this.from = from;
   }

   public Entities getTo()
   {
      return to;
   }

   public void setTo(Entities to)
   {
      this.to = to;
   }

   public Cardinalities getCardinalities()
   {
      return cardinalities;
   }

   public void setCardinalities(Cardinalities cardinalities)
   {
      this.cardinalities = cardinalities;
   }

} // entity

