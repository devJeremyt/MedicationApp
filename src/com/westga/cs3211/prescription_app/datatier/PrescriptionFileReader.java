package com.westga.cs3211.prescription_app.datatier;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
import com.westga.cs3211.prescription_app.resources.StaticFields;

/**
 * The PrescriptionFileReader Class
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class PrescriptionFileReader {

	/**
	 * Returns a new Prescription List created from the file specified
	 * 
	 * @precondition filePath != null
	 * 
	 * @param filePath the file path of the photo album
	 * 
	 * @return a list of Prescriptions
	 */
	public static List<Prescription> readPrescriptionCSV(String filePath) {
		if (filePath == null) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_FILE);
		}
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(StaticFields.DELIMITER);
				String name = fields[0];
				boolean avoidDriving = Boolean.parseBoolean(fields[1]);
				boolean withoutAlcohol = Boolean.parseBoolean(fields[2]);
				boolean withFood = Boolean.parseBoolean(fields[3]);
				int renewFrequency = Integer.parseInt(fields[4]);
				int dosageCount = Integer.parseInt(fields[5]);
				int refillDosageCount = Integer.parseInt(fields[6]);
				String instructions = "";
				if (fields.length == 8) {
					instructions = fields[7];
				}

				Prescription prescription = new Prescription(name, avoidDriving, withoutAlcohol, withFood,
						renewFrequency, dosageCount, refillDosageCount, instructions);
				prescriptions.add(prescription);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println(ioobe.getMessage());
			System.err.println(ExceptionMessages.CORRUPT_DATA_FILE);
		}
		return prescriptions;
	}

	/**
	 * Returns a new list of SideEffects from the specified file
	 * 
	 * @precondition filePath != null
	 * 
	 * @param file the file containing the SideEffects
	 * 
	 * @return a list of Prescriptions
	 */
	public static List<SideEffect> readSideEffectsCSV(File file) {
		if (file == null) {
			throw new IllegalArgumentException(ExceptionMessages.NULL_FILE);
		}
		List<SideEffect> sideEffects = new ArrayList<SideEffect>();
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(StaticFields.DELIMITER);
				LocalDateTime time = LocalDateTime.parse(fields[0], StaticFields.DATETIMEFORMAT);
				String description = fields[1];

				SideEffect sideEffect = new SideEffect(description, time);
				sideEffects.add(sideEffect);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println(ioobe.getMessage());
			System.err.println(ExceptionMessages.CORRUPT_DATA_FILE);
		}
		return sideEffects;
	}

	/**
	 * Returns a new list of SideEffects from the specified file
	 * 
	 * @precondition filePath != null
	 * 
	 * @param file the file containing the SideEffects
	 * 
	 * @return a list of Prescriptions
	 */
	public static HashMap<String, List<String>> readMedicalRecordFile() {
		HashMap<String, List<String>> records = new HashMap<String, List<String>>();
		try (Scanner scanner = new Scanner(StaticFields.MEDICATION_RECORDS_FILE)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] fields = line.split(":");
				if (records.containsKey(fields[0])) {
					records.get(fields[0]).add(fields[1]);
				} else {
					List<String> newRecord = new ArrayList<String>();
					newRecord.add(fields[1]);
					records.put(fields[0], newRecord);
				}

			}
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println(ioobe.getMessage());
			System.err.println(ExceptionMessages.CORRUPT_DATA_FILE);
		}
		return records;
	}
}
