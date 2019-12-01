package com.westga.cs3211.prescription_app.model;

import java.util.Date;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

	private Prescription prescription;
	private static Timer reminderTimer;
	private static ReminderTimerTask reminderTask;
	public static boolean reminderFiring;
	public static int remindCount;
	private Date nextScheduledTime;
	private Queue<Date> reminderDates;

	private class ReminderTimerTask extends TimerTask {

		@Override
		public void run() {
			Reminder.reminderFiring = true;
			remindCount++;
			if (remindCount <= 6) {
				reminderTimer.schedule(task, time);
			}
		}
	}

	public Reminder(Prescription prescription, Queue<Date> reminderDates) {
		if (reminderDates.isEmpty()) {
			throw new IllegalArgumentException("No valid dates passed in.");
		}
		this.reminderDates = reminderDates;
		this.prescription = prescription;
		reminderTimer = new Timer();
		this.reminderTask = new ReminderTimerTask();
		reminderTimer.schedule(this.reminderTask, this.reminderDates.remove());
		reminderFiring = false;
	}

	public void disableReminder() {
		reminderTimer.cancel();
		reminderFiring = false;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setNextReminder() {
		if (!this.reminderDates.isEmpty()) {
			reminderTimer.schedule(this.reminderTask, this.reminderDates.remove());
		}
	}
}
