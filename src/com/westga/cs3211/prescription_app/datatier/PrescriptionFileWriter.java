package com.westga.cs3211.prescription_app.datatier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
import com.westga.cs3211.prescription_app.resources.StaticFields;

/**
 * The File Writer class
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class PrescriptionFileWriter {

	
	/**
	 * Saves the specified list of prescriptions to the file specified
	 * 
	 * @preconditions filePath != null && prescription != null
	 * @postconditions file contains the prescription data
	 * @param filePath the path to the file prescriptions are saved too
	 * @param prescription the prescription to be saved
	 */
	public static void addPrescriptionToCSV(String filePath, Prescription prescription) {
		if (filePath == null) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_FILE);
		}
		if (prescription == null) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_PRESCRIPTION);
		}
		
		try (FileWriter writer = new FileWriter(new File(filePath), true)) {
			String content = "";
			
			content += prescription.getName() + StaticFields.DELIMITER;
			content += prescription.getAvoidDriving() + StaticFields.DELIMITER;
			content += prescription.getWithoutAlcohol() + StaticFields.DELIMITER;
			content += prescription.getWithFood() + StaticFields.DELIMITER;
			content += prescription.getRenewFrequency() + StaticFields.DELIMITER;
			content += prescription.getDosageCount() + StaticFields.DELIMITER;
			content += prescription.getRefillDosageCount() + StaticFields.DELIMITER;
			content += prescription.getInstructions() + StaticFields.DELIMITER;
			content += System.lineSeparator();
			
			writer.append(content);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			
		}
	}
	
	/**
	 * Rewrites the csv storage file with the specified list of prescriptions
	 * 
	 * @precondition filePath != null && filePath.isEmpty == false && prescriptions != null
	 * @postcondition all prescriptions in list written to csv file
	 * 
	 * @param filePath the filePath for the storage CSV
	 * @param prescriptions the list of prescriptions to be written to the file
	 */
	public static void rewriteCSVFile(String filePath, List<Prescription> prescriptions) {
		if (filePath == null || filePath.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_FILE);
		}
		if (prescriptions == null) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_PRESCRIPTION);
		}
		
		try (FileWriter writer = new FileWriter(new File(filePath), false)) {
			String content = "";
			writer.write(content);
			
			for (Prescription prescription: prescriptions) {
				content += prescription.getName() + StaticFields.DELIMITER;
				content += prescription.getAvoidDriving() + StaticFields.DELIMITER;
				content += prescription.getWithoutAlcohol() + StaticFields.DELIMITER;
				content += prescription.getWithFood() + StaticFields.DELIMITER;
				content += prescription.getRenewFrequency() + StaticFields.DELIMITER;
				content += prescription.getDosageCount() + StaticFields.DELIMITER;
				content += prescription.getRefillDosageCount() + StaticFields.DELIMITER;
				content += prescription.getInstructions() + StaticFields.DELIMITER;
				content += System.lineSeparator();
			}
		
			writer.write(content);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			
		}
	}
	
}
