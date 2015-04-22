package co.simasoft.naif.models.DomainModels;

import co.simasoft.naif.models.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Entities {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String name;

	private String serialID;

	private String tabla;

	private String tablaSecuencia;

	private String modifier;

	private String extend;

	private String imports;

	private String annotations;

	private String source;

	private String description;

	private String observaciones;

	public Entities() {
	}

	public Entities(String name, String serialID, String tabla,
			String tablaSecuencia, String modifier, String extend,
			String imports, String annotations, String source,
			String description, String observaciones) {
		this.name = name;
		this.serialID = serialID;
		this.tabla = tabla;
		this.tablaSecuencia = tablaSecuencia;
		this.modifier = modifier;
		this.extend = extend;
		this.imports = imports;
		this.annotations = annotations;
		this.source = source;
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

