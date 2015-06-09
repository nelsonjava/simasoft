package co.simasoft.models.naif.domainmodels;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import javax.persistence.Column;

import co.simasoft.models.naif.domainmodels.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import javax.persistence.Lob;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Relationships implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private double orden;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String observations;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String idTable2;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String description;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String table;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String idTable1;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String mappedby;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String annotationsField;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String annotationsMethod;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String entity;

    @Column(nullable = true, unique = false)
    private Boolean optionality;

    @Column(nullable = true, unique = false)
    private Boolean isEmbedded;

    @OneToMany(mappedBy = "relationships")
    private Set<PropertiesAttributes> propertiesAttributes = new HashSet<PropertiesAttributes>();

    @ManyToOne
    private Cardinalities cardinalities;

    @ManyToOne
    private Entities to;

    @ManyToOne
    private Entities from;

    public Relationships() {
    }

    public Relationships(String observations,String idTable2,String description,String table,String idTable1,String mappedby,String name,String annotationsField,String annotationsMethod,String entity,Boolean optionality,Boolean isEmbedded) {
        this.observations = observations;
        this.idTable2 = idTable2;
        this.description = description;
        this.table = table;
        this.idTable1 = idTable1;
        this.mappedby = mappedby;
        this.name = name;
        this.annotationsField = annotationsField;
        this.annotationsMethod = annotationsMethod;
        this.entity = entity;
        this.optionality = optionality;
        this.isEmbedded = isEmbedded;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOptlock() {
        return this.optlock;
    }
    public void setOptlock(Integer optlock) {
        this.optlock = optlock;
    }

    public double getOrden() {
        return this.orden;
    }
    public void setOrden(double orden) {
        this.orden = orden;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getIdTable2() {
        return idTable2;
    }
    public void setIdTable2(String idTable2) {
        this.idTable2 = idTable2;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }

    public String getIdTable1() {
        return idTable1;
    }
    public void setIdTable1(String idTable1) {
        this.idTable1 = idTable1;
    }

    public String getMappedby() {
        return mappedby;
    }
    public void setMappedby(String mappedby) {
        this.mappedby = mappedby;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotationsField() {
        return annotationsField;
    }
    public void setAnnotationsField(String annotationsField) {
        this.annotationsField = annotationsField;
    }

    public String getAnnotationsMethod() {
        return annotationsMethod;
    }
    public void setAnnotationsMethod(String annotationsMethod) {
        this.annotationsMethod = annotationsMethod;
    }

    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Boolean getOptionality() {
        return optionality;
    }
    public void setOptionality(Boolean optionality) {
        this.optionality = optionality;
    }

    public Boolean getIsEmbedded() {
        return isEmbedded;
    }
    public void setIsEmbedded(Boolean isEmbedded) {
        this.isEmbedded = isEmbedded;
    }

    public Set<PropertiesAttributes> getPropertiesAttributes() {
        return propertiesAttributes;
    }
    public void setPropertiesAttributes(Set<PropertiesAttributes> propertiesAttributes) {
        this.propertiesAttributes = propertiesAttributes;
    }

    public Cardinalities getCardinalities() {
        return cardinalities;
    }
    public void setCardinalities(Cardinalities cardinalities) {
        this.cardinalities = cardinalities;
    }

    public Entities getTo() {
        return to;
    }
    public void setTo(Entities to) {
        this.to = to;
    }

    public Entities getFrom() {
        return from;
    }
    public void setFrom(Entities from) {
        this.from = from;
    }

   @Override
   public int hashCode() {
      final int prime  = 31;
            int result =  1;

      result = prime * result + ((id == null) ? 0 : id.hashCode());

      return result;
   }

   @Override
   public boolean equals(Object ojt) {
      if (      this == ojt           ) return true;
      if (       ojt == null          ) return false;
      if (getClass() != ojt.getClass()) return false;

      Relationships other = (Relationships) ojt;
      if (id == null) {
         if (other.id != null) {
            return false;
         }
      } else {
         if (!id.equals(other.id)) {
            return false;
         }
      }

      return true;
   }

} // entity

