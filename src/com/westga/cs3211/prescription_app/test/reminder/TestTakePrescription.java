package com.westga.cs3211.prescription_app.test.reminder;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;

class TestTakePrescription {

	@Test
	void testTakePrescription() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().plusMinutes(9), 1);
		reminder.takePrescription();
		assertEquals(true, reminder.hasBeenTaken());
		assertEquals(0, reminder.getTimesReminded());
	}

}
