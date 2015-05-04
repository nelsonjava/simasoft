package co.simasoft.models.naif.relacionesejb;

import co.simasoft.models.naif.relacionesejb.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Buses implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String numero;

	private String clase;

	@OneToMany(mappedBy = "buses")
	private Set<Rutas> rutas = new HashSet<Rutas>();

	@OneToMany(mappedBy = "buses")
	private Set<PuestosBuses> puestosBuses = new HashSet<PuestosBuses>();

	public Buses() {
	}

	public Buses(String numero, String clase) {
		this.numero = numero;
		this.clase = clase;
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

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}

	public Set<Rutas> getRutas() {
		return rutas;
	}
	public void setRutas(Set<Rutas> rutas) {
		this.rutas = rutas;
	}

	public Set<PuestosBuses> getPuestosBuses() {
		return puestosBuses;
	}
	public void setPuestosBuses(Set<PuestosBuses> puestosBuses) {
		this.puestosBuses = puestosBuses;
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

		Buses other = (Buses) ojt;
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

