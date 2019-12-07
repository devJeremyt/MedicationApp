package come.westga.cs3211.prescription_app.test.remindermanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.ReminderManager;

class TestReminderManagerConstructor {

	@Test
	void testValidConstruction() {
		ReminderManager manager = new ReminderManager();
		assertEquals(0, manager.getRemindersBeingDisplayed().size());
	}

}
