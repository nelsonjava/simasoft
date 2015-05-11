package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Dependency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String type;

	private String scope;

	private String urlRepository;

	private String observaciones;

	private String groupId;

	private String artifactId;

	private String version;

	@OneToMany(mappedBy = "dependency")
	private Set<Imports> imports = new HashSet<Imports>();

	public Dependency() {
	}

	public Dependency(String type, String scope, String urlRepository,
			String observaciones, String groupId, String artifactId,
			String version) {
		this.type = type;
		this.scope = scope;
		this.urlRepository = urlRepository;
		this.observaciones = observaciones;
		this.groupId = groupId;
		this.artifactId = artifactId;
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

	public String getUrlRepository() {
		return urlRepository;
	}
	public void setUrlRepository(String urlRepository) {
		this.urlRepository = urlRepository;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	public Set<Imports> getImports() {
		return imports;
	}
	public void setImports(Set<Imports> imports) {
		this.imports = imports;
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

		Dependency other = (Dependency) ojt;
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

