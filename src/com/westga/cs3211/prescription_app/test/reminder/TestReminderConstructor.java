package com.westga.cs3211.prescription_app.test.reminder;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;

class TestReminderConstructor {

	@Test
	void testValidConstruction() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now(), 1);
	}
	
	@Test
	void testInvalidPrescription() {
		assertThrows(IllegalArgumentException.class, ()-> new Reminder(null, LocalDateTime.now(), 1));
	}
	
	@Test
	void testInvalidTime() {
		assertThrows(IllegalArgumentException.class, ()-> new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), null, 1));
	}
	
	@Test
	void testInvalidDaysBetween() {
		assertThrows(IllegalArgumentException.class, ()-> new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now(), -1));
	}
	
	@Test
	void testGetPrescription() {
		Prescription prescription = new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh");
		Reminder reminder = new Reminder(prescription, LocalDateTime.now(), 1);
		assertEquals(prescription, reminder.getPrescription());
	}

}
