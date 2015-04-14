package com.naif.facturacion.model;

import java.util.ArrayList;

import co.simasoft.dbf.DBFReader;
import co.simasoft.dbf.file.DBFFile;
import co.simasoft.dbf.file.DBFRecord;

import com.naif.facturacion.util.GeneratorEngine;

public class RecibosDbf {

	private String cNROFACCAA;	
	private String cCODIGOEST;
	private String cNOMEMPREC;	
	private String cCODEMPCON;
	private String cCODFACCAR;	
	private String cEMPPALREC;
	private String cNRONITREC;	
	private String cNOMBANREC;
	private String cNROCTABAN;
	private String cNOMBREREC;
	private String cCODREFREC;
	private String cCODIGOGRU;
	private String cFECFACPAG;
	private String cPAGOPOPAG;
	private String cPAGEXTPAG;
	private String cPERFACREC;
	private String cNOMCO1REC;
	private String cVLRMO1REC;
	private String cVLRME1REC;
	private String cVLRTO1REC;
	private String cNOMCO2REC;
	private String cVLRMO2REC;
	private String cVLRME2REC;
	private String cVLRTO2REC;
	private String cNOMCO3REC;
	private String cVLRMO3REC;
	private String cVLRME3REC;
	private String cVLRTO3REC;
	private String cNOMCO4REC;
	private String cVLRMO4REC;
	private String cVLRME4REC;
	private String cVLRTO4REC;
	private String cNOMCO5REC;
	private String cVLRMO5REC;
	private String cVLRME5REC;
	private String cVLRTO5REC;
	private String cNOMCO6REC;
	private String cVLRMO6REC;
	private String cVLRME6REC;
	private String cVLRTO6REC;
	private String cNOMCO7REC;
	private String cVLRMO7REC;
	private String cVLRME7REC;
	private String cVLRTO7REC;
	private String cNOMCO8REC;
	private String cVLRMO8REC;
	private String cVLRME8REC;
	private String cVLRTO8REC;	
	private String cVLROPOREC;
	private String cVLREXTREC;
	private String cCODEANREC;
	private String cBAROPOREC;
	private String cBAREXTREC;
	private String cCODEQRREC;
	private String cTXTUNOREC;
	private String cTXTDOSREC;
	
	private DBFFile dbf;	
	private DBFRecord registro;
	private ArrayList<DBFRecord> registros;

	public RecibosDbf(String sFile) {
		dbf = new DBFReader().readDBFFile(sFile);
		registros = dbf.getRecords();
	}
	
	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//
	
	public ArrayList<String> getIds(String id) {

		ArrayList<String> ids = new ArrayList<String>();

		for (DBFRecord registro : registros) {
			ids.add((String) registro.getField(id));
		}

		return ids;
	}

	public void seek(String xCodigo, String cCodigo) {
		registro = dbf.getRecord(xCodigo, cCodigo);
		setRegistro();
	}
	
