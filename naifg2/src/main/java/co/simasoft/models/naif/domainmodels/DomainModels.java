package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class DomainModels implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private Date date;

	private String codigo;

	private String observaciones;

	private String description;

	private String groupId;

	private String name;

	private String version;

	private String artifactId;

	@OneToMany(mappedBy = "domainModels")
	private Set<GroupIds> groupIds = new HashSet<GroupIds>();

	@OneToMany(mappedBy = "domainModels")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@ManyToOne
	private SystemsModels systemsModels;

	public DomainModels() {
	}

	public DomainModels(Date date, String codigo, String observaciones,
			String description, String groupId, String name, String version,
			String artifactId) {
		this.date = date;
		this.codigo = codigo;
		this.observaciones = observaciones;
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

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public Set<GroupIds> getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(Set<GroupIds> groupIds) {
		this.groupIds = groupIds;
	}

	public Set<FilesModels> getFilesModels() {
		return filesModels;
	}
	public void setFilesModels(Set<FilesModels> filesModels) {
		this.filesModels = filesModels;
	}

	public SystemsModels getSystemsModels() {
		return systemsModels;
	}
	public void setSystemsModels(SystemsModels systemsModels) {
		this.systemsModels = systemsModels;
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

