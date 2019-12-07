package com.westga.cs3211.prescription_app.test.medication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Medication;

class GettersAndSetters {

	@Test
	void testSetName() {
		Medication med = new Medication("Water", false, false, false);
		
		med.setName("Booger");
		assertEquals("Booger", med.getName());
	}
	
	@Test
	void testSetAvoidDriving() {
		Medication med = new Medication("Water", false, false, false);
		
		med.setAvoidDriving(true);
		assertEquals(true, med.getAvoidDriving());
	}
	
	@Test
	void testSetWithoutAlcohol() {
		Medication med = new Medication("Water", false, false, false);
		
		med.setWithoutAlcohol(true);
		assertEquals(true, med.getWithoutAlcohol());
	}
	
	@Test
	void testSetWithFood() {
		Medication med = new Medication("Water", false, false, false);
		
		med.setWithFood(true);
		assertEquals(true, med.getWithFood());
	}


}
