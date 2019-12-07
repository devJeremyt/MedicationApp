package com.westga.cs3211.prescription_app.model;

import java.time.LocalDateTime;

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
	 * @precondition none
	 * @postcondition reminderDate, daysBetween, and prescription are set to passed in parameters.
	 * prescriptionTaken is set to false.
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

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	public LocalDateTime getDateTime() {
		return this.reminderDate;
	}

	/**
	 * Sets the date time.
	 * 
	 * @precondition none
	 * @postcondition the reminderDate is set to the passed in parameter
	 *
	 * @param time the new date time
	 */
	public void setDateTime(LocalDateTime time) {
		this.reminderDate = time;
	}

	/**
	 * Update times reminded depending on the current time.
	 * 
	 * @precondition none
	 * @postcondition the timesReminded variable is updated based on the current time.
	 */
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

	/**
	 * Gets the times reminded.
	 *
	 * @return the times reminded
	 */
	public int getTimesReminded() {
		return this.timesReminded;
	}

	/**
	 * Takes the prescription.
	 * 
	 * @precondition none
	 * @postcondition prescriptionTaken is set to true, and timesReminded is set to 0
	 * 
	 */
	public void takePrescription() {
		this.prescriptionTaken = true;
		this.timesReminded = 0;
	}

	/**
	 * Reschedule prescription.
	 * 
	 * @precondition none
	 * @postcondition the daysBetween days are added to the reminderDate, prescriptionTaken is set to false, and timesReminded is set to 0.
	 */
	public void reschedulePrescription() {
		this.setDateTime(this.reminderDate.plusDays(this.daysBetween));
		this.prescriptionTaken = false;
		this.timesReminded = 0;
	}

	/**
	 * Checks for been taken.
	 *
	 * @return true, if successful
	 */
	public boolean hasBeenTaken() {
		return this.prescriptionTaken;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.prescription.getName() + ": " + this.reminderDate + " - times reminded: " + this.timesReminded;
	}
}
