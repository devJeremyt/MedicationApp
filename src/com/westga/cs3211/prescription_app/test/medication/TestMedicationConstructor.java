package com.westga.cs3211.prescription_app.test.medication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Medication;

class TestMedicationConstructor {

	@Test
	void testSuccessfulConstructor() {
		Medication med = new Medication("Water", false, false, false);
		
		assertEquals("Water",med.getName());
		assertEquals(false, med.isWhileDriving());
		assertEquals(false, med.isWithFood());
		assertEquals(false, med.isWithoutAlcohol());
		
	}

}
