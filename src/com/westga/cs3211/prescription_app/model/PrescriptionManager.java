package com.westga.cs3211.prescription_app.model;

import java.util.List;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileIO;
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
	private PrescriptionFileIO fileIO;
	
	/**
	 * Creates a new PrescriptionManager
	 * 
	 * @precondition none
	 * @postcondition new PrescriptionManager is created with previously saved prescriptions
	 * 
	 */
	public PrescriptionManager() {
		this.fileIO = new PrescriptionFileIO(StaticFields.CURRENT_PRESCRIPTION_FILE);
		this.prescriptions = this.fileIO.readPrescriptionCSV();
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
			
			this.fileIO.addPrescriptionToCSV(prescription);
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
		
		this.fileIO.rewriteCSVFile(this.prescriptions);
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
	
	
	/**
	 * Removes a prescription from the file
	 * 
	 * @precondition prescription != null
	 * @postcondition list of prescriptions -= prescription, prescription file updates accordingly, view updates accordingly.
	 * 
	 * @param prescription 	the prescription to be removed
	 */
	
	public void remove(Prescription prescription) {
		this.prescriptions.remove(prescription);
		{
			this.fileIO.rewriteCSVFile(this.prescriptions);
		}
	}
	
}
