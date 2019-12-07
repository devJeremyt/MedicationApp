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
	 * @param daysBetween days between taking the medication
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
		this.reminderDate = time;;
	}
	
	public void increaseTimesReminded() {
		this.timesReminded++;
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
	}
	
	public boolean hasBeenTaken() {
		return this.prescriptionTaken;
	}
}
