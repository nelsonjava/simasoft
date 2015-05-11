package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class GroupIds implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String codigo;

	private Date date;

	private String artifactId;

	private String version;

	private String name;

	private String groupId;

	private String description;

	private String observaciones;

	@OneToMany(mappedBy = "groupIds")
	private Set<Entities> entities = new HashSet<Entities>();

	@OneToMany(mappedBy = "groupIds")
	private Set<LinksModels> linksModels = new HashSet<LinksModels>();

	@OneToMany(mappedBy = "groupIds")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@ManyToOne
	private DomainModels domainModels;

	public GroupIds() {
	}

	public GroupIds(String codigo, Date date, String artifactId,
			String version, String name, String groupId, String description,
			String observaciones) {
		this.codigo = codigo;
		this.date = date;
		this.artifactId = artifactId;
		this.version = version;
		this.name = name;
		this.groupId = groupId;
		this.description = description;
		this.observaciones = observaciones;
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

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set<Entities> getEntities() {
		return entities;
	}
	public void setEntities(Set<Entities> entities) {
		this.entities = entities;
	}

	public Set<LinksModels> getLinksModels() {
		return linksModels;
	}
	public void setLinksModels(Set<LinksModels> linksModels) {
		this.linksModels = linksModels;
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

