package com.westga.cs3211.prescription_app.test.prescriptionfilereader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileIO;
import com.westga.cs3211.prescription_app.model.Prescription;

class TestReadPrescriptions {

	@Test
	void testSinglePrescription() {
		PrescriptionFileIO reader = new PrescriptionFileIO(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet1.csv");
		
		List<Prescription> prescriptions = reader.readPrescriptionCSV();
		
		assertEquals("Asprin", prescriptions.get(0).getName());
		assertEquals(false, prescriptions.get(0).getAvoidDriving());
		assertEquals(false, prescriptions.get(0).getWithoutAlcohol());
		assertEquals(false, prescriptions.get(0).getWithFood());
		assertEquals(30, prescriptions.get(0).getRenewFrequency());
		assertEquals(5, prescriptions.get(0).getDosageCount());
		assertEquals(31, prescriptions.get(0).getRefillDosageCount());
		
	}
	
	@Test
	void testMultiplePrescriptions() {
		PrescriptionFileIO reader = new PrescriptionFileIO(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet2.csv");
		List<Prescription> prescriptions = reader.readPrescriptionCSV();
		
		assertEquals(3, prescriptions.size());
		
	}
	
	@Test
	void testBrokenFile() {
		PrescriptionFileIO reader = new PrescriptionFileIO(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet3.csv");
		List<Prescription> prescriptions = reader.readPrescriptionCSV();
		
		assertEquals(true, prescriptions.isEmpty());
		
	}
	
	@Test
	void testNoPrescription() {
		PrescriptionFileIO reader = new PrescriptionFileIO(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet3.csv");
		List<Prescription> prescriptions = reader.readPrescriptionCSV();
		
		assertEquals(true, prescriptions.isEmpty());
		
	}
	
}
