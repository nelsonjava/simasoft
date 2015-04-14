package com.naif.facturacion.model;

import java.util.ArrayList;

/**
 * Data structure to create a bill.
 */
public class Recibo01 {
	
	private String 	empresa = "";
	private String 	empresaCod = "";
	private String 	empresaPal = "";
	private String 	empresaNit = "";
	private String 	codFactura = "";
	private String 	reciboNo = "";
	private String 	nombreEst = "";
	private String 	banco = "";
	private String 	numCuenta = "";	
	private String 	referencia = "";
	private String 	cursoEst = "";	
	private String 	fechaFacturacion = "";	
	private String 	mesesAPagar = "";
	private ArrayList<Concepto> conceptos;	
	private String	fechaPagoOportuno = "";
	private String 	valorPagoOportuno = "";
	private String 	fechaPagoExtemporaneo = "";
	private String 	valorPagoExtemporaneo = "";
	private String  ean13 = "";
	private String  barcodeQR = "";
	private String  infoAdicional1 = "";
	private String  infoAdicional2 = "";
	
	public Recibo01() {
		conceptos = new ArrayList<Concepto>();
	} // end : constructor
	
	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//
	
	public void addConcepto(Concepto concepto) {
		conceptos.add(concepto);
	} // end : addConcepto Method
	
	public void clearConceptos() {
		conceptos.clear();
	} // end : clearConceptos Method
	
	// GETTERS AND SETTERS //
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {		
		if (empresa == null) {			
			return;
		}
		this.empresa = empresa;		
	}
	
	public String getEmpresaCod() {
		return empresaCod;
	}
	
	public void setEmpresaCod(String empresaCod) {
		if (empresaCod == null) {
			System.out.println("El codigo de la empresa es nulo");
			return;
		}
		this.empresaCod = empresaCod;		
	}

	public String getEmpresaPal() {
		return empresaPal;
	}

	public void setEmpresaPal(String empresaPal) {
		if (empresaPal == null) {
			System.out.println("La empresa principal es nula");
			return;
		}
		this.empresaPal = empresaPal;		
	}

	public String getEmpresaNit() {
		return empresaNit;
	}

	public void setEmpresaNit(String empresaNit) {		
		if (empresaNit == null) {			
			return;
		}
		this.empresaNit = empresaNit;
	}
	
	public String getCodFactura() {
		return codFactura;
	}
	
	public void setCodFactura(String codFactura) {		
		if (codFactura == null) {			
			return;
		}
		this.codFactura = codFactura;
	}
		
	public String getReciboNo() {
		return reciboNo;
	}

	public void setReciboNo(String reciboNo) {
		if ( (reciboNo == null) || (reciboNo.isEmpty()) ) {
			System.out.println("El numero del recibo es nulo/vacio");
			return;
		}
		this.reciboNo = reciboNo;
	}	
	
	public String getNombreEst() {
		return nombreEst;
	}

	public void setNombreEst(String nombreEst) {
		if ( (nombreEst == null) || (nombreEst.isEmpty()) ) {
			System.out.println("El nombre del estudiante es nulo/vacio");
			return;
		}
		this.nombreEst = nombreEst;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		if (banco == null) {
			return;
		}
		this.banco = banco;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		if (numCuenta == null) {
			return;
		}
		this.numCuenta = numCuenta;
	}		
		
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		if (referencia == null) {
			System.out.println("La referencia es nula");
			return;
		}
		/*
		if (referencia.length() != 10) {
			System.out.println("La referencia necesita 10 digitos");
			return;
		}*/
		this.referencia = referencia.trim();
	}

	public String getCursoEst() {
		return cursoEst;
	}

	public void setCursoEst(String cursoEst) {
		if (cursoEst == null) {			
			return;
		}
		this.cursoEst = cursoEst;
	}

	public String getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(String fechaFacturacion) {
		if (fechaFacturacion == null) {
			System.out.println("La fecha de facturacion del recibo es nula");
			return;
		}
		this.fechaFacturacion = fechaFacturacion;
	}
	
	public String getMesesAPagar() {
		return mesesAPagar;
	}

	public void setMesesAPagar(String mesesAPagar) {
		if (mesesAPagar == null) {
			System.out.println("El periodo de meses a pagar es nulo");
			return;
		}		
		this.mesesAPagar = mesesAPagar;
	}	
	
	public ArrayList<Concepto> getConceptos() {
		return conceptos;
	}

	public String getFechaPagoOportuno() {
		return fechaPagoOportuno;
	}

	public void setFechaPagoOportuno(String fechaPagoOportuno) {
		if (fechaPagoOportuno == null) {
			System.out.println("La fecha del pago oportuno es nula");
			return;
		}
		this.fechaPagoOportuno = fechaPagoOportuno;
	}

	public String getValorPagoOportuno() {
		return valorPagoOportuno;
	}

	public void setValorPagoOportuno(String valorPagoOportuno) {
		if (valorPagoOportuno == null) {
			System.out.println("El valor del pago oportuno es nulo");
			return;
		}
		this.valorPagoOportuno = valorPagoOportuno;
	}

	public String getFechaPagoExtemporaneo() {
		return fechaPagoExtemporaneo;
	}

	public void setFechaPagoExtemporaneo(String fechaPagoExtemporaneo) {
		if (fechaPagoExtemporaneo == null) {
			System.out.println("La fecha del pago extemporaneo es nula");
			return;
		}
		this.fechaPagoExtemporaneo = fechaPagoExtemporaneo;
	}

	public String getValorPagoExtemporaneo() {
		return valorPagoExtemporaneo;
	}

	public void setValorPagoExtemporaneo(String valorPagoExtemporaneo) {
		if (valorPagoExtemporaneo == null) {
			System.out.println("El valor del pago extemporaneo es nulo");
			return;
		}
		this.valorPagoExtemporaneo = valorPagoExtemporaneo;
	}

	public String getEan13() {
		return ean13;
	}

	public void setEan13(String ean13) {		
		if (ean13 == null) {
			System.out.println("El codigo EAN-13 es nulo.");
			return;
		}		
		if (ean13.length() != 13) {
			System.out.println("El codigo EAN-13 necesita 13 digitos.");
			return;
		}
		this.ean13 = ean13;
	}
	
	public String getBarcodeQR() {
		return barcodeQR;
	}	
	
	public void setBarcodeQR(String barcodeQR) {		
		if (barcodeQR == null) {			
			return;
		}	
		this.barcodeQR = barcodeQR;
	}	
	
	public String getInfoAdicional1() {
		return infoAdicional1;
	}

	public void setInfoAdicional1(String infoAdicional1) {
		if (infoAdicional1 == null) {
			System.out.println("La informacion adicional(1) del recibo es nula.");
			return;
		}
		this.infoAdicional1 = infoAdicional1;
	}
	
	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		if (infoAdicional2 == null) {
			System.out.println("La informacion adicional(2) del recibo es nula.");
			return;
		}
		this.infoAdicional2 = infoAdicional2;
	}	
	
}