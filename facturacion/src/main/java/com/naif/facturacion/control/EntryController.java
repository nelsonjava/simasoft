package com.naif.facturacion.control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.naif.facturacion.util.Util;

/**
 * Controller class for the main application view. 
 */
public class EntryController {
	
	/** Main application stage. */
	private Stage 			uiStage;
	
	/** UI Base view layout. */
	@FXML private VBox 		root;	
	
	@FXML private MenuItem meniSoloUnRecibo;
	@FXML private MenuItem meniTodosRecibos;
	@FXML private MenuItem meniPorAdelantado;
	@FXML private MenuItem meniOtraFacturacion;
	@FXML private MenuItem meniAcercaDe;
		
	
	// ______________________________________________________________//
	// ********************** PRIVATE METHODS ***********************//
	
	/** Initialize method. */
	private void inic() {} // end : inic Method
	
	/**
	 * Place a specific view in the content main panel.
	 */ 
	private void placeView(int menuItemInUI) {
		
		String fxmlPath = "/res/view/lobby/";
		
		try {	
			switch(menuItemInUI) { // Choose the right view
				case 1: 
					fxmlPath += "solo_un_recibo.fxml";					
					break;
				case 2: 
					fxmlPath += "todos_los_recibos.fxml";					
					break;		
				case 3: 
					fxmlPath += "por_adelantado.fxml";					
					break;					
				case 4: 
					fxmlPath += "otra_facturacion.fxml";					
					break;
				default: throw new Exception("Not supported operation " + menuItemInUI);	
			}
			
			// Remove content panel
			root.getChildren().remove(1);
			
			// Search for the new view
			FXMLLoader loader = new FXMLLoader(
				getClass().getResource(fxmlPath)
			);
			loader.setClassLoader(Util.cl());
			
			// Place the found view
			root.getChildren().add((Parent) loader.load());	
			
			// Assign stage to the new view 
			((Stageinizable)loader.getController()).setStageOnInit(uiStage);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end : placeView Method
	
	
	// ______________________________________________________________//
	// ********************* PROTECTED METHODS **********************//	
	
	/** It will place the Solo un Recibo view in the main content panel. */	
	@FXML protected void setSoloUnReciboView(ActionEvent event) {		
		placeView(1);
	} // end : setOtraFacturacionView Method

	/** It will place the Todos los Recibos view in the main content panel. */	
	@FXML protected void setTodosLosRecibosView(ActionEvent event) {		
		placeView(2);	
	} // end : setOtraFacturacionView Method
	
	/** It will place the Por Adelantado view in the main content panel. */	
	@FXML protected void setPorAdelantadoView(ActionEvent event) {		
		placeView(3);
	} // end : setOtraFacturacionView Method
		
	/** It will place the Otra Facturacion view in the main content panel. */	
	@FXML protected void setOtraFacturacionView(ActionEvent event) {		
		placeView(4);
	} // end : setOtraFacturacionView Method
	
	
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
	public void setStageOnInit(Stage uiStage) {
		this.uiStage = uiStage;	
	} // end : setStageOnInit Method	

}