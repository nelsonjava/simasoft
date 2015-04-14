package com.naif.facturacion.control;

import javafx.stage.Stage;

public class OtraFacturacionController implements Stageinizable {

	/** Main application stage. */
	private Stage 			uiStage;
	
	/**
	 * It will assign the window holder for this controller.
	 * 
	 * @param uiStage Window stage that will handle this controller.
	 */
	@Override
	public void setStageOnInit(Stage uiStage) {
		this.uiStage = uiStage;	
	} // end : setStageOnInit Method		
	
}