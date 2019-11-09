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
	 * 
	 * @return true if the specified prescription is successfully added, else false
	 */
	public boolean add(Prescription prescription) {
		if (this.prescriptions.add(prescription)) {
			PrescriptionFileWriter.addPrescriptionToCSV(StaticFields.CURRENT_PRESCRIPTION_FILE, prescription);
			return true;
		} 
		return false;
	}
	
	/**
	 * Updates a prescription
	 * 
	 * @param prescription the prescription being amended
	 * @param renewFrequency the frequency to renew
	 * @param dosageCount the count of current doses
	 * @param refillDosageCount the number of doses that come in a refill
	 * @param instructions describes how to take the prescription
	 * 
	 */
	public void update(Prescription prescription, int renewFrequency, int dosageCount, int refillDosageCount, String instructions) {
		prescription.update(renewFrequency, dosageCount, refillDosageCount, instructions);
		
		PrescriptionFileWriter.rewriteCSVFile(StaticFields.CURRENT_PRESCRIPTION_FILE, this.prescriptions);
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
