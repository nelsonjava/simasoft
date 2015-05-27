package co.simasoft.models.naif.domainmodels;

import java.io.*;
import java.util.*;

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
public class DomainModels implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Version
    private Integer optlock;

    private long orden;

    @Column(nullable = false, unique = true)
    private String artifactId;

    @Column(nullable = false, unique = false)
    private String groupId;

    @Column(nullable = true, unique = false)
    private String name;

    @Column(nullable = true, unique = false)
    private String description;

    @Column(nullable = true, unique = false)
    private Date date;

    @Column(nullable = true, unique = true)
    private String code;

    @Column(nullable = false, unique = false)
    private String version;

    @Column(nullable = true, unique = false)
    private String observations;

    @OneToMany(mappedBy = "domainModels")
    private Set<FilesModels> filesModels = new HashSet<FilesModels>();

    @OneToMany(mappedBy = "domainModels")
    private Set<GroupIds> groupIds = new HashSet<GroupIds>();

    @ManyToOne
    private SystemsModels systemsModels;

    public DomainModels() {
    }

    public DomainModels(String artifactId,String groupId,String name,String description,Date date,String code,String version,String observations) {
        this.artifactId = artifactId;
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.date = date;
        this.code = code;
        this.version = version;
        this.observations = observations;
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

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Set<FilesModels> getFilesModels() {
        return filesModels;
    }
    public void setFilesModels(Set<FilesModels> filesModels) {
        this.filesModels = filesModels;
    }

    public Set<GroupIds> getGroupIds() {
        return groupIds;
    }
    public void setGroupIds(Set<GroupIds> groupIds) {
        this.groupIds = groupIds;
    }

    public SystemsModels getSystemsModels() {
        return systemsModels;
    }
    public void setSystemsModels(SystemsModels systemsModels) {
        this.systemsModels = systemsModels;
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

      DomainModels other = (DomainModels) ojt;
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

