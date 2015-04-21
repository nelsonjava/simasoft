package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class FilesModels implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String codigo;

	private String archivo;

	private String observacion;

	private String type;

	private String extension;

	@ManyToOne
	private DomainModels domainModels;

	@ManyToOne
	private SystemsModels systemsModels;

	@ManyToOne
	private Packages packages;

	@ManyToOne
	private Entities entities;

	public FilesModels() {
	}

	public FilesModels(String codigo, String archivo, String observacion,
			String type, String extension) {
		this.codigo = codigo;
		this.archivo = archivo;
		this.observacion = observacion;
		this.type = type;
		this.extension = extension;
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

	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public DomainModels getDomainModels() {
		return domainModels;
	}
	public void setDomainModels(DomainModels domainModels) {
		this.domainModels = domainModels;
	}

	public SystemsModels getSystemsModels() {
		return systemsModels;
	}
	public void setSystemsModels(SystemsModels systemsModels) {
		this.systemsModels = systemsModels;
	}

	public Packages getPackages() {
		return packages;
	}
	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public Entities getEntities() {
		return entities;
	}
	public void setEntities(Entities entities) {
		this.entities = entities;
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

		FilesModels other = (FilesModels) ojt;
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

