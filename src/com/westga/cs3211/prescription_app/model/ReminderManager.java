package com.westga.cs3211.prescription_app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Timer;
import java.util.TimerTask;


/**
 * The Class ReminderManager.
 */
public class ReminderManager {

	private ArrayList<Reminder> reminders;
	private ArrayList<Reminder> remindersBeingDisplayed;
	private Timer monitor;

	/**
	 * Instantiates a new reminder manager.
	 * 
	 * @precondition none
	 * @postcondition reminders and remindersBeingDisplayed are instantiated, and the monitor Timer object
	 * is set to execute every second.
	 */
	public ReminderManager() {
		this.reminders = new ArrayList<Reminder>();
		this.remindersBeingDisplayed = new ArrayList<Reminder>();
		this.monitor = new Timer();
		this.monitor.scheduleAtFixedRate(new ReminderTimerTask(), 0, 1000);
	}

	/**
	 * Adds the.
	 * 
	 * @precondition none
	 * @postcondition the reminder is added to the reminders list
	 *
	 * @param reminder the reminder
	 * @return true, if successful
	 */
	public boolean add(Reminder reminder) {
		return this.reminders.add(reminder);
	}
	
	/**
	 * Gets the reminders being displayed.
	 * 
	 *
	 * @return the reminders being displayed
	 */
	public ArrayList<Reminder> getRemindersBeingDisplayed() {
		return this.remindersBeingDisplayed;
	}
	
	/**
	 * Confirm medication taken.
	 * 
	 * @precondition none
	 * @postcondition the passed in medication is taken, and it is recorded in the records.
	 *
	 * @param reminderToConfirm the reminder to confirm
	 */
	public void confirmMedicationTaken(Reminder reminderToConfirm) {
		for (Reminder reminder : this.remindersBeingDisplayed) {
			if (reminderToConfirm == reminder) {
				//TODO Confirm Medication is Taken in Records
				reminder.takePrescription();
			}
		}
		
		for (Reminder reminder : this.reminders) {
			if (reminderToConfirm == reminder) {
				reminder.takePrescription();
			}
		}
	}
	
	/**
	 * The Class ReminderTimerTask.
	 */
	private class ReminderTimerTask extends TimerTask {

		/**
		 * Runs the timer responsibilities.
		 */
		@Override
		public void run() {
			for (Reminder reminder : ReminderManager.this.reminders) {
				if (reminder.hasBeenTaken()) {
					reminder.reschedulePrescription();
					ReminderManager.this.remindersBeingDisplayed.remove(reminder);
				}
			}
			
			for (Reminder reminder : ReminderManager.this.reminders) {
				reminder.updateTimesReminded();
				if (this.reminderTimeIsInPast(reminder)) {
					if (!ReminderManager.this.remindersBeingDisplayed.contains(reminder)) {
						ReminderManager.this.remindersBeingDisplayed.add(reminder);
					}
					if (reminder.getTimesReminded() == 6) {
						//TODO Record medication is not taken.
						reminder.reschedulePrescription();
						ReminderManager.this.remindersBeingDisplayed.remove(reminder);
					}
				}
			}
			
			for (Reminder reminder: ReminderManager.this.remindersBeingDisplayed) {
				reminder.updateTimesReminded();
			}
		}
		
		/**
		 * Reminder time is in past.
		 * 
		 * @precondition none
		 * @postcondition none
		 *
		 * @param reminder the reminder
		 * @return true, if successful
		 */
		private boolean reminderTimeIsInPast(Reminder reminder) {
			return reminder.getDateTime().isBefore(LocalDateTime.now());
		}
	}

}
