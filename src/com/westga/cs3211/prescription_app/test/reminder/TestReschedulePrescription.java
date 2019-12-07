package com.westga.cs3211.prescription_app.test.reminder;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;

class TestReschedulePrescription {

	@Test
	void testReschedulePrescription() {
		int daysBetween = 1;
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now(), daysBetween);
		LocalDateTime originalTime = reminder.getDateTime();
		reminder.reschedulePrescription();
		assertEquals(originalTime, reminder.getDateTime().minusDays(daysBetween));
		assertEquals(false, reminder.hasBeenTaken());
		assertEquals(0, reminder.getTimesReminded());
	}

}
