package co.simasoft.models.dev.naifg.dependencies;

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
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.Lob;


@Indexed
@Entity
public class Dependencies implements Serializable {

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
    private String groupId;

    @Column(nullable = false, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String artifactId;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String version;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String type;

    @Column(nullable = true, unique = false)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String scope;

    @Column(nullable = false, unique = true)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String maven;

    @ManyToMany
    private Set<Sites> sites = new HashSet<Sites>();

    @OneToMany(mappedBy = "dependencies")
    private Set<Imports> imports = new HashSet<Imports>();

    public Dependencies() {
    }

    public Dependencies(String groupId,String artifactId,String version,String type,String scope,String maven) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.type = type;
        this.scope = scope;
        this.maven = maven;
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
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getMaven() {
        return maven;
    }
    public void setMaven(String maven) {
        this.maven = maven;
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

      Dependencies other = (Dependencies) ojt;
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

