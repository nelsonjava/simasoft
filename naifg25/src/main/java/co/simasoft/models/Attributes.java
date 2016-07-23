package co.simasoft.models;

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
import javax.xml.bind.annotation.XmlRootElement;

import co.simasoft.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;


// @Indexed
@Entity
@XmlRootElement
public class Attributes implements Serializable {

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
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String observations;

    @Column(nullable = true, unique = false)
    private Boolean isUnique;

    @Column(nullable = true, unique = false)
    private Boolean isSimplified;

    @Column(nullable = true, unique = false)
    private Boolean isCreate;

    @Column(nullable = true, unique = false)
    private Boolean isSearch;

    @Column(nullable = true, unique = false)
    private Boolean isView;

    @Column(nullable = true, unique = false)
    private Boolean isViewColumn;

    @Column(nullable = true, unique = false)
    private Boolean isViewRelation;

    @Column(nullable = false, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String description;

    @Column(nullable = true, unique = false)
    private Integer length;

    @Column(nullable = true, unique = false)
    private Integer precision;

    @Column(nullable = true, unique = false)
    private Boolean isNullable;

    @ManyToMany
    private Set<Sites> sites = new HashSet<Sites>();

    @ManyToMany
    private Set<AttributesProperties> attributesProperties = new HashSet<AttributesProperties>();

    @ManyToOne
    private Entities entities;

    @ManyToOne
    private AttributesTypes attributesTypes;

    public Attributes() {
    }

    public Attributes(Boolean isUnique,Boolean isSimplified,Boolean isCreate,Boolean isSearch,Boolean isView,Boolean isViewColumn,Boolean isViewRelation,String name,String description,Integer length,Integer precision,Boolean isNullable) {
        this.isUnique = isUnique;
        this.isSimplified = isSimplified;
        this.isCreate = isCreate;
        this.isSearch = isSearch;
        this.isView = isView;
        this.isViewColumn = isViewColumn;
        this.isViewRelation = isViewRelation;
        this.name = name;
        this.description = description;
        this.length = length;
        this.precision = precision;
        this.isNullable = isNullable;
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
    public Boolean getIsUnique() {
        return isUnique;
    }
    public void setIsUnique(Boolean isUnique) {
        this.isUnique = isUnique;
    }

    public Boolean getIsSimplified() {
        return isSimplified;
    }
    public void setIsSimplified(Boolean isSimplified) {
        this.isSimplified = isSimplified;
    }

    public Boolean getIsCreate() {
        return isCreate;
    }
    public void setIsCreate(Boolean isCreate) {
        this.isCreate = isCreate;
    }

    public Boolean getIsSearch() {
        return isSearch;
    }
    public void setIsSearch(Boolean isSearch) {
        this.isSearch = isSearch;
    }

    public Boolean getIsView() {
        return isView;
    }
    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    public Boolean getIsViewColumn() {
        return isViewColumn;
    }
    public void setIsViewColumn(Boolean isViewColumn) {
        this.isViewColumn = isViewColumn;
    }

    public Boolean getIsViewRelation() {
        return isViewRelation;
    }
    public void setIsViewRelation(Boolean isViewRelation) {
        this.isViewRelation = isViewRelation;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPrecision() {
        return precision;
    }
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Boolean getIsNullable() {
        return isNullable;
    }
    public void setIsNullable(Boolean isNullable) {
        this.isNullable = isNullable;
    }

    public Set<Sites> getSites() {
        return sites;
    }
    public void setSites(Set<Sites> sites) {
        this.sites = sites;
    }

    public Set<AttributesProperties> getAttributesProperties() {
        return attributesProperties;
    }
    public void setAttributesProperties(Set<AttributesProperties> attributesProperties) {
        this.attributesProperties = attributesProperties;
    }

    public Entities getEntities() {
        return entities;
    }
    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public AttributesTypes getAttributesTypes() {
        return attributesTypes;
    }
    public void setAttributesTypes(AttributesTypes attributesTypes) {
        this.attributesTypes = attributesTypes;
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

      Attributes other = (Attributes) ojt;
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

