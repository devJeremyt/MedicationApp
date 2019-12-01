package com.westga.cs3211.prescription_app.model;

import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Class Reminder.
 * 
 * @author Michael Jiles
 */
public class Reminder {

	private Prescription prescription;
	private Timer reminderTimer;
	private ReminderTimerTask reminderTask;
	private Calendar reminderDate;
	private boolean reminderFired;
	private int timesReminded;

	/**
	 * The Class ReminderTimerTask.
	 */
	private class ReminderTimerTask extends TimerTask {

		/**
		 * Run.
		 */
		@Override
		public void run() {
			Reminder.this.reminderFired = true;
			Reminder.this.disableReminder();
		}
	}

	/**
	 * Instantiates a new reminder.
	 *
	 * @param prescription the prescription
	 * @param reminderDate the reminder date
	 */
	public Reminder(Prescription prescription, Calendar reminderDate, int timesReminded) {
		this.reminderDate = reminderDate;
		this.prescription = prescription;
		this.reminderTimer = new Timer();
		this.reminderTask = new ReminderTimerTask();
		this.reminderTimer.schedule(this.reminderTask, this.reminderDate.getTime());
		this.reminderFired = false;
		this.timesReminded = timesReminded;
	}

	/**
	 * Disable reminder.
	 */
	public void disableReminder() {
		this.reminderTimer.cancel();
	}

	/**
	 * Gets the prescription.
	 *
	 * @return the prescription
	 */
	public Prescription getPrescription() {
		return this.prescription;
	}

	/**
	 * Reminder has fired.
	 *
	 * @return true, if successful
	 */
	public boolean hasFired() {
		return this.reminderFired;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Calendar getDate() {
		return this.reminderDate;
	}
	
	
	public int getTimesReminded() {
		return this.timesReminded;
	}
}
