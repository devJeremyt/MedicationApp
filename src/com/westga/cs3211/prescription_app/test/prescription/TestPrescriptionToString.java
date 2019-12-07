package com.westga.cs3211.prescription_app.test.prescription;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;

class TestPrescriptionToString {

	@Test
	void testToString() {
		Prescription prescription = new Prescription("Asprin", true, true, true, 20, 3,50, "");
		
		assertEquals("Asprin", prescription.toString());
	}

}
