package com.naif.facturacion;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import com.naif.facturacion.control.EntryController;
import com.naif.facturacion.util.Util;

/**
 * Main execution class for this JavaFX
 * application.
 */
public class Entry extends Application {
	
	/** Scene's container for UI changes. */
	private Scene scene;

	/** Main application's stage(window). */
	private Stage primaryStage;
		
	
	// ______________________________________________________________//
	// ********************** PRIVATE METHODS ***********************//
	
	/**
	 * Initialization method, to lighten start
	 * method operations.
	 * 
	 * @param stage Application initialization stage.
	 */ 
	private void inic(Stage stage) {		
		if (stage == null) {
			throw new NullPointerException("Stage for this application is null.");
		} else {
			primaryStage = stage;
		}
			
		try {			
			FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/res/view/lobby/mainui.fxml")
			);
			loader.setClassLoader(Util.cl()); 
			
			Parent root = (Parent) loader.load();
			
			EntryController controller = (EntryController)loader.getController();
			controller.setStageOnInit(primaryStage);
			
			scene = new Scene(root);			
			
			scene.getStylesheets().add(Util.getDefaultTheme());
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("SIMACART - Facturación");
			primaryStage.getIcons().add(new Image("/res/imgs/appicon.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // end : inic Method
	
	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//

	@Override 
	public void init() throws Exception {
		super.init();
		Util.getInstance();
	} // end : init Method
	
	@Override // MAIN //
	public void start(Stage stage) {
		inic(stage);
		primaryStage.show();
	} // end : start : MAIN METHOD
	
	public static void main(String[] args) {
		launch((java.lang.String[]) null);
	}				

}