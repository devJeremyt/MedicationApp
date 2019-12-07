package com.westga.cs3211.prescription_app.test.reminder;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;

class TestToString {

	@Test
	void test() {
		Prescription prescription = new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh");
		Reminder reminder = new Reminder(prescription, LocalDateTime.now(), 1);
		assertEquals(reminder.getPrescription().getName() + ": " + reminder.getDateTime() + " - times reminded: " + reminder.getTimesReminded(), reminder.toString());
	}

}
