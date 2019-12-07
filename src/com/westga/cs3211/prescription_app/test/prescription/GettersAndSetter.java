package com.westga.cs3211.prescription_app.test.prescription;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;

class GettersAndSetter {

	@Test
	void testSetRenewFrequency() {
		Prescription prescription = new Prescription("Water", false, true, false, 7, 5, 2, "Take Meds");
		
		prescription.setRenewFrequency(3);
		
		assertEquals(3, prescription.getRenewFrequency());
	}

	@Test
	void testSetRefillDosage() {
		Prescription prescription = new Prescription("Water", false, true, false, 7, 5, 2, "Take Meds");
		
		prescription.setRefillDosageCount(3);
		
		assertEquals(3, prescription.getRefillDosageCount());
	}
	
	@Test
	void testSetIsActive() {
		Prescription prescription = new Prescription("Water", false, true, false, 7, 5, 2, "Take Meds");
		
		prescription.setActive(false);
		
		assertEquals(false, prescription.isActive());
	}
}
