package com.westga.cs3211.prescription_app.test.reminder;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;

class TestUpdateTimesReminded {

	@Test
	void testUpdateTimesRemindedOne() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(9), 1);
		reminder.updateTimesReminded();
		assertEquals(1, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedTwo() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(19), 1);
		reminder.updateTimesReminded();
		assertEquals(2, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedThree() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(29), 1);
		reminder.updateTimesReminded();
		assertEquals(3, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedFour() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(39), 1);
		reminder.updateTimesReminded();
		assertEquals(4, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedFive() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(49), 1);
		reminder.updateTimesReminded();
		assertEquals(5, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedSix() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(59), 1);
		reminder.updateTimesReminded();
		assertEquals(6, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedZeroAfter() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().plusMinutes(9), 1);
		reminder.updateTimesReminded();
		assertEquals(0, reminder.getTimesReminded());
	}
	
	@Test
	void testUpdateTimesRemindedZero() {
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(61), 1);
		reminder.updateTimesReminded();
		assertEquals(0, reminder.getTimesReminded());
	}

}
