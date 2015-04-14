package com.naif.facturacion.model;

public class Concepto {
	
	private String nombre;
	private String mora;
	private String valorMes;
	private String total;
	
	public Concepto() {}
	
	public Concepto(String nombre, String mora, String valorMes, String total) {
		super();
		
		if ( (nombre == null) || (nombre.isEmpty()) ) {			
			return;
		}
		if ( (mora == null) || (mora.isEmpty()) ) {
			System.out.println("La mora del concepto es nula/vacia");
			return;
		}
		if ( (valorMes == null) || (valorMes.isEmpty()) ) {
			System.out.println("El valor del mes del concepto es nulo/vacio");
			return;
		}
		if ( (total == null) || (total.isEmpty()) ) {
			System.out.println("El valor total del concepto esta nulo/vacio");
			return;
		}
		
		this.nombre 	= nombre;
		this.mora 		= mora;
		this.valorMes 	= valorMes;
		this.total 		= total;
	} // end : constructor

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if ( (nombre == null) || (nombre.isEmpty()) ) {
			System.out.println("El concepto es nulo/vacio");
			return;
		}
		this.nombre = nombre;
	}

	public String getMora() {
		return mora;
	}

	public void setMora(String mora) {
		if ( (mora == null) || (mora.isEmpty()) ) {
			System.out.println("La mora del concepto es nula/vacia");
			return;
		}
		this.mora = mora;
	}

	public String getValorMes() {
		return valorMes;
	}

	public void setValorMes(String valorMes) {
		if ( (valorMes == null) || (valorMes.isEmpty()) ) {
			System.out.println("El valor del mes del concepto es nulo/vacio");
			return;
		}
		this.valorMes = valorMes;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		if ( (total == null) || (total.isEmpty()) ) {
			System.out.println("El valor total del concepto esta nulo/vacio");
			return;
		}
		this.total = total;
	}
	
}