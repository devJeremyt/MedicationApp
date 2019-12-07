package com.westga.cs3211.prescription_app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;

/**
 * A manager that keeps track of, and edits, the records of various medication.
 * @author Nicolas Sacandy, Fall 2019, 3211
 */

public class MedicationRecordManager {
	
	private static HashMap<String, List<String>> records;

	public MedicationRecordManager() {
		records = PrescriptionFileReader.readMedicalRecordFile();
	}

	public static boolean addNewEvent(Reminder reminder) {
		String wasTaken = reminder.hasBeenTaken() ? "Was Taken" : "Was not taken";

		List<String> medicationRecord = records.get(reminder.getPrescription().getName());

		if (medicationRecord.equals(null)) {
			medicationRecord = new ArrayList<String>();
		}
		medicationRecord.add(reminder.toString() + " Status:" + wasTaken + System.lineSeparator());
		records.put(reminder.getPrescription().getName(), medicationRecord);
		
		PrescriptionFileWriter.rewriteMedicationRecord(records);

		return records.get(reminder.getPrescription().getName()).add(reminder.toString());
	}

	public static List<String> getRecordOfPrescription(Prescription prescription) {
		try {
			List<String> reminders = records.get(prescription.getName());
			List<String> reminderStrings = new ArrayList<String>();
			for (String currReminder : reminders) {
				reminderStrings.add(currReminder.toString());
			}
			
			return reminderStrings;
		} catch (NullPointerException e) {
			List<String> emptyList = new ArrayList<String>();
			emptyList.add("No records yet!");
			return emptyList;
		}

	}

	public static void removePrescriptionRecord(Prescription prescription) {
		records.remove(prescription.getName());
		PrescriptionFileWriter.rewriteMedicationRecord(records);
	}
}
