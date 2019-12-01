//package com.westga.cs3211.prescription_app.datatier;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.westga.cs3211.prescription_app.model.Prescription;
//import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
//import com.westga.cs3211.prescription_app.resources.StaticFields;
//
///**
// * The PrescriptionFileReader Class
// * 
// * @author Jeremy Trimble
// * @version 11/3/2019
// *
// */
//public class PrescriptionFileReader {
//
//	/**
//	 * Returns a new Prescription List created from the file specified
//	 * 
//	 * @precondition filePath != null
//	 * 
//	 * @param filePath the file path of the photo album
//	 * 
//	 * @return a list of Prescriptions
//	 */
//	public static List<Prescription> readPrescriptionCSV(String filePath) {
//		if (filePath == null) {
//			throw new IllegalArgumentException(ExceptionMessages.NULL_FILE);
//		}
//		List<Prescription> prescriptions = new ArrayList<Prescription>();
//		try (Scanner scanner = new Scanner(new File(filePath))) {
//			while (scanner.hasNextLine()) {
//				String line = scanner.nextLine();
//				String[] fields = line.split(StaticFields.DELIMITER);
//				String name = fields[0];
//				boolean avoidDriving = Boolean.parseBoolean(fields[1]);
//				boolean withoutAlcohol = Boolean.parseBoolean(fields[2]);
//				boolean withFood = Boolean.parseBoolean(fields[3]);
//				int renewFrequency = Integer.parseInt(fields[4]);
//				int dosageCount = Integer.parseInt(fields[5]);
//				int refillDosageCount = Integer.parseInt(fields[6]);
//				String instructions = "";
//				if (fields.length == 8) {
//					instructions = fields[7];
//				}
//
//				Prescription prescription = new Prescription(name, avoidDriving, withoutAlcohol, withFood,
//						renewFrequency, dosageCount, refillDosageCount, instructions);
//				prescriptions.add(prescription);
//			}
//		} catch (FileNotFoundException fnfe) {
//			System.err.println(fnfe.getMessage());
//		} catch (IndexOutOfBoundsException ioobe) {
//			System.err.println(ioobe.getMessage());
//			System.err.println(ExceptionMessages.CORRUPT_DATA_FILE);
//		}
//		return prescriptions;
//	}
//}
