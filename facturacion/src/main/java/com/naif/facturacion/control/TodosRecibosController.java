package com.naif.facturacion.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.naif.facturacion.TodosRecibosWork;
import com.naif.facturacion.customnodes.*;
import com.naif.facturacion.customnodes.calendar.DatePicker;

public class TodosRecibosController implements Stageinizable {
		
	/** Main application stage. */
	private Stage 			uiStage;
	
	@FXML private Text lblValdMsj;
	@FXML private DatePicker dpckReceiptDate;
	@FXML private Button btnGenAllReceipts;
    @FXML private LoadingProgressIndicator prgiCreate;
    		
	/** Worker that initializes all receipts creation. */
	private TodosRecibosWork allPdfsGENWork;
	
	
	// ______________________________________________________________//
	// ********************** PRIVATE METHODS ***********************//
	
	/** Initialize method. */
	private void inic() {		
		// Verification worker preparation
		allPdfsGENWork = new TodosRecibosWork();
		
        // Worker Finished
		allPdfsGENWork.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent wse) {
            	
            	Boolean success = allPdfsGENWork.getValue();
            	
            	if (success) {            		
            		lblValdMsj.setText("!! Todos los recibos fueron generados con EXITO !!");
            		lblValdMsj.setVisible(true);
            		lblValdMsj.getStyleClass().clear();            		
            		lblValdMsj.getStyleClass().add("text-user-msg-ok");
            	} else {
            		System.out.println("X: Error - PDF no GENERADO.");
            	}
            	
            	prgiCreate.stop(); 
            	activateInputNodes();            	
            }
        });
        
        // Some error happened in worker
		allPdfsGENWork.setOnFailed(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent wse) {
            	try {
            	    throw allPdfsGENWork.getException();
            	} catch (Throwable ouch) {
            		System.out.println("X: Error en generación de .pdf");            		
            		showErrMsg("ERROR: " + ouch.getMessage());
            		ouch.printStackTrace();
            	}
            	   
            	prgiCreate.stop(); 
            	activateInputNodes();
            }
        });    		
		
	} // end : inic Method
	
	/**
	 * Method to disable user input nodes. 
	 */ 
	private void blockInputNodes() {
		btnGenAllReceipts.setDisable(true);
		dpckReceiptDate.setDisable(true);	
	} // end : blockInputNodes Method		
	
	/**
	 * Method to enable user input nodes. 
	 */ 
	private void activateInputNodes() {
		btnGenAllReceipts.setDisable(false);
		dpckReceiptDate.setDisable(false);
	} // end : activateInputNodes Method	
	
	
	/**
	 * Metodo para validar un texto, que representa a una fecha 
	 * de entrada, con mensajes especificos de acuerdo a la 
	 * validacion.
	 * 
	 * @param attributeMsg Texto base para los mensajes de error.
	 * @param fecha Texto que representa la fecha a validar.
	 * @return Verdadero, sí la fecha cumple con el formato(dd/MM/YYYY),
	 * 		   falso, sí no cumple alguna validación.
	 */ 
	private boolean validarFecha(String attributeMsg, String fecha) {
				
		String datePattern = "[a-zA-Z]{3}\\s\\d\\d?/\\d{4}";
		String errorMsg = "";
		
		do { // Validation Block
			
			if (fecha.isEmpty()) {
				errorMsg = "Favor ingresar la " + attributeMsg.toLowerCase() + ".";
				break;
			}
						
			if (Pattern.matches(datePattern, fecha)) {				
				try {					
					Calendar wishedDate = Calendar.getInstance();
					wishedDate.setTime(
						new SimpleDateFormat("MMM dd/yyyy", new Locale("es", "CO")).parse(fecha)
					);
					
					String dateNumber = (fecha.split(" ")[1]).split("/")[0];
					
					Integer day = new Integer(dateNumber);
										
					if (!(day > 0 & day <= 31)) {
						errorMsg = attributeMsg + "(Dia) incorrecta.";
						break;					
					}					
				} catch (Exception e) {
					e.printStackTrace();
					errorMsg = attributeMsg + " incorrecta.";
					break;				
				}
			} else {
				errorMsg = attributeMsg + " incorrecta.";				
				break;		
			}
			
			break;
		} while(true); // Validation Block
		
		if (!errorMsg.isEmpty()) {
			showErrMsg(errorMsg);			
			return false;
		}
			
		return true;
	} // end : validarFecha Method	
		
	@FXML protected void generarAllPDFs(ActionEvent event) {		

		String fechaSeleccionada = dpckReceiptDate.getCalendarText();
		
		lblValdMsj.setText("");
		lblValdMsj.getStyleClass().clear();
		
		if (fechaSeleccionada == null || fechaSeleccionada.isEmpty()) {
			showErrMsg("Fecha para generación de recibos NO seleccionada.");
			return;
		}			
		if (!validarFecha("Fecha para facturacion", fechaSeleccionada)) {			
			return;
		}	
		
		Calendar cDate = Calendar.getInstance();
		cDate.setTime(dpckReceiptDate.getSelectedDate());
				
		int genPdfs = ConfirmDialog.show(
			uiStage, "¿Está(s) seguro(a) de generar los recibos?"
		);
				
		if (genPdfs == 0) {
			return; // NO IMPRIMIR
		}
				
		blockInputNodes();
		prgiCreate.play();
		
		allPdfsGENWork.setMonth(fechaSeleccionada.split(" ")[0]);
		allPdfsGENWork.setYear(new Integer(cDate.get(Calendar.YEAR)).toString());
		
		if (!allPdfsGENWork.isRunning()) {
			allPdfsGENWork.reset();
			allPdfsGENWork.start();
		}
		
	} // end : generarAllPDFs Method
	
	/**
	 * Coordinates the error messages on the screen.
	 * 
	 * @param errorMsg Message to display when an error occurs.
	 */ 
	private void showErrMsg(String errorMsg) {
		lblValdMsj.setText(errorMsg);
		lblValdMsj.setVisible(true);			
		lblValdMsj.getStyleClass().add("text-user-msg-nok");
	} // end : showErrMsg Method
	
	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//

	public void initialize() {
		inic();
	} // end : initialize Method	
	
	/**
	 * It will assign the window holder for this controller.
	 * 
	 * @param uiStage Window stage that will handle this controller.
	 */
	@Override
	public void setStageOnInit(Stage uiStage) {
		this.uiStage = uiStage;
		
		this.uiStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				if (allPdfsGENWork.isRunning()) {
					allPdfsGENWork.cancel();
                } 
	        } // end : handle Method
	    });   
	} // end : setStageOnInit Method	
	
}