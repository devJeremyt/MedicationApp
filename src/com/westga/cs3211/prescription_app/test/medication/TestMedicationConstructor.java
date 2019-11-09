package com.westga.cs3211.prescription_app.test.medication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Medication;

class TestMedicationConstructor {

	@Test
	void testSuccessfulConstructor() {
		Medication med = new Medication("Water", false, false, false);
		
		assertEquals("Water",med.getName());
		assertEquals(false, med.getAvoidDriving());
		assertEquals(false, med.getWithFood());
		assertEquals(false, med.getWithoutAlcohol());
		
	}

	@Test
	void testNameIsEmpty() {	
		assertThrows(IllegalArgumentException.class, ()->{
			new Medication("", false, false, false);
		});
		
	}
	
	@Test
	void testNameIsNull() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Medication(null, false, false, false);
		});
		
		
	}
}