	public void setRegistro() {		
		this.cNROFACCAA = (String) registro.getField("CNROFACCAA");		
		this.cNOMEMPREC = (String) registro.getField("CNOMEMPREC");		
		this.cCODEMPCON = (String) registro.getField("CCODEMPCON");		
		this.cCODFACCAR = (String) registro.getField("CCODFACCAR");		
		this.cEMPPALREC = (String) registro.getField("CEMPPALREC");		
		this.cNRONITREC = (String) registro.getField("CNRONITREC");
		this.cCODIGOEST = (String) registro.getField("CCODIGOEST");
		this.cNOMBANREC = (String) registro.getField("CNOMBANREC");
		this.cNROCTABAN = (String) registro.getField("CNROCTABAN");
		this.cNOMBREREC = (String) registro.getField("CNOMBREREC");
		this.cCODREFREC = (String) registro.getField("CCODREFREC");
		this.cCODIGOGRU = (String) registro.getField("CCODIGOGRU");
		this.cFECFACPAG = (String) registro.getField("CFECFACPAG");
		this.cPAGOPOPAG = (String) registro.getField("CPAGOPOPAG");
		this.cPAGEXTPAG = (String) registro.getField("CPAGEXTPAG");
		this.cPERFACREC = (String) registro.getField("CPERFACREC");
		this.cNOMCO1REC = (String) registro.getField("CNOMCO1REC");
		this.cVLRMO1REC = (String) registro.getField("CVLRMO1REC");
		this.cVLRME1REC = (String) registro.getField("CVLRME1REC");
		this.cVLRTO1REC = (String) registro.getField("CVLRTO1REC");
		this.cNOMCO2REC = (String) registro.getField("CNOMCO2REC");
		this.cVLRMO2REC = (String) registro.getField("CVLRMO2REC");
		this.cVLRME2REC = (String) registro.getField("CVLRME2REC");
		this.cVLRTO2REC = (String) registro.getField("CVLRTO2REC");
		this.cNOMCO3REC = (String) registro.getField("CNOMCO3REC");
		this.cVLRMO3REC = (String) registro.getField("CVLRMO3REC");
		this.cVLRME3REC = (String) registro.getField("CVLRME3REC");
		this.cVLRTO3REC = (String) registro.getField("CVLRTO3REC");
		this.cNOMCO4REC = (String) registro.getField("CNOMCO4REC");
		this.cVLRMO4REC = (String) registro.getField("CVLRMO4REC");
		this.cVLRME4REC = (String) registro.getField("CVLRME4REC");
		this.cVLRTO4REC = (String) registro.getField("CVLRTO4REC");
		this.cNOMCO5REC = (String) registro.getField("CNOMCO5REC");
		this.cVLRMO5REC = (String) registro.getField("CVLRMO5REC");
		this.cVLRME5REC = (String) registro.getField("CVLRME5REC");
		this.cVLRTO5REC = (String) registro.getField("CVLRTO5REC");
		this.cNOMCO6REC = (String) registro.getField("CNOMCO6REC");
		this.cVLRMO6REC = (String) registro.getField("CVLRMO6REC");
		this.cVLRME6REC = (String) registro.getField("CVLRME6REC");
		this.cVLRTO6REC = (String) registro.getField("CVLRTO6REC");
		this.cNOMCO7REC = (String) registro.getField("CNOMCO7REC");
		this.cVLRMO7REC = (String) registro.getField("CVLRMO7REC");
		this.cVLRME7REC = (String) registro.getField("CVLRME7REC");
		this.cVLRTO7REC = (String) registro.getField("CVLRTO7REC");
		this.cNOMCO8REC = (String) registro.getField("CNOMCO8REC");
		this.cVLRMO8REC = (String) registro.getField("CVLRMO8REC");
		this.cVLRME8REC = (String) registro.getField("CVLRME8REC");
		this.cVLRTO8REC = (String) registro.getField("CVLRTO8REC");
		this.cVLROPOREC = (String) registro.getField("CVLROPOREC");
		this.cVLREXTREC = (String) registro.getField("CVLREXTREC");
		this.cCODEANREC = (String) registro.getField("CCODEANREC");		
		this.cBAROPOREC = (String) registro.getField("CBAROPOREC");
		this.cBAREXTREC = (String) registro.getField("CBAREXTREC");		
		this.cCODEQRREC = (String) registro.getField("CCODEQRREC");	
		this.cTXTUNOREC = (String) registro.getField("CTXTUNOREC");
		this.cTXTDOSREC = (String) registro.getField("CTXTDOSREC");		
	}

