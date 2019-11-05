package com.westga.cs3211.prescription_app.test.prescriptionfilewriter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;
import com.westga.cs3211.prescription_app.model.Prescription;

class TestAddPrescriptionToCSV {

	@Test
	void testNulPrescription() {
		assertThrows(IllegalArgumentException.class, ()->{
			PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NotCreated.csv", null);
		});
	}
	
	@Test
	void testNullFilePath() {
		assertThrows(IllegalArgumentException.class, ()->{
			PrescriptionFileWriter.addPrescriptionToCSV(null, new Prescription("Gatorade", false, false, true, 1, 1, 1));
		});
	}
	
	@Test
	void testAddingToEmptyFile() {
		
		PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv", new Prescription("Gatorade", false, false, true, 1, 1, 1));
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv");
		
		assertEquals("Gatorade", prescriptions.get(0).getName());
		assertEquals(false, prescriptions.get(0).avoidDriving());
		assertEquals(false, prescriptions.get(0).withoutAlcohol());
		assertEquals(true, prescriptions.get(0).withFood());
		assertEquals(1, prescriptions.get(0).getRenewFrequency());
		assertEquals(1, prescriptions.get(0).getDosageCount());
		assertEquals(1, prescriptions.get(0).getRefillDosageCount());
		
		try {
			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv");
			eraser.write("");
			eraser.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Test
	void testAddingToNonEmptyFile() {
		
		PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NonEmptyDataSet.csv", new Prescription("Gatorade", false, false, true, 1, 1, 1));
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NonEmptyDataSet.csv");
		
		assertEquals("Gatorade", prescriptions.get(prescriptions.size()-1).getName());
		assertEquals(false, prescriptions.get(prescriptions.size()-1).avoidDriving());
		assertEquals(false, prescriptions.get(prescriptions.size()-1).withoutAlcohol());
		assertEquals(true, prescriptions.get(prescriptions.size()-1).withFood());
		assertEquals(1, prescriptions.get(prescriptions.size()-1).getRenewFrequency());
		assertEquals(1, prescriptions.get(prescriptions.size()-1).getDosageCount());
		assertEquals(1, prescriptions.get(prescriptions.size()-1).getRefillDosageCount());
		
	}
}
