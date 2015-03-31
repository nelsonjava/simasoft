package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Attributes
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
   private long id;

   private Integer optlock;

   private String name;

   private String type;

   private Integer length;

   private Integer precision;

   private boolean nullable;

   private boolean unico;

   private String descripcion;

   private String field;

   private String access;

   private String columnDefinition;

   private String annotationsField;

   private String annotationsMethod;

   private String observaciones;

   @ManyToOne
   private TypesAttributes typesAttributes;

   @ManyToOne
   private Entities entities;

   @OneToMany(mappedBy = "attributes")
   private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

   public Attributes()
   {
   }

   public Attributes(String name, String type, Integer length, Integer precision, boolean nullable, boolean unico, String descripcion, String field, String access, String columnDefinition, String annotationsField, String annotationsMethod, String observaciones)
   {
      this.name = name;
      this.type = type;
      this.length = length;
      this.precision = precision;
      this.nullable = nullable;
      this.unico = unico;
      this.descripcion = descripcion;
      this.field = field;
      this.access = access;
      this.columnDefinition = columnDefinition;
      this.annotationsField = annotationsField;
      this.annotationsMethod = annotationsMethod;
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

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public Integer getLength()
   {
      return length;
   }

   public void setLength(Integer length)
   {
      this.length = length;
   }

   public Integer getPrecision()
   {
      return precision;
   }

   public void setPrecision(Integer precision)
   {
      this.precision = precision;
   }

   public boolean getNullable()
   {
      return nullable;
   }

   public void setNullable(boolean nullable)
   {
      this.nullable = nullable;
   }

   public boolean getUnico()
   {
      return unico;
   }

   public void setUnico(boolean unico)
   {
      this.unico = unico;
   }

   public String getDescripcion()
   {
      return descripcion;
   }

   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public String getField()
   {
      return field;
   }

   public void setField(String field)
   {
      this.field = field;
   }

   public String getAccess()
   {
      return access;
   }

   public void setAccess(String access)
   {
      this.access = access;
   }

   public String getColumnDefinition()
   {
      return columnDefinition;
   }

   public void setColumnDefinition(String columnDefinition)
   {
      this.columnDefinition = columnDefinition;
   }

   public String getAnnotationsField()
   {
      return annotationsField;
   }

   public void setAnnotationsField(String annotationsField)
   {
      this.annotationsField = annotationsField;
   }

   public String getAnnotationsMethod()
   {
      return annotationsMethod;
   }

   public void setAnnotationsMethod(String annotationsMethod)
   {
      this.annotationsMethod = annotationsMethod;
   }

   public String getObservaciones()
   {
      return observaciones;
   }

   public void setObservaciones(String observaciones)
   {
      this.observaciones = observaciones;
   }

   public TypesAttributes getTypesAttributes()
   {
      return typesAttributes;
   }

   public void setTypesAttributes(TypesAttributes typesAttributes)
   {
      this.typesAttributes = typesAttributes;
   }

   public Entities getEntities()
   {
      return entities;
   }

   public void setEntities(Entities entities)
   {
      this.entities = entities;
   }

   public Set<PropertiesAttributes> getPropertiesAttributes()
   {
      return propertiesAttributes;
   }

   public void setPropertiesAttributes(Set<PropertiesAttributes> propertiesAttributes)
   {
      this.propertiesAttributes = propertiesAttributes;
   }

} // entity

