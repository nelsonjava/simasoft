package co.simasoft.models.naif.sgdea;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.FetchType;

import javax.persistence.Column;

import co.simasoft.models.naif.sgdea.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Indexed;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;
import javax.persistence.ManyToOne;

@Indexed
@Entity
public class InventarioDocumental implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Version
	private Integer optlock;

	private double orden;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date fechaDepuracion;

	@Column(nullable = true, unique = false)
	private Integer cantidad;

	@Column(nullable = true, unique = false)
	private Integer folios;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date fechaFinal;

	@Column(nullable = true, unique = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String disposcionFinal;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date fechaInicial;

	@Column(nullable = true, unique = false)
	private Integer nroTransferencia;

	@Column(nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	@DateBridge(resolution = Resolution.YEAR)
	private Date fechaEntrega;

	@ManyToOne
	private UnidadesDocumentales unidadesDocumentales;

	@ManyToOne
	private FinalidadInventario finalidadInventario;

	public InventarioDocumental() {
	}

	public InventarioDocumental(Date fechaDepuracion, Integer cantidad,
			Integer folios, Date fechaFinal, String disposcionFinal,
			Date fechaInicial, Integer nroTransferencia, Date fechaEntrega) {
		this.fechaDepuracion = fechaDepuracion;
		this.cantidad = cantidad;
		this.folios = folios;
		this.fechaFinal = fechaFinal;
		this.disposcionFinal = disposcionFinal;
		this.fechaInicial = fechaInicial;
		this.nroTransferencia = nroTransferencia;
		this.fechaEntrega = fechaEntrega;
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

	public double getOrden() {
		return this.orden;
	}
	public void setOrden(double orden) {
		this.orden = orden;
	}

	public Date getFechaDepuracion() {
		return fechaDepuracion;
	}
	public void setFechaDepuracion(Date fechaDepuracion) {
		this.fechaDepuracion = fechaDepuracion;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getFolios() {
		return folios;
	}
	public void setFolios(Integer folios) {
		this.folios = folios;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getDisposcionFinal() {
		return disposcionFinal;
	}
	public void setDisposcionFinal(String disposcionFinal) {
		this.disposcionFinal = disposcionFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Integer getNroTransferencia() {
		return nroTransferencia;
	}
	public void setNroTransferencia(Integer nroTransferencia) {
		this.nroTransferencia = nroTransferencia;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public UnidadesDocumentales getUnidadesDocumentales() {
		return unidadesDocumentales;
	}
	public void setUnidadesDocumentales(
			UnidadesDocumentales unidadesDocumentales) {
		this.unidadesDocumentales = unidadesDocumentales;
	}

	public FinalidadInventario getFinalidadInventario() {
		return finalidadInventario;
	}
	public void setFinalidadInventario(FinalidadInventario finalidadInventario) {
		this.finalidadInventario = finalidadInventario;
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

		InventarioDocumental other = (InventarioDocumental) ojt;
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

