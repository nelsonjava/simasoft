package com.naif.facturacion.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.fxml.FXMLLoader;

/**
 * Utility class, useful methods used
 * through the application.
 */
public class Util {
	
	/** Singleton instance. */
	private static Util instance = null;
	
	/** Custom class loader. */
	private static ClassLoader cachingClassLoader = new FXClassLoader(FXMLLoader.getDefaultClassLoader());
	
	/** Default CSS style. */
	private static String defaultTheme;
	
	/** Alert dialog CSS style. */
	private static String dialogTheme;
	
	
	/** Default constructor. */
	private Util() {}
	
	/** Singleton constructor. */
	public static Util getInstance() {
	    if (instance == null) {
	        instance = new Util();
	        instance.inic();
	    }
	    return instance;
	} // end : constructor
	
	
	// ______________________________________________________________//
	// ********************** PRIVATE METHODS ***********************//
	
	/**
	 * Initialization method.
	 */ 
	private void inic() {
		try {			 
			defaultTheme = getClass().getResource("/res/styles/default.css").toExternalForm();
			dialogTheme  = getClass().getResource("/res/styles/alert.css").toExternalForm();
			
			// To could load stylesheet at runtime
			if (defaultTheme.contains("rsrc:")) { 
				defaultTheme = defaultTheme.replace("rsrc:", "");
				dialogTheme  = dialogTheme.replace("rsrc:", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end : inic Method

	
	// ______________________________________________________________//
	// *********************** PUBLIC METHODS ***********************//
	
	/**
	 * cl = Class Loader, short hand method
	 * to call the custom class loader.
	 * 
	 * @return Custom class loader.
	 */
	public static ClassLoader cl() {
		return cachingClassLoader;
	} // end : cl Method
	
	/**
	 * Check if there are internet connection.
	 * 
	 * @return True, if, there are internet, otherwise false.
	 */
	public static boolean isThereInternet() {
		int timeOut = 400;
		String url = "https://www.google.com.co";
		
	    try {
	        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setConnectTimeout(timeOut);
	        connection.setReadTimeout(timeOut);
	        connection.setRequestMethod("HEAD");
	        int responseCode = connection.getResponseCode();
	        return (200 <= responseCode && responseCode <= 399);
	    } catch (IOException exception) {
	        return false;
	    }
	}

	/** @return The default CSS style. */
	public static String getDefaultTheme() {
		return defaultTheme;
	}
	
	/** @return The alert dialog CSS style. */
	public static String getDialogTheme() {
		return dialogTheme;
	}
	
}