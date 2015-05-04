package co.simasoft.models.naif.relacionesejb;

import co.simasoft.models.naif.relacionesejb.*;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class PuestosBuses implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private long orden;

	private String numero;

	private boolean ventanilla;

	@ManyToOne
	private Buses buses;

	public PuestosBuses() {
	}

	public PuestosBuses(String numero, boolean ventanilla) {
		this.numero = numero;
		this.ventanilla = ventanilla;
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

	public boolean getVentanilla() {
		return ventanilla;
	}
	public void setVentanilla(boolean ventanilla) {
		this.ventanilla = ventanilla;
	}

	public Buses getBuses() {
		return buses;
	}
	public void setBuses(Buses buses) {
		this.buses = buses;
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

		PuestosBuses other = (PuestosBuses) ojt;
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