	public void viewRegistro(String xCodigo, String cCodigo) {

		seek(xCodigo, cCodigo);

		System.out
				.println("-----------------------Detalle-de Registro-----------------------");
			
		System.out.println("CNROFACCAA:" + getCNROFACCAA());
		System.out.println("CCODIGOEST:" + getCCODIGOEST());
		System.out.println("CNOMEMPREC:" + getCNOMEMPREC());
		System.out.println("CEMPPALREC:" + getCEMPPALREC());		
		System.out.println("CNRONITCON:" + getCNRONITREC());		
		System.out.println("CNOMBANREC:" + getCNOMBANREC());
		System.out.println("CNROCTABAN:" + getCNROCTABAN());
		System.out.println("CNOMBREREC:" + getCNOMBREREC());
		System.out.println("CCODREFREC:" + getCCODREFREC());
		System.out.println("CCODIGOGRU:" + getCCODIGOGRU());
		System.out.println("CFECFACPAG:" + getCFECFACPAG());
		System.out.println("CPAGOPOPAG:" + getCPAGOPOPAG());
		System.out.println("CPAGEXTPAG:" + getCPAGEXTPAG());
		System.out.println("CPERFACREC:" + getCPERFACREC());
		System.out.println("CNOMCO1REC:" + getCNOMCO1REC());
		System.out.println("CVLRMO1REC:" + getCVLRMO1REC());
		System.out.println("CVLRME1REC:" + getCVLRME1REC());
		System.out.println("CVLRTO1REC:" + getCVLRTO1REC());
		System.out.println("CNOMCO2REC:" + getCNOMCO2REC());
		System.out.println("CVLRMO2REC:" + getCVLRMO2REC());
		System.out.println("CVLRME2REC:" + getCVLRME2REC());
		System.out.println("CVLRTO2REC:" + getCVLRTO2REC());
		System.out.println("CNOMCO3REC:" + getCNOMCO3REC());
		System.out.println("CVLRMO3REC:" + getCVLRMO3REC());
		System.out.println("CVLRME3REC:" + getCVLRME3REC());
		System.out.println("CVLRTO3REC:" + getCVLRTO3REC());
		System.out.println("CNOMCO4REC:" + getCNOMCO4REC());
		System.out.println("CVLRMO4REC:" + getCVLRMO4REC());
		System.out.println("CVLRME4REC:" + getCVLRME4REC());
		System.out.println("CVLRTO4REC:" + getCVLRTO4REC());
		System.out.println("CNOMCO5REC:" + getCNOMCO5REC());
		System.out.println("CVLRMO5REC:" + getCVLRMO5REC());
		System.out.println("CVLRME5REC:" + getCVLRME5REC());
		System.out.println("CVLRTO5REC:" + getCVLRTO5REC());
		System.out.println("CNOMCO6REC:" + getCNOMCO6REC());
		System.out.println("CVLRMO6REC:" + getCVLRMO6REC());
		System.out.println("CVLRME6REC:" + getCVLRME6REC());
		System.out.println("CVLRTO6REC:" + getCVLRTO6REC());
		System.out.println("CNOMCO7REC:" + getCNOMCO7REC());
		System.out.println("CVLRMO7REC:" + getCVLRMO7REC());
		System.out.println("CVLRME7REC:" + getCVLRME7REC());
		System.out.println("CVLRTO7REC:" + getCVLRTO7REC());
		System.out.println("CNOMCO8REC:" + getCNOMCO8REC());
		System.out.println("CVLRMO8REC:" + getCVLRMO8REC());
		System.out.println("CVLRME8REC:" + getCVLRME8REC());
		System.out.println("CVLRTO8REC:" + getCVLRTO8REC());
		System.out.println("CVLROPOREC:" + getCVLROPOREC());
		System.out.println("CVLREXTREC:" + getCVLREXTREC());
		System.out.println("CVLREXTREC:" + getCCODEANREC());
		System.out.println("CBAROPOREC:" + getCBAROPOREC());
		System.out.println("CBAREXTREC:" + getCBAREXTREC());		
		System.out.println("CCODEQRREC:" + getCCODEQRREC());		
		System.out.println("CTXTUNOREC:" + getCTXTUNOREC());
		System.out.println("CTXTDOSREC:" + getCTXTDOSREC());	
		System.out.println();
	}

	public void viewRegistros(String xCodigo) {

		ArrayList<String> codigos = null;
		codigos = getIds(xCodigo);

		for (String codigo : codigos) {
			viewRegistro(xCodigo, codigo);
		} // for

	} // viewRegistros

