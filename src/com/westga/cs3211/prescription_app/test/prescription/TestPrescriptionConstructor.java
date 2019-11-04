package com.westga.cs3211.prescription_app.test.prescription;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.PrescriptionManager;

class TestPrescriptionConstructor {
	
	

	@Test
	void testSuccessfulConstruction() {
		PrescriptionManager manager = new PrescriptionManager();
		
		assertEquals(manager.getPrescriptions().size(), 0);
	}

}
