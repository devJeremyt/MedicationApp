package com.westga.cs3211.prescription_app.model;

import com.westga.cs3211.prescription_app.resources.ExceptionMessages;

/**
 * The Medication Class
 * 
 * @author Jeremy Trimble
 * @version 11/2/2019
 *
 */
public class Medication {
	
	private String name;
	private boolean avoidDriving;
	private boolean withoutAlcohol;
	private boolean withFood;
	
	
	/**
	 * Creates a new Medication
	 * 
	 * @precondition name cannot be null or empty
	 * @postcondition new Medication object is created
	 * 
	 * @param name 				The name of the medication
	 * @param avoidDriving		If true, do not take medication while driving		
	 * @param withoutAlcohol	If true, do not take with alcohol
	 * @param withFood			If true medication must be taken with food
	 */
	public Medication(String name, boolean avoidDriving, boolean withoutAlcohol, boolean withFood) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.NAME_NOT_EMPTY);
		}
		this.name = name;
		this.avoidDriving = avoidDriving;
		this.withoutAlcohol = withoutAlcohol;
		this.withFood = withFood;
	}


	
	/**
	 * Returns the name of the Medication
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the medication
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns true if medication should not be taken while driving
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the medication should not be taken while driving
	 */
	public boolean avoidDriving() {
		return this.avoidDriving;
	}
	
	/**
	 * Returns true if medication should not be taken with alcohol
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the medication should not be taken with alcohol
	 */
	public boolean withoutAlcohol() {
		return this.withoutAlcohol;
	}
	
	/**
	 * Returns true if medication should be taken with food
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the medication should be taken with food
	 */
	public boolean withFood() {
		return this.withFood;
	}
}