	// TODO : ALL RECEIPTS PDF
	public void recibosPdf() {

		ArrayList<String> codigos = null;
		codigos = getIds("CCODIGOEST");

		for (String codigo : codigos) {

			seek("CCODIGOEST", codigo);

			Recibo01 paramsConRecibo = new Recibo01();
			asignarParamsARecibo(paramsConRecibo);

			GeneratorEngine reciboPdf = new GeneratorEngine();
			reciboPdf.createPDF("C:\\models\\pdf", paramsConRecibo);

			System.out.println("PDF:" + paramsConRecibo.getReferencia());
			System.out.println();

		} // for

	} // end : recibosPdf Method

	public void asignarParamsARecibo(Recibo01 recibo) {

		// ENCABEZADO
		recibo.setEmpresa(getCNOMEMPREC());
		recibo.setEmpresaCod(getCCODEMPCON());
		recibo.setEmpresaPal(getCEMPPALREC());
		recibo.setEmpresaNit(getCNRONITREC());	
		recibo.setReciboNo(getCNROFACCAA());
		
		// ESTUDIANTE y BANCO
		recibo.setBanco(getCNOMBANREC());
		recibo.setNumCuenta(getCNROCTABAN());		
		recibo.setNombreEst(getCNOMBREREC());
		
		// REFERENCIA Y FACTURADO
		recibo.setReferencia(getCCODREFREC());
		recibo.setCodFactura(getCCODFACCAR());
		recibo.setCursoEst(getCCODIGOGRU());
		recibo.setFechaFacturacion(getCFECFACPAG());
		recibo.setMesesAPagar(getCPERFACREC());
		
		// CONCEPTOS //
		recibo.addConcepto(
			new Concepto(getCNOMCO1REC(), getCVLRMO1REC(), 
					     getCVLRME1REC(), getCVLRTO1REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO2REC(), getCVLRMO2REC(), 
					     getCVLRME2REC(), getCVLRTO2REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO3REC(), getCVLRMO3REC(), 
					     getCVLRME3REC(), getCVLRTO3REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO4REC(), getCVLRMO4REC(), 
					     getCVLRME4REC(), getCVLRTO4REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO5REC(), getCVLRMO5REC(), 
					     getCVLRME5REC(), getCVLRTO5REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO6REC(), getCVLRMO6REC(), 
					     getCVLRME6REC(), getCVLRTO6REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO7REC(), getCVLRMO7REC(), 
					     getCVLRME7REC(), getCVLRTO7REC())
		);
		recibo.addConcepto(
			new Concepto(getCNOMCO8REC(), getCVLRMO8REC(), 
					     getCVLRME8REC(), getCVLRTO8REC())
		);
		
		// FECHAS LIMITE
		recibo.setFechaPagoOportuno(getCPAGOPOPAG());
		recibo.setValorPagoOportuno(getCVLROPOREC());
		recibo.setFechaPagoExtemporaneo(getCPAGEXTPAG());
		recibo.setValorPagoExtemporaneo(getCVLREXTREC());
		recibo.setEan13(getCCODEANREC());	
		recibo.setBarcodeQR(getCCODEQRREC());		
		
		// TEXTO ADICIONAL		
		recibo.setInfoAdicional1(getCTXTUNOREC());
		recibo.setInfoAdicional2(getCTXTDOSREC());
	} // end : asignarParamsARecibo Method	
	
	
	// GETTERS AND SETTERS //

	public String getCCODIGOEST() {
		return cCODIGOEST;
	}
		
	public String getCNOMEMPREC() {
		return cNOMEMPREC;
	}
	
	public String getCCODEMPCON() {
		return cCODEMPCON;
	}
	
	public String getCCODFACCAR() {
		return cCODFACCAR;
	}
	
	public String getCEMPPALREC() {
		return cEMPPALREC;
	}

	public String getCNRONITREC() {
		return cNRONITREC;
	}

