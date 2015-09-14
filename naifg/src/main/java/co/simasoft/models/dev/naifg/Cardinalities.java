package co.simasoft.models.dev.naifg;

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
import javax.persistence.Lob;

import co.simasoft.models.core.sites.*;
import co.simasoft.models.dev.naifg.*;
import co.simasoft.models.dev.naifg.dependencies.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Lob;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;


@Indexed
@Entity
public class Cardinalities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @DocumentId
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private double orden;

    @Lob
    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String observations;

    @Column(nullable = false, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String cardinality;

    @Column(nullable = false, unique = true)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(nullable = true, unique = false)
    private Boolean isUnidirectional;

    @OneToMany(mappedBy = "cardinalities")
    private Set<Relationships> relationships = new HashSet<Relationships>();

    @ManyToMany
    private Set<Sites> sites = new HashSet<Sites>();

    @ManyToMany
    private Set<Imports> imports = new HashSet<Imports>();

    public Cardinalities() {
    }

    public Cardinalities(String cardinality,String name,Boolean isUnidirectional) {
        this.cardinality = cardinality;
        this.name = name;
        this.isUnidirectional = isUnidirectional;
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
    public String getCardinality() {
        return cardinality;
    }
    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsUnidirectional() {
        return isUnidirectional;
    }
    public void setIsUnidirectional(Boolean isUnidirectional) {
        this.isUnidirectional = isUnidirectional;
    }

    public Set<Relationships> getRelationships() {
        return relationships;
    }
    public void setRelationships(Set<Relationships> relationships) {
        this.relationships = relationships;
    }

    public Set<Sites> getSites() {
        return sites;
    }
    public void setSites(Set<Sites> sites) {
        this.sites = sites;
    }

    public Set<Imports> getImports() {
        return imports;
    }
    public void setImports(Set<Imports> imports) {
        this.imports = imports;
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

      Cardinalities other = (Cardinalities) ojt;
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

