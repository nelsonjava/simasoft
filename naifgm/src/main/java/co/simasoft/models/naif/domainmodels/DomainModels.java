package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class DomainModels implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

	@Version
	private Integer optlock;

	private long orden;

	private String codigo;

	private String version;

	private String artifactId;

	private String groupId;

	private String observaciones;

	private String description;

	private Date date;

	private String name;

	@OneToMany(mappedBy = "domainModels")
	private Set<GroupIds> groupIds = new HashSet<GroupIds>();

	@OneToMany(mappedBy = "domainModels")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@ManyToOne
	private SystemsModels systemsModels;

	public DomainModels() {
	}

	public DomainModels(String codigo, String version, String artifactId,
			String groupId, String observaciones, String description,
			Date date, String name) {
		this.codigo = codigo;
		this.version = version;
		this.artifactId = artifactId;
		this.groupId = groupId;
		this.observaciones = observaciones;
		this.description = description;
		this.date = date;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
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

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

