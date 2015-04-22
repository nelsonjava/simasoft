package co.simasoft.models.naif.DomainModels;

import co.simasoft.models.naif.DomainModels.*;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class TiposLinksModels {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private Integer optlock;

	private String nombre;

	@OneToMany(mappedBy = "tiposLinksModels")
	private Set<LinksModels> linksModels = new HashSet<LinksModels>();

	public TiposLinksModels() {
	}

	public TiposLinksModels(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<LinksModels> getLinksModels() {
		return linksModels;
	}

	public void setLinksModels(Set<LinksModels> linksModels) {
		this.linksModels = linksModels;
	}

} // entity

