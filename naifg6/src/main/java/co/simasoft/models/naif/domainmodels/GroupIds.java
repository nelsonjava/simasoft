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
public class GroupIds implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	@Column(nullable = true, unique = false)
	private Date date;

	@Column(nullable = true, unique = true)
	private String code;

	@Column(nullable = true, unique = false)
	private String observations;

	@Column(nullable = true, unique = false)
	private String description;

	@Column(nullable = false, unique = false)
	private String groupId;

	@Column(nullable = true, unique = false)
	private String name;

	@Column(nullable = true, unique = false)
	private String version;

	@Column(nullable = true, unique = true)
	private String artifactId;

	@OneToMany(mappedBy = "groupIds")
	private Set<Entities> entities = new HashSet<Entities>();

	@OneToMany(mappedBy = "groupIds")
	private Set<Links> links = new HashSet<Links>();

	@OneToMany(mappedBy = "groupIds")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@ManyToOne
	private DomainModels domainModels;

	public GroupIds() {
	}

	public GroupIds(Date date, String code, String observations,
			String description, String groupId, String name, String version,
			String artifactId) {
		this.date = date;
		this.code = code;
		this.observations = observations;
		this.description = description;
		this.groupId = groupId;
		this.name = name;
		this.version = version;
		this.artifactId = artifactId;
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

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public Set<Entities> getEntities() {
		return entities;
	}
	public void setEntities(Set<Entities> entities) {
		this.entities = entities;
	}

	public Set<Links> getLinks() {
		return links;
	}
	public void setLinks(Set<Links> links) {
		this.links = links;
	}

	public Set<FilesModels> getFilesModels() {
		return filesModels;
	}
	public void setFilesModels(Set<FilesModels> filesModels) {
		this.filesModels = filesModels;
	}

	public DomainModels getDomainModels() {
		return domainModels;
	}
	public void setDomainModels(DomainModels domainModels) {
		this.domainModels = domainModels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object ojt) {
		if (this == ojt)
			return true;
		if (ojt == null)
			return false;
		if (getClass() != ojt.getClass())
			return false;

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

