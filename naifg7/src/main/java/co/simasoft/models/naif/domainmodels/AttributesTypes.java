package co.simasoft.models.naif.domainmodels;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import co.simasoft.models.naif.domainmodels.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AttributesTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private long orden;

    @Column(nullable = false, unique = false)
    private String type;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true, unique = false)
    private String observations;

    @Column(nullable = true, unique = false)
    private String annotations;

    @Column(nullable = true, unique = false)
    private Integer precision;

    @Column(nullable = true, unique = false)
    private Integer length;

    @ManyToMany
    private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

    @OneToMany(mappedBy = "attributesTypes")
    private Set<Attributes> attributes = new HashSet<Attributes>();

    public AttributesTypes() {
    }

    public AttributesTypes(String type,String name,String observations,String annotations,Integer precision,Integer length) {
        this.type = type;
        this.name = name;
        this.observations = observations;
        this.annotations = annotations;
        this.precision = precision;
        this.length = length;
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

    public long getOrden() {
        return this.orden;
    }
    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getAnnotations() {
        return annotations;
    }
    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }

    public Integer getPrecision() {
        return precision;
    }
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Set<AttributesProperties> getAttributesProperties() {
        return attributesProperties;
    }
    public void setAttributesProperties(Set<AttributesProperties> attributesProperties) {
        this.attributesProperties = attributesProperties;
    }

    public Set<Attributes> getAttributes() {
        return attributes;
    }
    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
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

      AttributesTypes other = (AttributesTypes) ojt;
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

