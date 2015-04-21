package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Packages implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String name;

	private String description;

	private String artifactId;

	private String observaciones;

	private Date date;

	private String codigo;

	private String groupId;

	private String version;

	@OneToMany(mappedBy = "packagess")
	private Set<Entities> entities = new HashSet<Entities>();

	@OneToMany(mappedBy = "packages")
	private Set<LinksModels> linksModels = new HashSet<LinksModels>();

	@OneToMany(mappedBy = "packages")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@ManyToOne
	private DomainModels domainModels;

	public Packages() {
	}

	public Packages(String name, String description, String artifactId,
			String observaciones, Date date, String codigo, String groupId,
			String version) {
		this.name = name;
		this.description = description;
		this.artifactId = artifactId;
		this.observaciones = observaciones;
		this.date = date;
		this.codigo = codigo;
		this.groupId = groupId;
		this.version = version;
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

	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

		Packages other = (Packages) ojt;
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

