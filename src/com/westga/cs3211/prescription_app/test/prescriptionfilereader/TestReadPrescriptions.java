package com.westga.cs3211.prescription_app.test.prescriptionfilereader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.model.Prescription;

class TestReadPrescriptions {

	@Test
	void testSinglePrescription() {
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet1.csv");
		
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
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet2.csv");
		
		assertEquals(3, prescriptions.size());
		
	}
	
	@Test
	void testBrokenFile() {
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet3.csv");
		
		assertEquals(true, prescriptions.isEmpty());
		
	}
	
	@Test
	void testNoPrescription() {
		
		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilereader\\testDataSet3.csv");
		
		assertEquals(true, prescriptions.isEmpty());
		
	}
	
	@Test
	void testFilePathNull() {
		
		assertThrows(IllegalArgumentException.class, ()->PrescriptionFileReader.readPrescriptionCSV(null));
	}

}
