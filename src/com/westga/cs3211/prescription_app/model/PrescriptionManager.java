package com.westga.cs3211.prescription_app.model;

import java.util.ArrayList;
import java.util.List;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;
import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
import com.westga.cs3211.prescription_app.resources.StaticFields;

/**
 * Manages Prescriptions
 * 
 * @author Jeremy Trimble
 * @version 9/3/2019
 *
 */
public class PrescriptionManager {
	
	private List<Prescription> prescriptions;
	
	/**
	 * Creates a new PrescriptionManager
	 * 
	 * @precondition none
	 * @postcondition new PrescriptionManager is created with previously saved prescriptions
	 * 
	 */
	public PrescriptionManager() {
		try {
			this.prescriptions = PrescriptionFileReader.readPrescriptionCSV(StaticFields.CURRENT_PRESCRIPTION_FILE);
		} catch (Exception e) {
			System.err.println(ExceptionMessages.ERROR_CREATING_MANAGER);
			
			this.prescriptions = new ArrayList<Prescription>();
		}
	}
	
	/**
	 * Adds a prescription to the list of prescriptions
	 * 
	 * @param prescription the prescription being added the list of prescriptions
	 */
	public void add(Prescription prescription) {
		this.prescriptions.add(prescription);
		PrescriptionFileWriter.addPrescriptionToCSV(StaticFields.CURRENT_PRESCRIPTION_FILE, prescription);
	}

	/**
	 * Returns the list object of the prescriptions
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of prescriptions
	 */
	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}
	
	
}
