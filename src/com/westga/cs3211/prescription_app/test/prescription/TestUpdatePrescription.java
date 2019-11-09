package com.westga.cs3211.prescription_app.test.prescription;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;

class TestUpdatePrescription {

	@Test
	void testSuccessfullyUpdate() {
		Prescription prescription = new Prescription("Pill", false, false, false, 1,2,3,"Insert");
		
		prescription.update(3, 3, 4,  "Flip");
		
		assertEquals("Pill", prescription.getName());
		assertEquals(false, prescription.getAvoidDriving());
		assertEquals(false, prescription.getWithoutAlcohol());
		assertEquals(false, prescription.getWithFood());
		assertEquals(3, prescription.getRenewFrequency());
		assertEquals(3, prescription.getDosageCount());
		assertEquals(4, prescription.getRefillDosageCount());
		assertEquals("Flip", prescription.getInstructions());
	}
	
	@Test
	void testRenewFrequencyLessThanZero() {
		
		Prescription prescription = new Prescription("Pill", false, false, false, 1,2,3,"Insert");
		
		assertThrows(IllegalArgumentException.class, ()-> prescription.update(-1, 2, 3, "Do Something"));
	}
	
	@Test
	void testDosageCountLessThanZero() {
		
		Prescription prescription = new Prescription("Pill", false, false, false, 1,2,3,"Insert");
		
		assertThrows(IllegalArgumentException.class, ()-> prescription.update(1, -2, 3, "Do Something"));
	}
	
	@Test
	void testRefillDosageCountLessThanZero() {
		
		Prescription prescription = new Prescription("Pill", false, false, false, 1,2,3,"Insert");
		
		assertThrows(IllegalArgumentException.class, ()-> prescription.update(1, 2, -3, "Do Something"));
	}

}
