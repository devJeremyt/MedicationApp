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
	 * Sets the name
	 * 
	 * @precondition name != null && name.isEmpty == false
	 * @postcondition this.getName() == name
	 * 
	 * @param name the name is to be set to
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Sets the name
	 * 
	 * @precondition none
	 * @postcondition this.getAvoidDriving() == avoidDriving
	 * 
	 * @param avoidDriving true if driving should be avoided while taking medication
	 */
	public void setAvoidDriving(boolean avoidDriving) {
		this.avoidDriving = avoidDriving;
	}


	/**
	 * Sets the name
	 * 
	 * @precondition none
	 * @postcondition this.getWithoutAlcohol() == withoutAlcohol
	 * 
	 * @param withoutAlcohol true if the medication shouldn't be taken with  Alcohol else false
	 */
	public void setWithoutAlcohol(boolean withoutAlcohol) {
		this.withoutAlcohol = withoutAlcohol;
	}


	/**
	 * Sets whether medication should be taken with food
	 * 
	 * @precondition none
	 * @postcondition this.getWithFood() == withfood
	 * 
	 * @param withFood the value to set withFood too
	 */
	public void setWithFood(boolean withFood) {
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
	public boolean getAvoidDriving() {
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
	public boolean getWithoutAlcohol() {
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
	public boolean getWithFood() {
		return this.withFood;
	}
}
