package com.westga.cs3211.prescription_app.model;

import java.io.File;

import com.westga.cs3211.prescription_app.resources.ExceptionMessages;

/**
 * The Prescription Class
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class Prescription extends Medication {

	private int renewFrequency;
	private int dosageCount;
	private int refillDosageCount;
	private boolean active;
	private String instructions;
	
	/**
	 * Creates a new Prescription
	 * 
	 * @preconditions name cannot be null && renewFrequency >= 0 && dosageCount >= 0 && refillDosageCount > 0
	 * @postconditions a new prescription is created
	 * 
	 * @param name 					The name of the prescrition
	 * @param avoidDriving 			If true do not take medication while driving
	 * @param withoutAlcohol		If true do not take medication with alcohol
	 * @param withFood				If true medication must be taken with food
	 * @param renewFrequency		How often a user must go to doctor to get prescription renewed
	 * @param dosageCount			The current count of doses
	 * @param refillDosageCount		The number of doses provided with a refill
	 * @param instructions			The instructions on how to take the prescription
	 */
	public Prescription(String name, boolean avoidDriving, boolean withoutAlcohol, boolean withFood, int renewFrequency,
			int dosageCount, int refillDosageCount, String instructions) {
		super(name, avoidDriving, withoutAlcohol, withFood);
		
		if (renewFrequency < 0) {
			throw new IllegalArgumentException(ExceptionMessages.RENEW_LESS_THAN_ZERO);
		}
		if (dosageCount < 0) {
			throw new IllegalArgumentException(ExceptionMessages.DOSAGE_COUNT_LESS_THAN_ZERO);
		}
		if (refillDosageCount <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.REFILL_LESS_THAN_ZERO);
		}
		this.renewFrequency = renewFrequency;
		this.dosageCount = dosageCount;
		this.refillDosageCount = refillDosageCount;
		this.active = true;
		this.instructions = instructions;

	}
	
	/**
	 * Updates the values of the prescription to to the ones past in
	 * 
	 * @preconditions name cannot be null && renewFrequency >= 0 && dosageCount >= 0 && refillDosageCount > 0
	 * @postconditions a new prescription is created
	 * 
	 * @param renewFrequency		How often a user must go to doctor to get prescription renewed
	 * @param dosageCount			The current count of doses
	 * @param refillDosageCount		The number of doses provided with a refill
	 * @param instructions			The instructions on how to take the prescription
	 */
	public void update(int renewFrequency, int dosageCount, int refillDosageCount, String instructions) {
	
	
		if (renewFrequency < 0) {
			throw new IllegalArgumentException(ExceptionMessages.RENEW_LESS_THAN_ZERO);
		}
		if (dosageCount < 0) {
			throw new IllegalArgumentException(ExceptionMessages.DOSAGE_COUNT_LESS_THAN_ZERO);
		}
		if (refillDosageCount <= 0) {
			throw new IllegalArgumentException(ExceptionMessages.REFILL_LESS_THAN_ZERO);
		}

		this.renewFrequency = renewFrequency;
		this.dosageCount = dosageCount;
		this.refillDosageCount = refillDosageCount;
		this.active = true;
		this.instructions = instructions;
		
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
	 * @postconditions getRenewFrequency() == renewFrequency
	 * 
	 * @param renewFrequency How often a user must go to doctor to get prescription renewed
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
	 * @postconditions getRefillDosageCount() == refillDosageCount
	 * 
	 * @param refillDosageCount	The number of doses provided with a refill
	 * 
	 */
	public void setRefillDosageCount(int refillDosageCount) {
		this.refillDosageCount = refillDosageCount;
	}

	/**
	 * Returns if the Prescription is active or not
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true is the Prescription is active else false
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * Sets whether the Prescription is active or not
	 * 
	 * @precondition none
	 * @postcondition isActive() == active
	 * 
	 * @param active the active state the Prescription is being set to.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * 
	 * Returns the instructions
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * 
	 * @return a string of the instructions for the prescription
	 */
	public String getInstructions() {
		return this.instructions;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

	
}




