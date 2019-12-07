package com.westga.cs3211.prescription_app.resources;

import java.time.format.DateTimeFormatter;

/**
 * Container for static fields
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class StaticFields {
	
	public static final String DELIMITER = ",";
	public static final String CURRENT_PRESCRIPTION_FILE = ".\\src\\com\\westga\\cs3211\\prescription_app\\currentPrescriptions.csv";
	public static final String SIDE_EFFECTS_FILE = ".\\src\\com\\westga\\cs3211\\prescription_app\\sideEffects.csv";
	public static final String MEDICATION_RECORDS_FILE = ".\\src\\com\\westga\\cs3211\\prescription_app\\medicationRecordFile.csv";
	public static final DateTimeFormatter DATETIMEFORMAT = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm a");
}
