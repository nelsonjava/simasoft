package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class LinksModels {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String titulo;

	private String link;

	private String observacion;

	@ManyToOne
	private TiposLinksModels tiposLinksModels;

	@ManyToOne
	private DomainModels domainModels;

	public LinksModels() {
	}

	public LinksModels(String titulo, String link, String observacion) {
		this.titulo = titulo;
		this.link = link;
		this.observacion = observacion;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TiposLinksModels getTiposLinksModels() {
		return tiposLinksModels;
	}

	public void setTiposLinksModels(TiposLinksModels tiposLinksModels) {
		this.tiposLinksModels = tiposLinksModels;
	}

	public DomainModels getDomainModels() {
		return domainModels;
	}

	public void setDomainModels(DomainModels domainModels) {
		this.domainModels = domainModels;
	}

} // entity

