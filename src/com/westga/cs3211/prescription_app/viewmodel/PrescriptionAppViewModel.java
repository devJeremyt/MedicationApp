package com.westga.cs3211.prescription_app.viewmodel;

import com.westga.cs3211.prescription_app.model.PrescriptionManager;

/**
 * The viewmodel object for the Prescription App
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class PrescriptionAppViewModel {
	
	private PrescriptionManager manager;
	
	/**
	 * Creates a new PrescriptionAppViewModel
	 * 
	 * @precondition none
	 * @postcondition new PrescriptionAppViewModel is created
	 * 
	 */
	public PrescriptionAppViewModel() {
		this.manager = new PrescriptionManager();
	}

}
