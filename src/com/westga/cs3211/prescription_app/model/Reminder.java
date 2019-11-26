package com.westga.cs3211.prescription_app.model;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class Reminder {
	
	private Prescription prescription;
	private Timer reminderTimer;
	private ReminderTimerTask reminderTask;
	private static boolean reminderFiring;
	private static int remindCount;
	
	private class ReminderTimerTask extends TimerTask {
		
		@Override
		public void run() {
			Reminder.reminderFiring = true;
			Reminder.remindCount++;
		}
	}
	
	public Reminder(Prescription prescription, Date reminderDate) {
		this.prescription = prescription;
		this.reminderTimer = new Timer();
		this.reminderTask = new ReminderTimerTask();
		this.reminderTimer.scheduleAtFixedRate(reminderTask, reminderDate, 600000);
		reminderFiring = false;
		remindCount = 0;
	}
	
	public void disableReminder() {
		this.reminderTimer.cancel();
		remindCount = 0;
		reminderFiring = false;
	}
}
