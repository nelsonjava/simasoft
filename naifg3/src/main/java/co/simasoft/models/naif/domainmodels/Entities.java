package co.simasoft.models.naif.domainmodels;

import co.simasoft.models.naif.domainmodels.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Entities implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String serialID;

	private String tabla;

	private String tablaSecuencia;

	private String modifier;

	private String name;

	private String description;

	private String observaciones;

	private String extend;

	private String imports;

	private String annotations;

	private String source;

	@OneToMany(mappedBy = "from")
	private Set<Relationships> from = new HashSet<Relationships>();

	@OneToMany(mappedBy = "entities")
	private Set<FilesModels> filesModels = new HashSet<FilesModels>();

	@OneToMany(mappedBy = "entities")
	private Set<Attributes> attributes = new HashSet<Attributes>();

	@OneToMany(mappedBy = "to")
	private Set<Relationships> to = new HashSet<Relationships>();

	@OneToMany(mappedBy = "entities")
	private Set<NameQueries> nameQueries = new HashSet<NameQueries>();

	@ManyToOne
	private GroupIds groupIds;

	public Entities() {
	}

	public Entities(String serialID, String tabla, String tablaSecuencia,
			String modifier, String name, String description,
			String observaciones, String extend, String imports,
			String annotations, String source) {
		this.serialID = serialID;
		this.tabla = tabla;
		this.tablaSecuencia = tablaSecuencia;
		this.modifier = modifier;
		this.name = name;
		this.description = description;
		this.observaciones = observaciones;
		this.extend = extend;
		this.imports = imports;
		this.annotations = annotations;
		this.source = source;
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

	public String getSerialID() {
		return serialID;
	}
	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTablaSecuencia() {
		return tablaSecuencia;
	}
	public void setTablaSecuencia(String tablaSecuencia) {
		this.tablaSecuencia = tablaSecuencia;
	}

	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
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

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getImports() {
		return imports;
	}
	public void setImports(String imports) {
		this.imports = imports;
	}

	public String getAnnotations() {
		return annotations;
	}
	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public Set<Relationships> getFrom() {
		return from;
	}
	public void setFrom(Set<Relationships> from) {
		this.from = from;
	}

	public Set<FilesModels> getFilesModels() {
		return filesModels;
	}
	public void setFilesModels(Set<FilesModels> filesModels) {
		this.filesModels = filesModels;
	}

	public Set<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}

	public Set<Relationships> getTo() {
		return to;
	}
	public void setTo(Set<Relationships> to) {
		this.to = to;
	}

	public Set<NameQueries> getNameQueries() {
		return nameQueries;
	}
	public void setNameQueries(Set<NameQueries> nameQueries) {
		this.nameQueries = nameQueries;
	}

	public GroupIds getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(GroupIds groupIds) {
		this.groupIds = groupIds;
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

		Entities other = (Entities) ojt;
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

