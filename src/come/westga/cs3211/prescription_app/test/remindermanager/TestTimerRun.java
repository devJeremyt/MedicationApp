package come.westga.cs3211.prescription_app.test.remindermanager;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;
import com.westga.cs3211.prescription_app.model.ReminderManager;

class TestTimerRun {

	@Test
	void testRun() {
		ReminderManager manager  = new ReminderManager();
		Reminder reminder = new Reminder(new Prescription("Yeah", false, false, false, 1, 1, 1, "Oh"), LocalDateTime.now().minusMinutes(9), 1);
		reminder.updateTimesReminded();
		manager.add(reminder);
		assertTrue(manager.getRemindersBeingDisplayed().contains(reminder));
	}

}
