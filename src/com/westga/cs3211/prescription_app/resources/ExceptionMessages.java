package com.westga.cs3211.prescription_app.resources;


/**
 * Exception messages used throughout the system defined here for consistency
 * 
 * @author Jeremy Trimble
 * @version 11/2/2019
 *
 */
public class ExceptionMessages {
	
	public static final String NAME_NOT_EMPTY = "Name must not be null or empty.";
	public static final String RENEW_LESS_THAN_ZERO = "Renew Frequency must be 0 or greater.";
	public static final String DOSAGE_COUNT_LESS_THAN_ZERO = "Dosage Count must be 0 or greater.";
	public static final String REFILL_LESS_THAN_ZERO = "Refill Dosage count must be greater than 0.";
	public static final String NULL_FILE = "File trying to be read is null.";
	public static final String NULL_PRESCRIPTION = "Prescription cannot be null";
	public static final String ERROR_CREATING_MANAGER = "An Error occurred trying to make a manager";
	public static final String CORRUPT_DATA_FILE = "Data file may be corrupted. Line wasn't able to be read completely. Check for unintentional nextline";

}