	public String getCNROFACCAA() {
		return cNROFACCAA;
	}

	public String getCNOMBANREC() {
		return cNOMBANREC;
	}

	public String getCNROCTABAN() {
		return cNROCTABAN;
	}

	public String getCNOMBREREC() {
		return cNOMBREREC;
	}

	public String getCCODREFREC() {
		return cCODREFREC;
	}

	public String getCCODIGOGRU() {
		return cCODIGOGRU;
	}

	public String getCFECFACPAG() {
		return cFECFACPAG;
	}

	public String getCPAGOPOPAG() {
		return cPAGOPOPAG;
	}

	public String getCPAGEXTPAG() {
		return cPAGEXTPAG;
	}

	public String getCPERFACREC() {
		return cPERFACREC;
	}

	public String getCNOMCO1REC() {
		return cNOMCO1REC;
	}

	public String getCVLRMO1REC() {
		return cVLRMO1REC;
	}

	public String getCVLRME1REC() {
		return cVLRME1REC;
	}

	public String getCVLRTO1REC() {
		return cVLRTO1REC;
	}

	public String getCNOMCO2REC() {
		return cNOMCO2REC;
	}

	public String getCVLRMO2REC() {
		return cVLRMO2REC;
	}

	public String getCVLRME2REC() {
		return cVLRME2REC;
	}

	public String getCVLRTO2REC() {
		return cVLRTO2REC;
	}

	public String getCNOMCO3REC() {
		return cNOMCO3REC;
	}

	public String getCVLRMO3REC() {
		return cVLRMO3REC;
	}

	public String getCVLRME3REC() {
		return cVLRME3REC;
	}

	public String getCVLRTO3REC() {
		return cVLRTO3REC;
	}

	public String getCNOMCO4REC() {
		return cNOMCO4REC;
	}

	public String getCVLRMO4REC() {
		return cVLRMO4REC;
	}

	public String getCVLRME4REC() {
		return cVLRME4REC;
	}

	public String getCVLRTO4REC() {
		return cVLRTO4REC;
	}

	public String getCNOMCO5REC() {
		return cNOMCO5REC;
	}

	public String getCVLRMO5REC() {
		return cVLRMO5REC;
	}

	public String getCVLRME5REC() {
		return cVLRME5REC;
	}

	public String getCVLRTO5REC() {
		return cVLRTO5REC;
	}

	public String getCNOMCO6REC() {
		return cNOMCO6REC;
	}

	public String getCVLRMO6REC() {
		return cVLRMO6REC;
	}

	public String getCVLRME6REC() {
		return cVLRME6REC;
	}

	public String getCVLRTO6REC() {
		return cVLRTO6REC;
	}

	public String getCNOMCO7REC() {
		return cNOMCO7REC;
	}

	public String getCVLRMO7REC() {
		return cVLRMO7REC;
	}

	public String getCVLRME7REC() {
		return cVLRME7REC;
	}

	public String getCVLRTO7REC() {
		return cVLRTO7REC;
	}

	public String getCNOMCO8REC() {
		return cNOMCO8REC;
	}

	public String getCVLRMO8REC() {
		return cVLRMO8REC;
	}

	public String getCVLRME8REC() {
		return cVLRME8REC;
	}

	public String getCVLRTO8REC() {
		return cVLRTO8REC;
	}

	public String getCVLROPOREC() {
		return cVLROPOREC;
	}

	public String getCVLREXTREC() {
		return cVLREXTREC;
	}
	
	public String getCCODEANREC() {
		return cCODEANREC;
	}	

	public String getCBAROPOREC() {
		return cBAROPOREC;
	}
	
	public String getCBAREXTREC() {
		return cBAREXTREC;
	}
	
	public String getCCODEQRREC() {
		return cCODEQRREC;
	}

	public String getCTXTUNOREC() {
		return cTXTUNOREC;
	}

	public String getCTXTDOSREC() {
		return cTXTDOSREC;
	}
	
	public ArrayList<DBFRecord> getRegistros() {
		return registros;
	}

}