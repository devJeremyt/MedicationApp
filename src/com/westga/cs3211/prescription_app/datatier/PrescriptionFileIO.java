package com.westga.cs3211.prescription_app.datatier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.resources.ExceptionMessages;
import com.westga.cs3211.prescription_app.resources.StaticFields;

public class PrescriptionFileIO {

	
	private String currentFilePath;
	private PrescriptionFileWriter writer;
	private PrescriptionFileReader reader;

	public PrescriptionFileIO(String filePath) {
		currentFilePath = filePath;
		writer = new PrescriptionFileWriter();
		reader = new PrescriptionFileReader();
	}

	public void addPrescriptionToCSV(Prescription prescription) {
		writer.addPrescriptionToCSV(currentFilePath, prescription);
	}
	
	public void rewriteCSVFile(List<Prescription> prescriptions) {
		writer.rewriteCSVFile(currentFilePath, prescriptions);
	}
	
	public List<Prescription> readPrescriptionCSV(){
		return reader.readPrescriptionCSV(currentFilePath);
	}
	
	class PrescriptionFileWriter {

		/**
		 * Saves the specified list of prescriptions to the file specified
		 * 
		 * @preconditions filePath != null && prescription != null
		 * @postconditions file contains the prescription data
		 * @param filePath     the path to the file prescriptions are saved too
		 * @param prescription the prescription to be saved
		 */
		public void addPrescriptionToCSV(String filePath, Prescription prescription) {
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
		 * @precondition filePath != null && filePath.isEmpty == false && prescriptions
		 *               != null
		 * @postcondition all prescriptions in list written to csv file
		 * 
		 * @param filePath      the filePath for the storage CSV
		 * @param prescriptions the list of prescriptions to be written to the file
		 */
		public void rewriteCSVFile(String filePath, List<Prescription> prescriptions) {
			if (prescriptions == null) {
				throw new IllegalArgumentException(ExceptionMessages.NULL_PRESCRIPTION);
			}

			try (FileWriter writer = new FileWriter(new File(filePath), false)) {
				String content = "";
				writer.write(content);

				for (Prescription prescription : prescriptions) {
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
		class PrescriptionFileReader {

			/**
			 * Returns a new Prescription List created from the file specified
			 * 
			 * @precondition filePath != null
			 * 
			 * @param filePath the file path of the photo album
			 * 
			 * @return a list of Prescriptions
			 */
			public List<Prescription> readPrescriptionCSV(String filePath) {
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
		}
	}

