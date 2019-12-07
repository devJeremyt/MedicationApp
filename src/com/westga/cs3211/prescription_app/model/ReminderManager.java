package com.westga.cs3211.prescription_app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderManager {

	private ArrayList<Reminder> reminders;
	private ArrayList<Reminder> remindersBeingDisplayed;
	private Timer monitor;

	public ReminderManager() {
		this.reminders = new ArrayList<Reminder>();
		this.remindersBeingDisplayed = new ArrayList<Reminder>();
		this.monitor = new Timer();
		this.monitor.scheduleAtFixedRate(new ReminderTimerTask(), 0, 1000);
	}

	public boolean add(Reminder reminder) {
		return this.reminders.add(reminder);
	}
	
	public ArrayList<Reminder> getRemindersBeingDisplayed() {
		return this.remindersBeingDisplayed;
	}
	
	/**
	 * The Class ReminderTimerTask.
	 */
	private class ReminderTimerTask extends TimerTask {

		/**
		 * Run.
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
				if (this.reminderTimeIsInPast(reminder)) {
					reminder.increaseTimesReminded();
					if (!ReminderManager.this.remindersBeingDisplayed.contains(reminder)) {
						ReminderManager.this.remindersBeingDisplayed.add(reminder);
					}
					if (reminder.getTimesReminded() > 6) {
						//TODO Record medication is not taken.
						reminder.reschedulePrescription();
						ReminderManager.this.remindersBeingDisplayed.remove(reminder);
					}
				}
			}
		}
		
		private boolean reminderTimeIsInPast(Reminder reminder) {
			return reminder.getDateTime().plusMinutes(reminder.getTimesReminded() * 10).isBefore(LocalDateTime.now());
		}
	}

}
