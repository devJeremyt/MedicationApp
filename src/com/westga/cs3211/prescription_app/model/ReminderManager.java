package com.westga.cs3211.prescription_app.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderManager {

	private ArrayList<Reminder> reminders;
	private ArrayList<Reminder> activeReminders;
	private Timer monitor;

	public ReminderManager() {
		this.reminders = new ArrayList<Reminder>();
		this.monitor = new Timer();
		this.activeReminders = new ArrayList<Reminder>();

	}

	private void rescheduleReminderForNextWeek(Reminder reminder) {
		Calendar newDate = this.getDateOfNextWeek(reminder.getDate());
		Prescription prescription = reminder.getPrescription();
		Reminder newReminder = new Reminder(prescription, newDate, 0);
		this.reminders.remove(reminder);
	}

	private Calendar getDateOfNextWeek(Calendar date) {
		date.add(date.get(Calendar.DATE), 7);
		return date;
	}

	public boolean add(Reminder reminder) {
		return this.add(reminder);
	}
	
	private class MonitorTimerTask extends TimerTask {
		
		//TODO: Account for medication not taken, also don't reschedule reminders if they are 10 minute reminders.
		@Override
		public void run() {
			for (Reminder reminder : ReminderManager.this.reminders) {
				if (reminder.hasFired()) {
					ReminderManager.this.activeReminders.add(reminder);
					ReminderManager.this.rescheduleReminderForNextWeek(reminder);
					
					Calendar newTime = reminder.getDate();
					newTime.add(newTime.MINUTE, 10);
					
					ReminderManager.this.add(new Reminder(reminder.getPrescription(), newTime, reminder.getTimesReminded() + 1));
				}
			}
			
		}
		
	}

}
