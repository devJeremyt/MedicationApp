package com.westga.cs3211.prescription_app.model;

import com.westga.cs3211.prescription_app.resources.ExceptionMessages;

/**
 * The Prescription Class
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class Prescription extends Medication {

	int renewFrequency;
	int dosageCount;
	int refillDosageCount;
	
	/**
	 * Creates a new Prescription
	 * 
	 * @preconditions name cannot be null && renewFrequency >= 0 && dosageCount >= 0 && refillDosageCount > 0
	 * @postconditions a new prescription is created
	 * 
	 * @param name 					The name of the prescrition
	 * @param whileDriving 			If true do not take medication while driving
	 * @param withoutAlcohol		If true do not take medication with alcohol
	 * @param withFood				If true medication must be taken with food
	 * @param renewFrequency		How often a user must go to doctor to get prescription renewed
	 * @param dosageCount			The current count of doses
	 * @param refillDosageCount		The number of doses provided with a refill
	 */
	public Prescription(String name, boolean whileDriving, boolean withoutAlcohol, boolean withFood, int renewFrequency,
			int dosageCount, int refillDosageCount) {
		super(name, whileDriving, withoutAlcohol, withFood);
		
		if(renewFrequency < 0) {
			throw new IllegalArgumentException(ExceptionMessages.RENEW_LESS_THAN_ZERO);
		}
		if(dosageCount < 0) {
			throw new IllegalArgumentException(ExceptionMessages.DOSAGE_COUNT_LESS_THAN_ZERO);
		}if(refillDosageCount <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.REFILL_LESS_THAN_ZERO);
		}
		this.renewFrequency = renewFrequency;
		this.dosageCount = dosageCount;
		this.refillDosageCount = refillDosageCount;
	}
	
	/**
	 * Reduces the count of doses by one
	 * 
	 * @precondition doses > 0
	 * @postcondition doses== doses@prev - 1
	 * 
	 * @return the new count of doses
	 */
	public int takePrescription() {
		if(this.dosageCount <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.DOSAGE_COUNT_LESS_THAN_ZERO);
		}
		
		return this.dosageCount--;
	}

	/**
	 * Returns the Renew Frequency
	 * 
	 * @preconditions none
	 * @postconditions none
	 * 
	 * @return the Renew Frequency
	 */
	public int getRenewFrequency() {
		return this.renewFrequency;
	}

	/**
	 * Sets the RenewFrequency
	 * 
	 * @preconditions none
	 * @postconditions none
	 * 
	 */
	public void setRenewFrequency(int renewFrequency) {
		this.renewFrequency = renewFrequency;
	}

	/**
	 * Returns the current number of doses
	 * 
	 * @preconditions none
	 * @postconditions none
	 * 
	 * @return the current number of doses
	 */
	public int getDosageCount() {
		return this.dosageCount;
	}

	/**
	 * Returns the Refill Dosage Count
	 * 
	 * @preconditions none
	 * @postconditions none
	 * 
	 * @return the Refill Dosage Count
	 */
	public int getRefillDosageCount() {
		return this.refillDosageCount;
	}

	/**
	 * Sets the Refill Dosage Count
	 * 
	 * @preconditions none
	 * @postconditions none
	 * 
	 * @return the Refill Dosage Count
	 */
	public void setRefillDosageCount(int refillDosageCount) {
		this.refillDosageCount = refillDosageCount;
	}
	
	
}




