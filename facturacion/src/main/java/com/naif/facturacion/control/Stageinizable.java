package com.naif.facturacion.control;

import javafx.stage.Stage;

/**
 * Interface to unify a contract with a method to assign
 * the stage associated with a UI controller.
 */
public interface Stageinizable {
	public void setStageOnInit(Stage uiStage);
}