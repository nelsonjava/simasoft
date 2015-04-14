package com.naif.facturacion.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.naif.facturacion.model.Concepto;
import com.naif.facturacion.model.Recibo01;
import com.naif.facturacion.model.RecibosDbf;

/**
 * It generates the .PDF according to the parameters. 
 */
public class GeneratorEngine {
	
	private static JasperReport jasperReport;
	private static JasperPrint 	jasperPrint;
	
	/** To change date format in/out-put. */
	private SimpleDateFormat formatFechaSalida 	= new SimpleDateFormat("MMM dd/yyyy");
	
	
	// ______________________________________________________________//
	// ********************** PRIVATE METHODS ***********************//
	
	/**
	 * It will replace characters until leaving
	 * the whole number. 
	 * 
	 * @param valor A formated text with the value to pay.
	 * @return A number with the same value, but without any format.
	 */
	private Long cleanMoneyFormat(String valor) {
		valor = valor.replace("*", "");
		valor = valor.replace(",", "");
		
		return new Long(valor);
	} // end : cleanMoneyFormat Method	
	
	/**
	 * Process to organize information from a String date,
	 * to get the code useful for barcode generation.
	 * 
	 * @param stringDate A textual date representation.
	 * @return A textual date with the output format.
	 */
	private String adjustDateForBarcode(String stringDate) {
		try {
			if (stringDate == null) {
				throw new NullPointerException("Date string is null");
			}
			
			String 		dayofMonth 		= "";
			String 		month 			= "";			
			Calendar 	cFechaSalida 	= Calendar.getInstance();
			
			cFechaSalida.setTime(formatFechaSalida.parse(stringDate));
			
			// DAY
			if (cFechaSalida.get(Calendar.DAY_OF_MONTH) < 10) {
				dayofMonth = "0" + cFechaSalida.get(Calendar.DAY_OF_MONTH);
			} else {
				dayofMonth = ""  + cFechaSalida.get(Calendar.DAY_OF_MONTH);
			}
			
			// MONTH
			if ( (cFechaSalida.get(Calendar.MONTH) + 1) < 10 ) {
				month = "0" + (cFechaSalida.get(Calendar.MONTH) + 1);
			} else {
				month = ""  + (cFechaSalida.get(Calendar.MONTH) + 1);
			}
			
			// Final format : YEAR + MM + DD
			return cFechaSalida.get(Calendar.YEAR) + "" + month + "" + dayofMonth;
		} catch (ParseException pex) {
			pex.printStackTrace();			
			return "error";
		}		
	} // end : adjustDateForBarcode Method	
	
	/**
	 * Process to organize information from a money string,
	 * to get useful value for barcode generation.
	 * 
	 * @param stringMoney A textual money representation.
	 * @return A textual value with zeros.
	 */
	private String adjustMoneyForBarcode(String stringMoney) {
		try {
			if (stringMoney == null) {
				throw new NullPointerException("String value(money) is null");
			}
			
			Long 	money 			= cleanMoneyFormat(stringMoney);
			long 	numZeros 		= 10 - money.toString().length();
			String 	moneyWithZeros 	= "";
			
			// Adding zeros to the left
			for (int i = 0; i < numZeros; i++) {
				moneyWithZeros += "0";
			}
			moneyWithZeros += "" + money.toString();
			
			return moneyWithZeros;
		} catch (Exception e) {
			e.printStackTrace();			
			return "error";
		}	
	} // end : adjustMoneyForBarcode Method
	
	/**
	 * Method to generate a 2D barcode with a text content to
	 * become a QR code.
	 * 
	 * @param content Text used to generate QR code.
	 */ 
	private BufferedImage qr(String content) throws WriterException, IOException {		
		//String qrCodeContent = "http://worldwide.bose.com/aim/es_co/web/5.1_surround_systems/page.html";
		
		if (content == null || content.isEmpty()) {
			return null;
		}
		
		Map<EncodeHintType, Object> hintMap = new HashMap<EncodeHintType, Object>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		hintMap.put(EncodeHintType.MARGIN, 2);
			
		return MatrixToImageWriter.toBufferedImage(
			new QRCodeWriter().encode(
				content, BarcodeFormat.QR_CODE, 175, 175 // 145, 145
			)
		);			
	} // end : qr Method	
	
	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//
	
