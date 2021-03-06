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

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import co.simasoft.models.*;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.DateBridge;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// @Indexed
@Entity
@XmlRootElement
public class GroupIds implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @DocumentId
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private double orden;

    private String alias;

    @Lob
    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String observations;

    @Column(nullable = false, unique = true)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String artifactId;

    @Column(nullable = false, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String groupId;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String version;

    @Column(nullable = true, unique = false)
    // @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String code;

    @Column(nullable = true, unique = false)
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "groupIds")
    private Set<Models> models = new HashSet<Models>();

    @OneToMany(mappedBy = "groupIds")
    private Set<Entities> entities = new HashSet<Entities>();

    @ManyToOne
    private GroupIdsTypes groupIdsTypes;

    public GroupIds() {
    }

    public GroupIds(String artifactId,String groupId,String version,String code,Date date) {
        this.artifactId = artifactId;
        this.groupId = groupId;
        this.version = version;
        this.code = code;
        this.date = date;
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

    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
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
    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Models> getModels() {
        return models;
    }
    public void setModels(Set<Models> models) {
        this.models = models;
    }

    public Set<Entities> getEntities() {
        return entities;
    }
    public void setEntities(Set<Entities> entities) {
        this.entities = entities;
    }

    public GroupIdsTypes getGroupIdsTypes() {
        return groupIdsTypes;
    }
    public void setGroupIdsTypes(GroupIdsTypes groupIdsTypes) {
        this.groupIdsTypes = groupIdsTypes;
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

      GroupIds other = (GroupIds) ojt;
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

