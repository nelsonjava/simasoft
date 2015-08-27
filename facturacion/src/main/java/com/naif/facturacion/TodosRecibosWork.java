package com.naif.facturacion;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import com.naif.facturacion.util.GeneratorEngine;

public class TodosRecibosWork extends Service<Boolean> {

	private String month;
	private String year;

	public TodosRecibosWork() {}

	public TodosRecibosWork(String month, String year) {
		this.month 	= month;
		this.year 	= year;
	}

	@Override
	protected Task<Boolean> createTask() {
		return new TodosRecibosTask(month, year);
	} // end : createTask Method
	
	
	public final void setMonth(String month) {
		this.month = month;
	}

	public final void setYear(String year) {
		this.year = year;
	}


	/**
	 * Todos los recibos generation Task.
	 * 
	 */
	private class TodosRecibosTask extends Task<Boolean> {
		
		private String month;
		private String year;
		
		TodosRecibosTask(String month, String year) {
			this.month 	= month;
			this.year 	= year;
		}
			
		@Override 
		protected Boolean call() throws Exception {			
			return new GeneratorEngine().createAllReceipts(month,year);
		} // end : call Method
		
	} // END : IngresoTask : CLASS		

}