	/**
	 * Process to create a pdf file, according to some input
	 * data provided by TirillaDePrueba object.
	 * 
	 * @param pathParaRecibo Folder path to store the file.
	 * @param recibo Data structure to pass parameters.
	 * @return True, if the pdf creation was successful, otherwise false.
	 */
	public boolean createPDF(String pathParaRecibo, Recibo01 recibo) {		
		try {
			if (recibo == null) {
				System.out.println("Recibo para tirilla de pago es nulo.");
				return false;
			}
			if (pathParaRecibo == null || pathParaRecibo.isEmpty()) {
				System.out.println("Ubicacion donde se creara la tirilla de pago es nula/vacia.");
				return false;
			}
								
			// Parameters for jasper template
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			
			// Barcode data input generation
			String strDate1 = adjustDateForBarcode(recibo.getFechaPagoOportuno());
			String strDate2 = adjustDateForBarcode(recibo.getFechaPagoExtemporaneo());
			String zrs1 = adjustMoneyForBarcode(recibo.getValorPagoOportuno());
			String zrs2 = adjustMoneyForBarcode(recibo.getValorPagoExtemporaneo());
					
			// ASSIGNING REPORT PARAMETERS //
			parameters.put("reciboNo", recibo.getReciboNo());		    
		    parameters.put("empresa", recibo.getEmpresa());
		    parameters.put("empresaCod", recibo.getEmpresaCod());
		    parameters.put("empresaPal", recibo.getEmpresaPal());
		    parameters.put("empresaNit", recibo.getEmpresaNit());
			parameters.put("facturado", recibo.getFechaFacturacion()); 
			parameters.put("codFactura", recibo.getCodFactura());
			parameters.put("mesesAPagar", recibo.getMesesAPagar());
			parameters.put("nombreEstudiante", recibo.getNombreEst());
			parameters.put("banco", recibo.getBanco());
			parameters.put("cuenta", recibo.getNumCuenta());
			parameters.put("referencia", recibo.getReferencia());
			parameters.put("curso", recibo.getCursoEst());
			parameters.put("fechaPagoOportuno", recibo.getFechaPagoOportuno());
			parameters.put("valorPagoOportuno", recibo.getValorPagoOportuno());
			parameters.put("fechaPagoExtemporaneo", recibo.getFechaPagoExtemporaneo());			
			parameters.put("valorPagoExtemporaneo", recibo.getValorPagoExtemporaneo());
			parameters.put("infoAdicionalRecibo1", recibo.getInfoAdicional1());
			parameters.put("infoAdicionalRecibo2", recibo.getInfoAdicional2());
			
			// GENERANDO DATOS :: Codigos de Barras //		
		    parameters.put("barCodeOportunoGTINRef"	, "415" + recibo.getEan13() + "8020" + recibo.getReferencia());
		    parameters.put("barCodeOportunoMoney"	, "3900" + zrs1);
		    parameters.put("barCodeOportunoDate"	, "96" + strDate1);		   
		    parameters.put("barCodeExtemporaneoGTINRef"	, "415" + recibo.getEan13() + "8020" + recibo.getReferencia());
		    parameters.put("barCodeExtemporaneoMoney"	, "3900" + zrs2);
		    parameters.put("barCodeExtemporaneoDate"	, "96" + strDate2);
		    
		    // QR CODE //		
		    parameters.put("qrCodeContent", qr(recibo.getBarcodeQR()));
		    		    
		    ArrayList<Concepto> conceptosDelRecibo = recibo.getConceptos();
		    
		    // Validacion de los 8 conceptos
		 	if (conceptosDelRecibo.size() > 8) {
		 		throw new Exception("Solo pueden ser registrados 8 conceptos.");
		 	}
		    
		    parameters.put("colConceptos", conceptosDelRecibo);
		    		    
		    /*
		    // ONLY IN DEVELOPMENT :: To Compile Jasper: jrxml -> jasper
			jasperReport = JasperCompileManager.compileReport(
				"resources/res/jrs/Recibo01.jrxml"	// TirillaBarras				
			);
			*/
			
		    // SEARCH THE JASPER REPORT TEMPLATE
		    jasperReport = (JasperReport) JRLoader.loadObject(
		    	this.getClass().getResource("/res/jrs/Recibo01.jasper") 
		    );
		    
		    // Pass parameters to report
			jasperPrint = JasperFillManager.fillReport(
				jasperReport, parameters, new JREmptyDataSource()
			);
			
			// CREATE PDF //
			JasperExportManager.exportReportToPdfFile(
				jasperPrint, pathParaRecibo + "/" + 
				recibo.getCursoEst() + "-" + recibo.getReferencia() + "-" + recibo.getCodFactura() + ".pdf"
			);						
		} catch (JRException jre) {
			jre.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		
		return true;
	} // end : createPDF Method
		
	/**
	 * Utility that will begin the pdf generation of all
	 * receipts using a specific month/year.
	 * 
	 * @param month With Locale("ES") a 3 character month.
	 * @param year Year for the receipts.
	 * @return True if everything was correct, no problems found.
	 * @throws Exception
	 */
	public boolean createAllReceipts(String month, 
									 String year) throws Exception {	
		String l = File.separator;
		month = month.toUpperCase();
		
		String pathFileFrom = year + ".DIU" + l + "RECIBOS" + l + month + l + "RECI" + month + ".DAT";
		String pathToFolder = "C:" + l + "misdoc" + l + "recibos" + l + year + l + month.toLowerCase();
		
		// 2014
		
		if (!new File(pathFileFrom).exists()) {
		    throw new Exception("El archivo en la ruta " + pathFileFrom + " no existe.");		    
		}
		if (!new File(pathToFolder).exists()) {
		    throw new Exception("La ruta de destino para los recibos: " + pathToFolder + " no existe.");		    
		}
				
		try {
			RecibosDbf reciboDbfLegacyData = new RecibosDbf(pathFileFrom);
			
			ArrayList<String> codigos = null;
			codigos = reciboDbfLegacyData.getIds("CCODIGOEST");
		
			for (String codigo : codigos) {

				reciboDbfLegacyData.seek("CCODIGOEST", codigo);

				Recibo01 paramsConRecibo = new Recibo01();
				reciboDbfLegacyData.asignarParamsARecibo(paramsConRecibo);

				createPDF(pathToFolder, paramsConRecibo);
			} // for
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
		System.out.println();
		System.out.println("TODOS LOS RECIBOS CREADOS EXITOSAMENTE");
		return true;
	} // end : createAllReceipts Method
	
}