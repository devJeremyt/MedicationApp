package com.westga.cs3211.prescription_app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
import com.westga.cs3211.prescription_app.resources.StaticFields;

/**
 * The SideEffect Class
 * 
 * @author Jeremy Trimble
 * @version 12/1/2019
 * 
 */
public class SideEffect {
	private String description;
	private LocalDateTime time;
	
	/**
	 * Creates a new SideEffect
	 * 
	 * @precondition !description.isEmpty() && description != null && time != null
	 * @postcondition new SideEffect exist
	 * 
	 * @param description the description of the SideEffect
	 * @param time the time of SideEffect 
	 */
	public SideEffect(String description, LocalDateTime time) {
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.DESCRIPTION_NOT_EMPTY);
		}
		if (time == null) {
			throw new IllegalArgumentException(ExceptionMessages.TIME_NOT_NULL);
		}
		this.description = description;
		this.time = time;
	}
	
	/**
	 * Returns the description of the side effect
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a string of the description
	 * 
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Sets the description of the side effect
	 * 
	 * @precondition !description.isEmpty() && description != null
	 * @postcondition this.description == description
	 * 
	 * @param description the string the description is being set to.
	 */
	public void setDescription(String description) {
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.DESCRIPTION_NOT_EMPTY);
		}
		this.description = description;
	}
	
	/**
	 * Returns the the time of teh SideEffect
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the time of the SideEffect
	 */
	public String getTime() {
		return this.time.format(StaticFields.DATETIMEFORMAT);
	}
	
	/**
	 * Sets the time of the side effect
	 * 
	 * @precondition time != null
	 * @postcondition this.time == time
	 * 
	 * @param time the time the SideEffect is being set to
	 */
	public void setTime(LocalDateTime time) {
		if (time == null) {
			throw new IllegalArgumentException(ExceptionMessages.TIME_NOT_NULL);
		}
		this.time = time;
	}
	

}
