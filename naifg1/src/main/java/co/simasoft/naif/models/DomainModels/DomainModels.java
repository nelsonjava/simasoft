package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class DomainModels {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String name;

	private String groupId;

	private String artifactId;

	private String version;

	private String codigo;

	private Date date;

	private String description;

	private String observaciones;

	public DomainModels() {
	}

	public DomainModels(String name, String groupId, String artifactId,
			String version, String codigo, Date date, String description,
			String observaciones) {
		this.name = name;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.codigo = codigo;
		this.date = date;
		this.description = description;
		this.observaciones = observaciones;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

} // entity

