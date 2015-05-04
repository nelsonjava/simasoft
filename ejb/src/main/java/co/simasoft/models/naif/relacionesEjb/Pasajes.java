package co.simasoft.models.naif.relacionesejb;

import co.simasoft.models.naif.relacionesejb.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Pasajes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private Integer numero;

	private float valor;

	@ManyToOne
	private Rutas rutas;

	@ManyToMany
	private Set<PuestosBuses> puestosBuses = new HashSet<PuestosBuses>();

	@ManyToMany(mappedBy = "pasajes")
	private Set<Personas> personas = new HashSet<Personas>();

	public Pasajes() {
	}

	public Pasajes(Integer numero, float valor) {
		this.numero = numero;
		this.valor = valor;
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

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public Rutas getRutas() {
		return rutas;
	}
	public void setRutas(Rutas rutas) {
		this.rutas = rutas;
	}

	public Set<PuestosBuses> getPuestosBuses() {
		return puestosBuses;
	}
	public void setPuestosBuses(Set<PuestosBuses> puestosBuses) {
		this.puestosBuses = puestosBuses;
	}

	public Set<Personas> getPersonas() {
		return personas;
	}
	public void setPersonas(Set<Personas> personas) {
		this.personas = personas;
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

		Pasajes other = (Pasajes) ojt;
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

