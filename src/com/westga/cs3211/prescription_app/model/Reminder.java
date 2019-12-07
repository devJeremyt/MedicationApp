package com.westga.cs3211.prescription_app.model;

import java.time.LocalDateTime;
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
	private LocalDateTime reminderDate;
	private int timesReminded;
	private boolean prescriptionTaken;
	private int daysBetween;

	/**
	 * Instantiates a new reminder.
	 *
	 * @param prescription the prescription
	 * @param reminderDate the reminder date
	 * @param daysBetween  days between taking the medication
	 */
	public Reminder(Prescription prescription, LocalDateTime reminderDate, int daysBetween) {
		this.reminderDate = reminderDate;
		this.daysBetween = daysBetween;
		this.prescription = prescription;
		this.prescriptionTaken = false;
	}

	/**
	 * Gets the prescription.
	 *
	 * @return the prescription
	 */
	public Prescription getPrescription() {
		return this.prescription;
	}

	public LocalDateTime getDateTime() {
		return this.reminderDate;
	}

	public void setDateTime(LocalDateTime time) {
		this.reminderDate = time;
	}

	public void updateTimesReminded() {
		if (LocalDateTime.now().isAfter(this.reminderDate)) {
			if (LocalDateTime.now().isBefore(this.reminderDate.plusMinutes(10))) {
				this.timesReminded = 1;
			} else if (LocalDateTime.now().isBefore(this.reminderDate.plusMinutes(20))) {
				this.timesReminded = 2;
			} else if (LocalDateTime.now().isBefore(this.reminderDate.plusMinutes(30))) {
				this.timesReminded = 3;
			} else if (LocalDateTime.now().isBefore(this.reminderDate.plusMinutes(40))) {
				this.timesReminded = 4;
			} else if (LocalDateTime.now().isBefore(this.reminderDate.plusMinutes(50))) {
				this.timesReminded = 5;
			} else if (LocalDateTime.now().isBefore(this.reminderDate.plusHours(1))) {
				this.timesReminded = 6;
			} else {
				this.timesReminded = 0;
			}
		} else {
			this.timesReminded = 0;
		}
	}

	public int getTimesReminded() {
		return this.timesReminded;
	}

	public void takePrescription() {
		this.prescriptionTaken = true;
		this.timesReminded = 0;
	}

	public void reschedulePrescription() {
		this.setDateTime(this.reminderDate.plusDays(this.daysBetween));
		this.prescriptionTaken = false;
		this.timesReminded = 0;
	}

	public boolean hasBeenTaken() {
		return this.prescriptionTaken;
	}

	@Override
	public String toString() {
		return this.prescription.getName() + ": " + this.reminderDate + " - times reminded: " + this.timesReminded;
	}
}
