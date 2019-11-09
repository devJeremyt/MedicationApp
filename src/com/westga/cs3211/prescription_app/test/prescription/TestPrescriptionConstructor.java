package com.westga.cs3211.prescription_app.test.prescription;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;

class TestPrescriptionConstructor {

	@Test
	void testRenewFrequencyIsLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()-> new Prescription("Water", false, true, false, -1, 5, 2, "Take Meds"));
	}
	
	@Test
	void testDosageIsLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()-> new Prescription("Water", false, true, false, 2, -1, 2, "Take Meds"));
	}
	
	@Test
	void testRefillIsLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()-> new Prescription("Water", false, true, false, -1, 5, 2, "Take Meds"));
	}
	
	@Test
	void testSuccessfulCreation() {
		Prescription prescription = new Prescription("Water", false, true, false, 7, 5, 2, "Take Meds");
		
		assertEquals("Water", prescription.getName());
		assertEquals(false, prescription.getAvoidDriving());
		assertEquals(true, prescription.getWithoutAlcohol());
		assertEquals(false, prescription.getWithFood());
		assertEquals(7, prescription.getRenewFrequency());
		assertEquals(5, prescription.getDosageCount());
		assertEquals(2, prescription.getRefillDosageCount());
		assertEquals("Take Meds", prescription.getInstructions());
	}

}
