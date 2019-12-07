package com.westga.cs3211.prescription_app.viewmodel;

import java.time.LocalDateTime;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.PrescriptionManager;
import com.westga.cs3211.prescription_app.model.Reminder;
import com.westga.cs3211.prescription_app.model.ReminderManager;
import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.model.SideEffectManager;
import com.westga.cs3211.prescription_app.resources.StaticFields;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * The viewmodel object for the Prescription App
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class PrescriptionAppViewModel {
	
	private PrescriptionManager prescriptionManager;
	private ReminderManager reminderManager;
	
	private SideEffectManager sideEffectsManager;
	private ListProperty<SideEffect> sideEffectsListProperty;
	private ListProperty<Prescription> prescriptionListProperty;
	private BooleanProperty emptyPrescriptionList;
	private ListProperty<Reminder> reminderListProperty;
	
	/**
	 * Creates a new PrescriptionAppViewModel
	 * 
	 * @precondition none
	 * @postcondition new PrescriptionAppViewModel is created
	 * 
	 */
	public PrescriptionAppViewModel() {
		this.prescriptionManager = new PrescriptionManager();
		this.reminderManager = new ReminderManager();
		this.sideEffectsManager = new SideEffectManager(StaticFields.SIDE_EFFECTS_FILE);
		this.prescriptionListProperty = new SimpleListProperty<Prescription>();
		this.reminderListProperty = new SimpleListProperty<Reminder>();
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.prescriptionManager.getPrescriptions()));
		this.reminderListProperty.set(FXCollections.observableArrayList(this.reminderManager.getRemindersBeingDisplayed()));
		this.sideEffectsListProperty = new SimpleListProperty<SideEffect>();
		this.sideEffectsListProperty.set(FXCollections.observableArrayList(this.sideEffectsManager.getSideEffects()));
		this.emptyPrescriptionList = new SimpleBooleanProperty(true);
	}


	/**
	 * Boolean Property for if the list of prescription is empty
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the list is empty else false
	 */
	public BooleanProperty emptyPrescriptionList() {
		return this.emptyPrescriptionList;
	}
	
	/**
	 * Creates a new reminder for the prescription specified
	 * 
	 * @precondition none
	 * @postcondition new reminder is created
	 * 
	 * @param prescription the prescription the reminder is for
	 * @param reminderDate the first date the prescription is to be taken
	 * @param daysBetween the frequency in days the prescription is to be taken
	 */
	public void addReminder(Prescription prescription, LocalDateTime reminderDate, int daysBetween) {
		this.reminderManager.add(new Reminder(prescription, reminderDate, daysBetween));
	}
	
	/**
	 * Updates the reminderListProperty to display what is contained in the remindersBeingDisplayed list
	 * 
	 * @precondition none
	 * @postcondition  reminderListProperty is updated to display what is contained in the remindersBeingDisplayed list
	 */
	public void updateRemindersBeingDisplayed() {
		this.reminderListProperty.set(FXCollections.observableArrayList(this.reminderManager.getRemindersBeingDisplayed()));
	}

	/**
	 * Updates the specified prescription to the list of prescriptions
	 * 
	 * @precondition none
	 * @postcondition the specified prescription is added to the list of prescriptions
	 * 
	 * @param prescription the prescription to be added
	 * @param renewFrequency the frequency to renew
	 * @param dosageCount the count of current doses
	 * @param refillDosageCount the number of doses that come in a refill
	 * @param instructions describes how to take the prescription
	 */
	public void updatePrescription(Prescription prescription, int renewFrequency, int dosageCount, int refillDosageCount, String instructions) {
		this.prescriptionManager.update(prescription, renewFrequency, dosageCount, refillDosageCount, instructions);
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.prescriptionManager.getPrescriptions()));
	}

	/**
	 * Updates the specified prescription
	 * 
	 * @precondition none
	 * @postcondition the specified prescription is added to the list of prescriptions
	 * 
	 * @param prescription the prescription to be added
	 */
	public void addPrescription(Prescription prescription) {
		this.prescriptionManager.add(prescription);
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.prescriptionManager.getPrescriptions()));
	}
	
	/**
	 * Returns the Prescription List Property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the prescription list property
	 */
	public ListProperty<Prescription> prescriptionListProperty() {
		return this.prescriptionListProperty;
	}
	
	
	/**
	 * Removes the selected prescription
	 * 
	 * @precondition none
	 * @postcondition prescription is removed from list and file
	 * @param prescription the prescription to be removed
	 */
	
	public void removePrescription(Prescription prescription) {
		this.prescriptionManager.remove(prescription);
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.prescriptionManager.getPrescriptions()));
	}

	/**
	 * Returns the SideEffects list property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list property of sideEffects
	 */
	public ListProperty<SideEffect> sideEffectListProperty() {
		return this.sideEffectsListProperty;
	}
	
	/**
	 * Returns the Reminder List property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list property of reminders
	 */
	public ListProperty<Reminder> reminderListProperty() {
		return this.reminderListProperty;
	}

	/**
	 * Removes the specified sideEffect
	 * 
	 * @precondition none
	 * @postcondition sideEffect is removed, and list view is updated
	 * 
	 * @param sideEffect the side effect to be removed
	 */
	public void removeSideEffect(SideEffect sideEffect) {
		this.sideEffectsManager.remove(sideEffect);
		this.sideEffectsListProperty.set(FXCollections.observableArrayList(this.sideEffectsManager.getSideEffects()));
		
	}
	
	/**
	 * Adds the specified sideEffect
	 * 
	 * @precondition none
	 * @postcondition sideEffect is added, and list view is updated
	 * 
	 * @param sideEffect the side effect to be added
	 */
	public void addSideEffect(SideEffect sideEffect) {
		this.sideEffectsManager.add(sideEffect);
		this.sideEffectsListProperty.set(FXCollections.observableArrayList(this.sideEffectsManager.getSideEffects()));
		
	}
	
	/**
	 * Updates the specified sideEffect
	 * 
	 * @precondition none
	 * @postcondition the specified prescription is updated
	 * 
	 * @param sideEffect the sideEffect being update
	 * @param description the updated description
	 * @param dateTime the updated LocalDateTime
	 */
	public void updateSideEffect(SideEffect sideEffect, String description, LocalDateTime dateTime) {
		this.sideEffectsManager.update(sideEffect, description, dateTime);
		this.sideEffectsListProperty.set(FXCollections.observableArrayList(this.sideEffectsManager.getSideEffects()));
	}


	/**
	 * Confirms that the medication in the passed in reminder has been taken
	 * 
	 * @precondition none
	 * @postcondition the reminderManager performs confirmMedicationTaken
	 * @param selectedItem the reminder to be confirmed
	 */
	public void confirmMedTaken(Reminder selectedItem) {
		this.reminderManager.confirmMedicationTaken(selectedItem);
		
	}
	
	
}
